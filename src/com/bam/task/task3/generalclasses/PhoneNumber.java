/**
 * Project: Tasks PhoneNumber.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 9 лют. 2016 р.
 *
 */
public class PhoneNumber {
	Random				rnd	= new Random();
	final private int	ID	= 761;
	private String		number;

	public PhoneNumber() {
		number = "+38057";
		for (int i = 0; i < 7; i++) {
			number += new Integer(rnd.nextInt(10)).toString();
		}
	}

	private PhoneNumber(String number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected PhoneNumber clone() throws CloneNotSupportedException {
		PhoneNumber number = new PhoneNumber(this.number);
		return number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof PhoneNumber) {
			if (((PhoneNumber) obj).getNumber().equals(number)) {
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
		return number;
	}

	/**
	 * Getting this.number from PhoneNumber.java
	 * 
	 * @return this.number
	 */
	public String getNumber() {
		return number;
	}

}
