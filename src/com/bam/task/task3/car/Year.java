/**
 * Project: Tasks Year.java
 */
package com.bam.task.task3.car;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Year {
	private Integer	year;
	Random			rnd	= new Random();

	public Year() {
		year = rnd.nextInt(50) + 1960;
	}

	public Year(Integer year) {
		this.year = new Integer(year);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Year clone() throws CloneNotSupportedException {
		return new Year(year);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Year) {
			return ((Year) obj).getYear().equals(year) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		year = null;
		rnd = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 593;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Year of issue " + year.toString();
	}

	/** Getter */
	public Integer getYear() {
		return year;
	}

}
