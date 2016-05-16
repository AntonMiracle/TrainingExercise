/**
 * Project: Tasks SolutionHouse.java
 */
package com.bam.task.task3.house;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class SolutionHouse {
	final private int	PRIME	= 61;
	private House		house[];
	private String		show;
	private String		solA;
	private String		solB;
	private String		solC;
	Random				rnd		= new Random();
	DecimalFormat		df		= new DecimalFormat("#.##");

	public SolutionHouse() {
		house = new House[rnd.nextInt(10) + 1];
		for (int i = 0; i < house.length; i++) {
			house[i] = new House(i + 1);
		}
		show = ShowHouse.showHouse(house);
		solA = solA(house);
		solB = solB(house);
		solC = solC(house);

	}

	private SolutionHouse(House house[], String show, String solA, String solB, String solC) {
		this.house = house;
		this.show = show;
		this.solA = solA;
		this.solB = solB;
		this.solC = solC;
	}

	private String solA(House house[]) {
		int valueOfRoom = rnd.nextInt(3) + 1;
		String sol = "\nSolution A:\nApartment which have " + new Integer(valueOfRoom).toString() + " room(s):";
		sol += ShowHouse.showApartment(SortHouse.apartmentByValueOfRoom(house, valueOfRoom));
		return sol;
	}

	private String solB(House house[]) {
		int valueOfRoom = rnd.nextInt(3) + 1;
		Apartment newA[] = SortHouse.apartmentByValueOfRoom(house, valueOfRoom);
		Integer intervalFloor[] = new Integer[]{new Integer(2),new Integer(4)};
		String sol = "\nSolution B:\nApartment which have " + new Integer(valueOfRoom).toString() + " room(s) "
				+ "\nand floor in interval from " + intervalFloor[0].toString() + " to " + intervalFloor[1].toString();
		sol += ShowHouse.showApartment(SortHouse.apartmentWithValueAmountOfRoomAndHasValueFloor(newA, intervalFloor));
		return sol;
	}

	private String solC(House house[]) {
		Double area = new Double(rnd.nextDouble() + rnd.nextInt(20) + 10.0);
		String sol = "\nSolution C:\nApartment which have area upper than " + df.format(area);
		sol += ShowHouse.showApartment(SortHouse.apartmentWithUpperValueOfArea(house, area));
		return sol;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionHouse clone() throws CloneNotSupportedException {
		return new SolutionHouse(house, show, solA, solB, solC);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionHouse) {
			SolutionHouse newS = (SolutionHouse) obj;
			if (newS.getHouse().length == house.length && newS.getSolA().equals(solA) && newS.getSolB().equals(solB)
					&& newS.getSolC().equals(solC) && newS.getShow().equals(show)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		house = null;
		show = null;
		solA = null;
		solB = null;
		solC = null;
		rnd = null;
		df = null;
		super.finalize();
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Solution House source:\n" + show + solA + solB + solC;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/** Getter */
	public House[] getHouse() {
		return house;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

	/** Getter */
	public String getSolA() {
		return solA;
	}

	/** Getter */
	public String getSolB() {
		return solB;
	}

	/** Getter */
	public String getSolC() {
		return solC;
	}

}
