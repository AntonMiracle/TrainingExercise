/**
 * Project: Tasks Floor.java
 */
package com.bam.task.task3.house;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Floor {
	final private int	PRIME	= 919;
	private Integer		number;
	private Apartment	apartment[];
	private Integer		amountOfApartment;
	Random				rnd		= new Random();

	public Floor() {
		number = randomFloor();
		apartment = randomApartment(number);
		amountOfApartment = new Integer(apartment.length);
	}

	public Floor(int floor) {
		number = new Integer(floor);
		apartment = randomApartment(floor);
		amountOfApartment = new Integer(apartment.length);

	}

	private Floor(Integer newF, Apartment apa[]) {
		this.number = newF;
		this.apartment = apa;
		amountOfApartment = new Integer(apartment.length);
	}

	private Integer randomFloor() {
		return new Integer(rnd.nextInt(25) + 1);
	}

	private Apartment[] randomApartment(int numberOfFloor) {
		Apartment newA[] = new Apartment[rnd.nextInt(3) + 1];
		for (int i = 0; i < newA.length; newA[i++] = new Apartment(numberOfFloor));
		return newA;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Floor clone() throws CloneNotSupportedException {
		return new Floor(number, apartment);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Floor) {
			if (((Floor) obj).getNumber().equals(number) && ((Floor) obj).getApartment().length == apartment.length) {
				int count = 0;
				for (int i = 0; i < apartment.length; i++) {
					count += ((Floor) obj).getApartment()[i].equals(apartment[i]) ? 1 : 0;
				}
				if (count == apartment.length) {
					isEquals = true;
				}
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		number = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 5;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return number.toString();
	}

	/** Getter */
	public Integer getNumber() {
		return number;
	}

	/** Getter */
	public Apartment[] getApartment() {
		return apartment;
	}

	/** Getter */
	public Integer getAmountOfApartment() {
		return amountOfApartment;
	}

}
