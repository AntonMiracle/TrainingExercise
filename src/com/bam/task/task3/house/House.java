/**
 * Project: Tasks House.java
 */
package com.bam.task.task3.house;

import java.util.Random;

import com.bam.task.task3.generalclasses.Adress;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class House {
	final private int		PRIME	= 487;
	private Integer			id;
	private Floor			floor[];
	private String			street;
	private Integer			amountOfFloor;
	private Integer			amountOfApartment;
	private Integer			amountOfRoom;
	private BuildingType	type;
	private LifeTime		lifeTime;
	Random					rnd		= new Random();

	public House(int id) {
		this.id = new Integer(id);
		type = new BuildingType();
		lifeTime = new LifeTime();
		floor = randomFloors();
		amountOfFloor = new Integer(floor.length);
		amountOfApartment = amountOfApartmentAndRoom(floor)[0];
		amountOfRoom = amountOfApartmentAndRoom(floor)[1];
		street = new Adress().getStreet();
	}

	private House(Integer id, Floor floor[], String street, Integer amountOfFloor, Integer amountOfApartment,
			Integer amountOfRoom, BuildingType type, LifeTime lifeTime) {
		this.id = id;
		this.floor = floor;
		this.street = street;
		this.amountOfFloor = amountOfFloor;
		this.amountOfApartment = amountOfApartment;
		this.amountOfRoom = amountOfRoom;
		this.type = type;
		this.lifeTime = lifeTime;
	}

	private Integer[] amountOfApartmentAndRoom(Floor floor[]) {
		Integer amountA = new Integer(0);
		Integer amountR = new Integer(0);
		for (int i = 0; i < floor.length; i++) {
			amountA += floor[i].getAmountOfApartment();
			for (int j = 0; j < floor[i].getApartment().length; j++) {
				amountR += floor[i].getApartment()[j].getAmountOfRoom();
			}
		}
		return new Integer[]{amountA,amountR};

	}

	private Floor[] randomFloors() {
		Floor newF[] = new Floor[rnd.nextInt(6) + 1];
		for (int i = 0; i < newF.length; i++){
			newF[i] = new Floor(i + 1);
		}
		return newF;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected House clone() throws CloneNotSupportedException {
		return new House(id, floor, street, amountOfFloor, amountOfApartment, amountOfRoom, type, lifeTime);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof House) {
			House newH = (House) obj;
			if (newH.getFloor().length == floor.length && newH.getId().equals(id) && newH.getLifeTime().equals(lifeTime)
					&& newH.getStreet().equals(street) && newH.getType().equals(type)) {
				int count = 0;
				for (int i = 0; i < floor.length; i++) {
					count += newH.getFloor()[i].equals(floor[i]) ? 1 : 0;
					if (count == floor.length) {
						isEquals = true;
					}
				}
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		floor = null;
		street = null;
		amountOfFloor = null;
		amountOfApartment = null;
		amountOfRoom = null;
		type = null;
		lifeTime = null;
		rnd = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 9;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String show = "House id :" + id.toString() + ", has " + amountOfFloor.toString() + " floor(s), " + street
				+ " street, \n" + amountOfApartment.toString() + " apartments, \nbuilding type is " + type.toString()
				+ " , life time is " + lifeTime.toString();
		return show;
	}

	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public Floor[] getFloor() {
		return floor;
	}

	/** Getter */
	public String getStreet() {
		return street;
	}

	/** Getter */
	public Integer getAmountOfFloor() {
		return amountOfFloor;
	}

	/** Getter */
	public Integer getAmountOfApartment() {
		return amountOfApartment;
	}

	/** Getter */
	public Integer getAmountOfRoom() {
		return amountOfRoom;
	}

	/** Getter */
	public BuildingType getType() {
		return type;
	}

	/** Getter */
	public LifeTime getLifeTime() {
		return lifeTime;
	}

}
