/**
 * Project: Tasks University.java
 */
package com.bam.task.task3.student.university;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 8.02.2016.
 *
 */
public class University {
	final private int		ID				= 83;
	final private String	UNIVERSITYS[]	= new String[]{"George Washington University","Florida South University",
			"Western State College","Indiana University","College of Lake County","Westminster College",
			"University of Bridgeport"};
	private String			university;
	Random					rnd				= new Random();

	public University() {
		university = randomUniversity();
	}

	private University(String university) {
		this.university = university;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected University clone() throws CloneNotSupportedException {
		University university = new University(this.university);
		return university;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof University) {
			if (((University) obj).getUniversity().equals(university)) {
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
		result = result * ID * UNIVERSITYS.length;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return university;
	}

	/**
	 * Getting this.university from University.java
	 * 
	 * @return this.university
	 */
	public String getUniversity() {
		return university;
	}

	private String randomUniversity() {
		return UNIVERSITYS[rnd.nextInt(UNIVERSITYS.length)];
	}

	/** Getter */
	public String[] getUNIVERSITYS() {
		return UNIVERSITYS;
	}

}
