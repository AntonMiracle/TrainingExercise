/**
 * Project: Tasks Train.java
 */
package com.bam.task.task3.train;

import java.util.Random;

import com.bam.task.task3.generalclasses.Time;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Train {
	private Integer	number, numberGeneral, numberCupe, numberPlackart, numberLux;
	private String	destination;
	private Time	departure;
	private String	DESTINATIONS[]	= new String[]{"Kharkov","Lviv","Sumi","Kiev"};
	Random			rnd				= new Random();

	public Train(int number) {
		this.number = new Integer(number);
		destination = new String(DESTINATIONS[rnd.nextInt(DESTINATIONS.length)]);
		departure = new Time();
		numberGeneral = randomCountOfSeat();
		numberCupe = randomCountOfSeat();
		numberPlackart = randomCountOfSeat();
		numberLux = randomCountOfSeat();
	}

	public Train(Integer number, Integer numberGeneral, Integer numberCupe, Integer numberPlackart, Integer numberLux,
			String destination, Time departure) {
		try {
			this.departure = departure.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		this.destination = new String(destination);
		this.number = new Integer(number);
		this.numberCupe = new Integer(numberCupe);
		this.numberGeneral = new Integer(numberGeneral);
		this.numberLux = new Integer(numberLux);
		this.numberPlackart = new Integer(numberPlackart);

	}

	public Integer randomCountOfSeat() {

		return new Integer(rnd.nextInt(200));
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Train clone() throws CloneNotSupportedException {
		return new Train(number, numberGeneral, numberCupe, numberPlackart, numberLux, destination, departure);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Train) {
			Train t = (Train) obj;
			if (t.getDeparture().equals(departure) && t.getDestination().equals(destination)
					&& t.getNumber().equals(number) && t.getNumberCupe().equals(numberCupe)
					&& t.getNumberGeneral().equals(numberGeneral) && t.getNumberLux().equals(numberLux)
					&& t.getNumberPlackart().equals(numberPlackart)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		departure = null;
		destination = null;
		number = null;
		numberCupe = null;
		numberGeneral = null;
		numberLux = null;
		numberPlackart = null;
		rnd = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 5;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Train [number=" + number + ", numberGeneral=" + numberGeneral + ", numberCupe=" + numberCupe
				+ ", numberPlackart=" + numberPlackart + ", numberLux=" + numberLux + ", destination=" + destination
				+ ", departure=" + departure + "]";
	}

	/** Getter */
	public Integer getNumber() {
		return number;
	}

	/** Getter */
	public Integer getNumberGeneral() {
		return numberGeneral;
	}

	/** Getter */
	public Integer getNumberCupe() {
		return numberCupe;
	}

	/** Getter */
	public Integer getNumberPlackart() {
		return numberPlackart;
	}

	/** Getter */
	public Integer getNumberLux() {
		return numberLux;
	}

	/** Getter */
	public String getDestination() {
		return destination;
	}

	/** Getter */
	public Time getDeparture() {
		return departure;
	}

	/** Getter */
	public String[] getDESTINATIONS() {
		return DESTINATIONS;
	}

}
