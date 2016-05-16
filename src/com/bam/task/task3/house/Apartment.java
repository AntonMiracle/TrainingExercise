/**
 * Project: Tasks Apartment.java
 */
package com.bam.task.task3.house;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Apartment {
	final private int	PRIME	= 7;
	private Integer		number;
	private Room		room[];
	private Double		area;
	private Integer		amountOfRoom;
	private Integer		numberOfFloor;
	Random				rnd		= new Random();
	DecimalFormat		df		= new DecimalFormat("#.##");

	public Apartment(int floor) {
		numberOfFloor = new Integer(floor);
		number = randomApartment();
		room = randomRoom();
		area = countAreaApartment(room);
		amountOfRoom = new Integer(room.length);
	}

	private Apartment(Integer newA, Room room[], Double area, Integer numberOfRoom, Integer numberOfFloor) {
		this.room = room;
		number = newA;
		this.area = area;
		this.amountOfRoom = numberOfRoom;
		this.numberOfFloor = numberOfFloor;
	}

	public String showRoom() {
		String show = "";
		for (int i = 0; i < room.length; i++) {
			show += "room #" + new Integer(i + 1).toString() + ", area " + room[i].toString() + " | ";
		}
		return show;
	}

	private Integer randomApartment() {
		return new Integer(rnd.nextInt(80) + 10);
	}

	private Room[] randomRoom() {
		Room newR[] = new Room[rnd.nextInt(3) + 1];
		for (int i = 0; i < newR.length; newR[i++] = new Room());
		return newR;
	}

	private Double countAreaApartment(Room room[]) {
		Double area = new Double(0);
		for (Room newR : room) {
			area += newR.getArea();
		}
		return area;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Apartment clone() throws CloneNotSupportedException {
		return new Apartment(number, room, area, amountOfRoom, numberOfFloor);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Apartment) {
			Apartment newA = (Apartment) obj;
			if (newA.getNumber().equals(number) && newA.getRoom().length == room.length) {
				int count = 0;
				for (int i = 0; i < room.length; i++) {
					count += newA.getRoom()[i].equals(room[i]) ? 1 : 0;
				}
				if (count == room.length && newA.getArea().equals(area)
						&& newA.getNumberOfFloor().equals(amountOfRoom)) {
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
		room = null;
		area = null;
		numberOfFloor = null;
		amountOfRoom = null;
		rnd = null;
		df = null;
		super.finalize();
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String show = "Appartment #" + number.toString() + ", area: " + df.format(area) + ", on "
				+ numberOfFloor.toString() + ", " + getAmountOfRoom().toString() + " room(s) :" + showRoom();

		return show;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/** Getter */
	public Integer getNumber() {
		return number;
	}

	/** Getter */
	public Room[] getRoom() {
		return room;
	}

	/** Getter */
	public Double getArea() {
		return area;
	}

	/** Getter */
	public Integer getAmountOfRoom() {
		return amountOfRoom;
	}

	/** Getter */
	public Integer getNumberOfFloor() {
		return numberOfFloor;
	}

}