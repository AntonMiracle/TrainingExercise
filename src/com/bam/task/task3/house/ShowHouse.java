/**
 * Project: Tasks ShowHouse.java
 */
package com.bam.task.task3.house;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class ShowHouse {
	final private int PRIME = 7;

	final public static String showHouse(House house[]) {
		String show = "";
		for (int i = 0; i < house.length; i++) {
			show += showOneHouse(house[i]);
		}
		return show;
	}

	final public static String showOneHouse(House house) {
		String show = "";
		show += "\n-----------------------" + "\n|      House id       | " + house.getId().toString()
				+ "\n|Adress               | " + house.getStreet() + " street" + "" + "\n|Bulding type         | "
				+ house.getType().toString() + "\n|Life time            | " + house.getLifeTime().toString()
				+ "\n|Amount of floors     | " + house.getAmountOfFloor().toString() + "\n|Amount of Apartments | "
				+ house.getAmountOfApartment().toString() + "\n|Amount of rooms      | "
				+ house.getAmountOfRoom().toString() + showFloors(house) + "\n-----------------------";
		return show;
	}

	final public static String showFloors(House house) {
		String show = "";
		for (int i = 0; i < house.getFloor().length; i++) {
			show += "\n|Floor # " + new Integer(i + 1).toString() + "            | ";
			for (int j = 0; j < house.getFloor()[i].getApartment().length; j++) {
				show += "\n|       Apartment # " + house.getFloor()[i].getApartment()[j].getNumber().toString() + "| "
						+ house.getFloor()[i].getApartment()[j].showRoom();
			}
		}
		return show;
	}

	final static public String showApartment(Apartment apa[]) {
		String show = "";
		for (int i = 0; i < apa.length; i++) {
			show += showApartment(apa[i]);
		}
		return show;
	}

	final static public String showApartment(Apartment apa) {
		String show = "";
		show += "\n----------------------------------" + "\n|       Apartment # " + apa.getNumber().toString()
				+ ", floor # " + apa.getNumberOfFloor() + "| " + apa.showRoom();
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowHouse clone() throws CloneNotSupportedException {
		return new ShowHouse();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show house";
	}

}
