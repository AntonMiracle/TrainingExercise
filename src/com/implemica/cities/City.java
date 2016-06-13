/**
 * Project: TrainingExercise City.java
 */
package com.implemica.cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class City {
	boolean							start;
	boolean							end;
	private int						grafMark		= Integer.MAX_VALUE;
	private int						id;
	private String					name;
	private Map<Integer, Integer>	transportCost	= new HashMap<Integer, Integer>();
	private int						numConnectedCity;
	Scanner							scn				= new Scanner(System.in);

	public City() {

	}

	/**
	 * Cunstructor
	 * 
	 * @param id
	 *        city id
	 */
	public City(int id) {
		setId(id);
		createCity();
	}

	/**
	 * Constructor for cloning
	 * 
	 * @param start
	 *        true if city is first in the row
	 * @param end
	 *        true if city is end of row
	 * @param grafMark
	 *        minimum length from start city. If length equals Integer.MAX_VALUE
	 *        city hasn`t connection with start city
	 * @param id
	 *        city id
	 * @param name
	 *        city name
	 * @param transportCost
	 *        collection of connection with another cities and tranfer cost
	 * @param numConnectedCity
	 *        number of cities where city has connection
	 */
	public City(boolean start, boolean end, int grafMark, int id, String name, Map<Integer, Integer> transportCost,
			int numConnectedCity) {
		super();
		this.start = start;
		this.end = end;
		this.grafMark = grafMark;
		this.id = id;
		this.name = name;
		this.transportCost = new HashMap<Integer, Integer>(transportCost);
		this.numConnectedCity = numConnectedCity;
	}

	/**
	 * Set city atribut such as: name, connection with another city, transfer
	 * cost,
	 */
	private void createCity() {
		Cities.print(false, "City name");
		setName(getScn().next());
		Cities.print(false, "Number of connected city");
		setNumConnectedCity(Integer.parseInt(scn.next()));
		for (int i = 0; i < numConnectedCity; i++) {
			Cities.print(false, "City ID");
			String num = getScn().next();
			Cities.print(false, "Transport cost to " + num);
			String cost = getScn().next();
			getTransportCost().put(Integer.valueOf(num), Integer.valueOf(cost));
		}

	}

	/**
	 * Set false for start and for end. Set Integer.MMAX_VALUE for graf mark
	 */
	public void clearData() {
		setGrafMark(Integer.MAX_VALUE);
		setStart(false);
		setEnd(false);
	}

	/**
	 * Return new City which is has same atribut
	 * 
	 * @return City cline of the current City
	 */
	@Override
	protected City clone() throws CloneNotSupportedException {
		return new City(isStart(), isEnd(), getGrafMark(), getId(), getName(), getTransportCost(),
				getNumConnectedCity());
	}

	/**
	 * Return true if obj equals current City
	 * 
	 * @return boolean true if obj equals current City
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof City) {
			if (((City) obj).getId() == getId() && ((City) obj).getName().equals(getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Preparing for clean object
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		setName(null);
		setTransportCost(null);
		setScn(null);
	}

	/**
	 * Test data for testing algorithm
	 * 
	 * @return List<String> path data for testing algorithm
	 */
	public static List<String> testPaths() {
		List<String> paths = new ArrayList<String>();
		paths.add("A X");
		paths.add("Y B");
		paths.add("E F");
		paths.add("Y D");
		return paths;
	}

	/**
	 * Test data for testing algorithm
	 * 
	 * @return List<City> Cities data for testing algorithm
	 */
	public static List<City> testCity() {
		City c1 = new City();
		City c2 = new City();
		City c3 = new City();
		City c4 = new City();
		City c5 = new City();
		City c6 = new City();
		City c7 = new City();
		City c8 = new City();

		c1.numConnectedCity = 5;
		c2.numConnectedCity = 5;
		c3.numConnectedCity = 6;
		c4.numConnectedCity = 7;
		c5.numConnectedCity = 6;
		c6.numConnectedCity = 5;
		c7.numConnectedCity = 2;
		c8.numConnectedCity = 2;

		c1.id = new Integer(1);
		c2.id = new Integer(2);
		c3.id = new Integer(3);
		c4.id = new Integer(4);
		c5.id = new Integer(5);
		c6.id = new Integer(6);
		c7.id = new Integer(7);
		c8.id = new Integer(8);

		c1.name = "A";
		c2.name = "B";
		c3.name = "C";
		c4.name = "D";
		c5.name = "E";
		c6.name = "F";
		c7.name = "X";
		c8.name = "Y";

		c1.getTransportCost().put(new Integer(2), new Integer(1));
		c1.getTransportCost().put(new Integer(3), new Integer(2));
		c1.getTransportCost().put(new Integer(4), new Integer(3));
		c1.getTransportCost().put(new Integer(5), new Integer(4));
		c1.getTransportCost().put(new Integer(6), new Integer(5));

		c2.getTransportCost().put(new Integer(1), new Integer(1));
		c2.getTransportCost().put(new Integer(3), new Integer(9));
		c2.getTransportCost().put(new Integer(4), new Integer(8));
		c2.getTransportCost().put(new Integer(5), new Integer(7));
		c2.getTransportCost().put(new Integer(6), new Integer(6));

		c3.getTransportCost().put(new Integer(2), new Integer(9));
		c3.getTransportCost().put(new Integer(1), new Integer(2));
		c3.getTransportCost().put(new Integer(4), new Integer(12));
		c3.getTransportCost().put(new Integer(5), new Integer(11));
		c3.getTransportCost().put(new Integer(6), new Integer(10));
		c3.getTransportCost().put(new Integer(7), new Integer(80));

		c4.getTransportCost().put(new Integer(2), new Integer(8));
		c4.getTransportCost().put(new Integer(3), new Integer(12));
		c4.getTransportCost().put(new Integer(1), new Integer(3));
		c4.getTransportCost().put(new Integer(5), new Integer(14));
		c4.getTransportCost().put(new Integer(6), new Integer(13));
		c4.getTransportCost().put(new Integer(7), new Integer(60));
		c4.getTransportCost().put(new Integer(8), new Integer(120));

		c5.getTransportCost().put(new Integer(2), new Integer(7));
		c5.getTransportCost().put(new Integer(3), new Integer(11));
		c5.getTransportCost().put(new Integer(4), new Integer(14));
		c5.getTransportCost().put(new Integer(1), new Integer(4));
		c5.getTransportCost().put(new Integer(6), new Integer(15));
		c5.getTransportCost().put(new Integer(8), new Integer(70));

		c6.getTransportCost().put(new Integer(2), new Integer(6));
		c6.getTransportCost().put(new Integer(3), new Integer(10));
		c6.getTransportCost().put(new Integer(4), new Integer(13));
		c6.getTransportCost().put(new Integer(5), new Integer(15));
		c6.getTransportCost().put(new Integer(1), new Integer(5));

		c7.getTransportCost().put(new Integer(3), new Integer(80));
		c7.getTransportCost().put(new Integer(4), new Integer(60));

		c8.getTransportCost().put(new Integer(4), new Integer(120));
		c8.getTransportCost().put(new Integer(5), new Integer(70));

		List<City> c = new ArrayList<City>();
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		return c;
	}

	/** Getter */
	public int getId() {
		return id;
	}

	/** Getter */
	public String getName() {
		return name;
	}

	/** Getter */
	public Map<Integer, Integer> getTransportCost() {
		return transportCost;
	}

	/** Getter */
	public boolean isStart() {
		return start;
	}

	/** Getter */
	public boolean isEnd() {
		return end;
	}

	/**
	 * Setter start flag. For setting city is start? if set true, graf mark set
	 * equals zero
	 */
	public void setStart(boolean start) {
		this.start = start;
		if (start) {
			setGrafMark(0);
		}
	}

	/**
	 * Setter end flag. For setting city is end?
	 */
	public void setEnd(boolean end) {
		this.end = end;
	}

	/** Setter */
	private void setId(int id) {
		this.id = id;
	}

	/** Setter */
	private void setName(String name) {
		this.name = name;
	}

	/** Getter */
	public int getGrafMark() {
		return grafMark;
	}

	/** Setter */
	public void setGrafMark(int grafMark) {
		this.grafMark = grafMark;
	}

	/** Getter */
	public int getNumConnectedCity() {
		return numConnectedCity;
	}

	/** Setter */
	public void setNumConnectedCity(int numberConnectedCity) {
		this.numConnectedCity = numberConnectedCity;
	}

	/** Setter */
	private void setTransportCost(Map<Integer, Integer> transportCost) {
		this.transportCost = transportCost;
	}

	/** Setter */
	private void setScn(Scanner scn) {
		this.scn = scn;
	}

	/** Getter */
	private Scanner getScn() {
		return scn;
	}

}
