/**
 * Project: Tasks Department.java
 */
package com.bam.task.task3.student.university;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 8.02.2016.
 *
 */
public class Department {
	final private int		ID				= 349;
	final private String	DEPARTMENTS[]	= new String[]{"Department of love","Department of Economy",
			"Department of WarCraft","Department of StarCraft","Department of Stars","Department of Java"};
	private String			department;
	Random					rnd				= new Random();

	public Department() {
		department = randomDepartment();
	}

	public Department(String department) {
		this.department = department;
	}

	public String randomDepartment() {
		return DEPARTMENTS[rnd.nextInt(DEPARTMENTS.length)];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Department clone() throws CloneNotSupportedException {
		Department dept = new Department(department);
		return dept;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Department) {
			if (((Department) obj).getDepartment().equals(department)) {
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
		int result = 7;
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
		return department;
	}

	/**
	 * Getting this.department from Department.java
	 * 
	 * @return this.department
	 */
	private String getDepartment() {
		return department;
	}

	
	/** Getter */
	public String[] getDEPARTMENTS() {
		return DEPARTMENTS;
	}

}
