/**
 * Project: Tasks Course.java
 */
package com.bam.task.task3.student.university;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 9.02.2016.
 *
 */
public class Course {
	final private int	ID	= 89;
	private int			course;
	private int			max;
	Random				rnd	= new Random();

	public Course() {
		max = 5;
		course = rnd.nextInt(max) + 1;
	}
	
	public Course(int number){
		max = 5;
		course = number;
	}

	/**
	 * Maximum 5 courses
	 */
	private Course(int course, int max) {
		this.max = max;
		this.course = course;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Course clone() throws CloneNotSupportedException {
		Course newCourse = new Course(course, max);
		return newCourse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new Integer(course).toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = ID * result * course;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Course) {
			if (((Course) obj).getCourse() == course) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/**
	 * Getting this.course from Course.java
	 * 
	 * @return this.course
	 */
	private int getCourse() {
		return course;
	}

	/** Getter */
	public int getMax() {
		return max;
	}

}
