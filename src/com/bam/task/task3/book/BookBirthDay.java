/**
 * Project: Tasks BookBirthDay.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class BookBirthDay {
	final private int PRIME = 7;

	private Integer	birthDay;
	Random			rnd	= new Random();

	public BookBirthDay() {
		birthDay = randomBirthDay();
	}

	private BookBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	private Integer randomBirthDay() {
		return new Integer(1900 + rnd.nextInt(100));
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected BookBirthDay clone() throws CloneNotSupportedException {
		return new BookBirthDay(birthDay);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof BookBirthDay) {
			isEquals = ((BookBirthDay) obj).getBirthDay().equals(birthDay) ? true : false;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		birthDay = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 5 * PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return birthDay.toString();
	}

	/** Getter */
	public Integer getBirthDay() {
		return birthDay;
	}

}
