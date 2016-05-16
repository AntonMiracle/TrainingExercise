/**
 * Project: Tasks Time.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Time {
	private Integer	hour, minut;
	Random			rnd	= new Random();

	public Time() {
		hour = randomHour();
		minut = randomMinut();
	}

	public Time(Integer hour, Integer minut) {
		this.hour = new Integer(hour);
		this.minut = new Integer(minut);
	}

	private Integer randomHour() {
		return new Integer(rnd.nextInt(24));
	}

	private Integer randomMinut() {
		return new Integer(rnd.nextInt(60));
	}

	public static String show(Integer hour, Integer minut) {
		String newH = "";
		String newM = "";
		if (hour < new Integer(10)) {
			newH = "0" + hour.toString();
		} else {
			newH = hour.toString();
		}
		if (minut < new Integer(10)) {
			newM = "0" + minut.toString();
		} else {
			newM = minut.toString();
		}
		return newH + ":" + newM;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Time clone() throws CloneNotSupportedException {
		return new Time(hour, minut);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Time) {
			if (((Time) obj).getHour().equals(hour) && ((Time) obj).getMinut().equals(minut)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		hour = null;
		minut = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 271;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return show(hour, minut);
	}

	/** Getter */
	public Integer getHour() {
		return hour;
	}

	/** Getter */
	public Integer getMinut() {
		return minut;
	}

}
