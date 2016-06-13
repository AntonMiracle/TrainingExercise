/**
 * Project: TrainingExercise Cities.java
 */
package com.implemica.cities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.implemica.Runner;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Cities {
	private City			start;
	private City			end;
	private int				numCities;
	private int				numTests;
	private int				numPath;
	private List<City>		cities	= new ArrayList<City>();
	private List<String>	paths	= new ArrayList<String>();
	private Scanner	scn;

	public Cities() {
		this.scn = Runner.scn;	 
	}

	/**
	 * Constructor for cloning
	 * 
	 * @param start
	 *        set City which start flag is true
	 * @param end
	 *        set City which end flag is true
	 * @param numCities
	 *        value of cities
	 * @param numTests
	 *        value of tests
	 * @param numPath
	 *        value of paths
	 * @param cities
	 *        collection of the cities
	 * @param paths
	 *        collection of the paths
	 */
	public Cities(City start, City end, int numCities, int numTests, int numPath, List<City> cities,
			List<String> paths) {
		super();
		this.start = start;
		this.end = end;
		this.numCities = numCities;
		this.numTests = numTests;
		this.numPath = numPath;
		this.cities = new ArrayList<City>(cities);
		this.paths = new ArrayList<String>(paths);
	}

	/**
	 * Solution for Task #2 Find shortest path from start to end City Basic
	 * algorithm is open Edsger Wybe Dijkstra. Where graf is shortest transfer
	 * distance from start to end
	 */
	public void solution() {
		print(true, "INPUT");
		setNumTests();
		setNumCities();
		int count = 1;
		do {
			print(true, "TEST # " + new Integer(count).toString());
			setCities();
			setPaths();

			System.out.println("-- PATHS --");
			for (String path : getPaths()) {
				System.out.println(path);
				setStartFinishCity(path);
				Set<City> row = new HashSet<City>();
				row.add(getStart());
				cheapCost(getStart(), getEnd(), row);
				if (getEnd().getGrafMark() < Integer.MAX_VALUE) {
					System.out.println(getEnd().getGrafMark());
				} else {
					System.out.println("Connection not found");
				}

			}
		} while (count < getNumTests());
	}

	/**
	 * Create city and add to collection of the cities
	 */
	private void setCities() {
		print(false, "Set citites atribut");
		for (int i = 1; i <= getNumCities(); i++) {
			getCities().add(new City(i));
		}
	}

	/**
	 * Create path and add to the paths collection
	 */
	private void setPaths() {
		print(false, "Number of path");
		setNumPath(Integer.parseInt(scn.next()));
		for (int i = 0; i < getNumPath(); i++) {
			print(false, "Path #" + new Integer(i + 1).toString());
			String start = scn.next();
			String end = scn.next();
			String path = start + " " + end;
			getPaths().add(path);
		}
	}

	/**
	 * Find start and end city from collection of the cities
	 * 
	 * @param path
	 *        current path where search cheap path
	 */
	private void setStartFinishCity(String path) {
		// находим стартовые города, сплитируя пас на массив
		boolean isStartFind = false;
		boolean isEndFind = false;
		for (City c : getCities()) {
			c.clearData();
		}
		for (City c : getCities()) {
			if (!(isStartFind) && c.getName().equals(path.split(" ")[0])) {
				setStart(c);
				getStart().setStart(true);
				isStartFind = true;
			}
			if (!(isEndFind) && c.getName().equals(path.split(" ")[1])) {
				setEnd(c);
				getEnd().setEnd(true);
				isEndFind = true;
			}
		}
	}

	/**
	 * Method find cheapest cost from current and next Cities
	 * 
	 * @param currentCity
	 *        where search cheapest path
	 * @param end
	 *        end City
	 * @param row
	 *        collection of the cities which are passed already
	 */
	public void cheapCost(City currentCity, City end, Set<City> row) {
		City nextCity = null;
		for (City checkCity : getCities()) {
			if (row.contains(checkCity)) {
				continue;
			} else {
				if (currentCity.getTransportCost().containsKey(checkCity.getId())) {
					int nextGraf = currentCity.getGrafMark() + currentCity.getTransportCost().get(checkCity.getId());
					if (checkCity.getGrafMark() < Integer.MAX_VALUE) {
						if (checkCity.getGrafMark() > nextGraf) {
							checkCity.setGrafMark(nextGraf);
						}
					} else {
						checkCity.setGrafMark(nextGraf);
					}
				}
			}
		}
		nextCity = minimumGraf(row);
		if (row.size() != getCities().size()) {
			row.add(nextCity);
			cheapCost(nextCity, end, row);
		}
	}

	/**
	 * Find minimum graf mark from collection of the cities
	 * 
	 * @param row
	 *        collection of the cities which are passed already
	 * @return City which has cheapest cost of the transfer
	 */
	private City minimumGraf(Set<City> row) {
		City city = null;
		for (City currentCity : getCities()) {
			if (row.contains(currentCity)) {
				continue;
			} else {
				if (city == null) {
					city = currentCity;
				} else {
					if (city.getGrafMark() > currentCity.getGrafMark()) {
						city = currentCity;
					}
				}
			}
		}
		return city;
	}

	/**
	 * Set number of the tests. If number not from 1 to 10, input data need
	 * repeat
	 */
	private void setNumTests() {
		do {
			Cities.print(false, "Number of tests");
			setNumTests(Integer.valueOf(scn.next()));
		} while (isOutLimit(getNumTests(), 10));
	}

	/**
	 * Set number of the Cities. If number not from 1 to 10_000, input data need
	 * repeat
	 */
	private void setNumCities() {
		do {
			Cities.print(false, "Number of cities(maximum 10000)");
			setNumCities(scn.nextInt());
		} while (isOutLimit(getNumCities(), 10000));

	}

	/**
	 * Testing solution, without input data.
	 */
	public void testSolution() {
		cities = City.testCity();
		paths = City.testPaths();
		System.out.println("-- PATHS --");
		for (String path : getPaths()) {
			System.out.println(path);
			setStartFinishCity(path);
			Set<City> row = new HashSet<City>();
			row.add(getStart());
			cheapCost(getStart(), getEnd(), row);
			if (getEnd().getGrafMark() < Integer.MAX_VALUE) {
				System.out.println(getEnd().getGrafMark());
			} else {
				System.out.println("Connection not found");
			}

		}
	}

	/**
	 * Method which is print into console. use some format.
	 * 
	 * @param isTitle
	 *        if true excrete text
	 * @param text
	 *        which need to print into console
	 */
	public static void print(boolean isTitle, String text) {
		String print = "";
		String title = "";
		if (isTitle) {
			if (text.length() != 0) {
				int startPrintText = (50 - text.length()) / 2;
				for (int i = 0; i < 49 - text.length(); i++) {
					title += i == startPrintText ? " " + text + " " : "-";
				}
			} else {
				for (int i = 0; i < 50; i++) {
					title += "-";
				}
			}
			print = String.format("%-50s|", title);
		} else {
			print = String.format("%-50s|", text);
		}
		System.out.println(print);
	}

	/**
	 * Check input number. True if number is in the limit
	 * 
	 * @param checkNum
	 *        number which need to check
	 * @param maxNum
	 *        num which set limit from ZERO to maxNum
	 * @return true if number is in the limit
	 */
	public static boolean isOutLimit(int checkNum, int maxNum) {
		if (checkNum >= maxNum && checkNum > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Cities clone() throws CloneNotSupportedException {
		return new Cities(getStart(), getEnd(), getNumCities(), getNumTests(), getNumPath(), getCities(), getPaths());
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cities) {
			if (((Cities) obj).getNumTests() == getNumTests() && ((Cities) obj).getCities() == getCities()) {
				if (((Cities) obj).getCities().containsAll(getCities())) {
					return true;
				}
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		setStart(null);
		setEnd(null);
		setCities(null);
		setPaths(null);
		setScn(null);
	}

	/** Setter */
	private void setStart(City start) {
		this.start = start;
	}

	/** Setter */
	private void setEnd(City end) {
		this.end = end;
	}

	/** Setter */
	private void setNumCities(int numCities) {
		this.numCities = numCities;
	}

	/** Setter */
	private void setNumTests(int numTests) {
		this.numTests = numTests;
	}

	/** Setter */
	private void setNumPath(int numPath) {
		this.numPath = numPath;
	}

	/** Getter */
	public City getStart() {
		return start;
	}

	/** Getter */
	public City getEnd() {
		return end;
	}

	/** Getter */
	public int getNumCities() {
		return numCities;
	}

	/** Getter */
	public int getNumTests() {
		return numTests;
	}

	/** Getter */
	public int getNumPath() {
		return numPath;
	}

	/** Getter */
	public List<City> getCities() {
		return cities;
	}

	/** Getter */
	public List<String> getPaths() {
		return paths;
	}

	/** Getter */
	public Scanner getScn() {
		return scn;
	}

	/** Setter */
	private void setCities(List<City> cities) {
		this.cities = cities;
	}

	/** Setter */
	private void setPaths(List<String> paths) {
		this.paths = paths;
	}

	/** Setter */
	private void setScn(Scanner scn) {
		this.scn = scn;
	}

}
