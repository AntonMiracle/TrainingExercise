/**
 * Project: Tasks Adress.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 8 лют. 2016 р.
 *
 */
public class Adress {
	Random					rnd			= new Random();
	final private int		ID			= 439;
	final private String	ADRESS[]	= new String[]{"Sumskaya","Pushkinskaya","Elizarova","Klochkovskaya","Gagarina",
			"Eclipse","Karazina"};
	private String			street;
	private String			building;
	private String			apartment;

	public Adress() {
		street = randomStreet();
		building = randomNumberOfBuilding();
		apartment = randomApartment();
	}

	private Adress(String street, String building, String apartment) {
		this.street = street;
		this.building = building;
		this.apartment = apartment;
	}

	public String randomStreet() {
		return ADRESS[rnd.nextInt(ADRESS.length)];
	}

	public String randomNumberOfBuilding() {
		String number = new Integer(rnd.nextInt(999) + 1).toString();
		return number;
	}

	public String randomApartment() {
		int apartmentId = rnd.nextInt(1000);
		String apartment = apartmentId > 0 ? new Integer(apartmentId).toString() : "Private House";
		return apartment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Adress adress = new Adress(street, building, apartment);
		return adress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Adress) {
			if (((Adress) obj).getStreet().equals(street) && ((Adress) obj).getBuilding().equals(building)
					&& ((Adress) obj).getApartment().equals(apartment)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 5;
		result = result * ID;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (apartment.equals("Private House")) {
			return building + " " + street + " street";
		} else {
			return building + " " + street + " street, apartment " + apartment;
		}

	}

	/**
	 * Getting this.street from Adress.java
	 * 
	 * @return this.street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Getting this.building from Adress.java
	 * 
	 * @return this.building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * Getting this.apartment from Adress.java
	 * 
	 * @return this.apartment
	 */
	public String getApartment() {
		return apartment;
	}

}
