/**
 * Project: Tasks SortHouse.java
 */
package com.bam.task.task3.house;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class SortHouse {
	final private int PRIME = 857;

	final static public Apartment[] apartmentByValueOfRoom(House house[], int numberOfRoom) {
		int count = 0;
		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < house[i].getFloor().length; j++) {
				for (int k = 0; k < house[i].getFloor()[j].getApartment().length; k++) {
					if (house[i].getFloor()[j].getApartment()[k].getAmountOfRoom().equals(new Integer(numberOfRoom))) {
						System.out.println("LEVEL up");
						count++;
					}
				}
			}
		}
		Apartment newA[] = new Apartment[count];
		count = 0;
		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < house[i].getFloor().length; j++) {
				for (int k = 0; k < house[i].getFloor()[j].getApartment().length; k++) {
					if (house[i].getFloor()[j].getApartment()[k].getAmountOfRoom().equals(new Integer(numberOfRoom))) {
						try {
							newA[count++] = house[i].getFloor()[j].getApartment()[k].clone();
						} catch (CloneNotSupportedException ex) {
							System.out.println(ex);
						}
					}
				}
			}
		}
		return newA;
	}

	final static public Apartment[] apartmentWithValueAmountOfRoomAndHasValueFloor(Apartment apa[],
			Integer intervalFloor[]) {
		int count = 0;
		for (int i = 0; i < apa.length; i++) {
			if (intervalFloor[0] <= apa[i].getNumberOfFloor() && intervalFloor[1] >= apa[i].getNumberOfFloor()) {
				count++;
			}
		}
		Apartment newA[] = new Apartment[count];
		count = 0;
		for (int i = 0; i < apa.length; i++) {
			if (intervalFloor[0] <= apa[i].getNumberOfFloor() && intervalFloor[1] >= apa[i].getNumberOfFloor()) {
				try {
					newA[count++] = apa[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newA;
	}

	final static public Apartment[] apartmentWithUpperValueOfArea(House house[], Double valueOfLessArea) {
		int count = 0;
		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < house[i].getFloor().length; j++) {
				for (int k = 0; k < house[i].getFloor()[j].getApartment().length; k++) {
					if (house[i].getFloor()[j].getApartment()[k].getArea() >= valueOfLessArea) {
						count++;
					}
				}
			}
		}
		Apartment newA[] = new Apartment[count];
		count = 0;
		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < house[i].getFloor().length; j++) {
				for (int k = 0; k < house[i].getFloor()[j].getApartment().length; k++) {
					if (house[i].getFloor()[j].getApartment()[k].getArea() >= valueOfLessArea) {
						try {
							newA[count++] = house[i].getFloor()[j].getApartment()[k].clone();
						} catch (CloneNotSupportedException ex) {
							System.out.println(ex);
						}
					}
				}
			}
		}
		return newA;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortHouse clone() throws CloneNotSupportedException {
		return new SortHouse();
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
		return "Sort house";
	}

}
