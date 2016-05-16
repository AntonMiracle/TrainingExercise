/**
 * Project: Tasks RegistrationNum.java
 */
package com.bam.task.task3.car;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class RegistrationNum {
	private Integer	regNum;
	Random			rnd	= new Random();

	public RegistrationNum() {
		String number = "";
		for (int i = 0; i < 9; i++) {
			number += new Integer(rnd.nextInt(10)).toString();
		}
		regNum = Integer.valueOf(number);
	}

	public RegistrationNum(Integer regNum) {
		this.regNum = new Integer(regNum);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected RegistrationNum clone() throws CloneNotSupportedException {
		return new RegistrationNum(regNum);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RegistrationNum) {
			return ((RegistrationNum) obj).getRegNum().equals(regNum) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		regNum = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 353;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Registration number is " + regNum;
	}

	/** Getter */
	public Integer getRegNum() {
		return regNum;
	}

}
