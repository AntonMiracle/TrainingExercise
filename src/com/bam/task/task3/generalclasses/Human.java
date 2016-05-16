/**
 * Project: Tasks Human.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 8.02.2016.
 *
 */
public class Human {
	final private int	ID	= 997;
	private Names		name;
	private BirthDay	birthDay;
	Random				rnd	= new Random();

	private Human(Names name, BirthDay birthDay) {
		this.name = name;
		this.birthDay = birthDay;
	}

	public Human() {
		this.name = new Names();
		this.birthDay = new BirthDay();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Human clone() throws CloneNotSupportedException {
		Human human = new Human(name, birthDay);
		return human;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Human) {
			if (((Human) obj).getName().equals(name)) {
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
		int result = 1;
		result = ID * result * Integer.parseInt(birthDay.getDay());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name.toString();
	}

	public String toStringSimple() {
		return name.toStringSimpleName();
	}

	/**
	 * Getting this.name from Human.java
	 * 
	 * @return this.name
	 */
	public Names getName() {
		return name;
	}

	/**
	 * Getting this.birthDay from Human.java
	 * 
	 * @return this.birthDay
	 */
	public BirthDay getBirthDay() {
		return birthDay;
	}

}
