/**
 * Project: Tasks AirLine.java
 */
package com.bam.task.task3.airline;

import java.util.Random;

import com.bam.task.task3.generalclasses.Time;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class AirLine {
	private String	destination, type, day;
	private Time	departure;
	private Integer	number;
	private String	DESTINATIONS[]	= new String[]{"Kharkov","Kiev","Lvov","Sumi"};
	private String	TYPES[]			= new String[]{"Boing","Turbiniy","Vintovoi"};
	private String	WEEK[]			= new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday",
			"Sunday"};
	Random			rnd				= new Random();

	public AirLine(int id) {
		number = new Integer(id);
		departure = new Time();
		destination = new String(DESTINATIONS[rnd.nextInt(DESTINATIONS.length)]);
		type = new String(TYPES[rnd.nextInt(TYPES.length)]);
		day = new String(WEEK[rnd.nextInt(WEEK.length)]);
	}

	public AirLine(String destination, String type, String day, Time departure, Integer number) {
		this.destination = new String(destination);
		this.type = new String(type);
		this.day = new String(day);
		try {
			this.departure = departure.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		this.number = new Integer(number);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected AirLine clone() throws CloneNotSupportedException {
		return new AirLine(destination, type, day, departure, number);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AirLine) {
			AirLine a = (AirLine) obj;
			if (a.getDay().equals(day) && a.getDeparture().equals(departure) && a.getDestination().equals(destination)
					&& a.getNumber().equals(number) && a.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		departure = null;
		day = null;
		number = null;
		destination = null;
		type = null;
		rnd = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 719;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "AirLine [destination=" + destination + ", type=" + type + ", day=" + day + ", departure=" + departure
				+ ", number=" + number + "]";
	}

	/** Getter */
	public String getDestination() {
		return destination;
	}

	/** Getter */
	public String getType() {
		return type;
	}

	/** Getter */
	public String getDay() {
		return day;
	}

	/** Getter */
	public Time getDeparture() {
		return departure;
	}

	/** Getter */
	public Integer getNumber() {
		return number;
	}

}
