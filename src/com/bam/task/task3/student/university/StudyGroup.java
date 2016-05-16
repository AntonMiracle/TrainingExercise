/**
 * Project: Tasks StudyGroup.java
 */
package com.bam.task.task3.student.university;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 9.02.2016.
 *
 */
public class StudyGroup {
	final private int	ID	= 277;
	private int			group;
	private int			max;
	Random				rnd	= new Random();

	public StudyGroup() {
		max = 6;
		group = rnd.nextInt(max) + 1;
	}

	public StudyGroup(int number) {
		max = 6;
		group = number;
	}

	private StudyGroup(int numberOfGroup, int max) {
		this.max = max;
		group = numberOfGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected StudyGroup clone() throws CloneNotSupportedException {
		StudyGroup group = new StudyGroup(this.group, this.max);
		return group;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof StudyGroup) {
			if (((StudyGroup) obj).getGroup() == group) {
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
		result = result * ID * group;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new Integer(group).toString();
	}

	/**
	 * Getting this.group from StudyGroup.java
	 * 
	 * @return this.group
	 */
	private int getGroup() {
		return group;
	}

	/** Getter */
	public int getMax() {
		return max;
	}

}
