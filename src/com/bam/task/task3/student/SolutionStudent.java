/**
 * Project: Tasks SolutionStudent.java
 */
package com.bam.task.task3.student;

import com.bam.task.task3.generalclasses.BirthDay;
import com.bam.task.task3.student.university.Course;
import com.bam.task.task3.student.university.Department;
import com.bam.task.task3.student.university.StudyGroup;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 10.02.2016.
 *
 */
public class SolutionStudent {
	final private int	ID	= 101;
	private String		solutionA;
	private String		solutionBbyAllCourse;
	private String		solutionBbyAllDepartment;
	private String		solutionC;
	private String		solutionD;
	private String		listDepartment[];
	private Student		students[];
	private String		listOfStudent;
	private SortStudent	sort;

	public SolutionStudent(int numberOfStudents, int yearAfterBornStudent, int numberOfGroup) {
		students = new Student[numberOfStudents];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(i + 1);
		}
		listOfStudent = new ShowStudent(students).getShow();
		try {
			sort = new SortStudent(students);
		} catch (CloneNotSupportedException ex) {
			System.err.println(ex);
		}
		listDepartment = new Department().getDEPARTMENTS();
		solutionA = solutionA();
		solutionBbyAllCourse = solutionBbyAllCourse();
		solutionBbyAllDepartment = solutionBbyAllDepartment();
		solutionC = solutionC(yearAfterBornStudent);
		solutionD = solutionD(numberOfGroup);
	}

	private SolutionStudent(Student students[], String listDepartment[], String listOfStudent, SortStudent sort,
			String solutionA, String solutionBbyAllCourse, String solutionBbyAllDepartment, String solutionC,
			String solutionD) {
		this.solutionA = solutionA;
		this.solutionBbyAllCourse = solutionBbyAllCourse;
		this.solutionBbyAllDepartment = solutionBbyAllDepartment;
		this.solutionC = solutionC;
		this.solutionD = solutionD;
		this.listDepartment = listDepartment;
		this.students = students.clone();
		this.listOfStudent = listOfStudent;
		try {
			this.sort = sort.clone();
		} catch (CloneNotSupportedException ex) {
			System.err.println(ex);
		}
	}

	private String solutionA() {
		Department randomDept = new Department();
		String list = "\nStart of solution A: ";
		list += "Student at the " + randomDept.toString() + new ShowStudent(sort.sortStudent(randomDept)).toString();
		list += "\nEnd of solution A.";
		return list;
	}

	private String solutionBbyAllCourse() {
		String list = "\nStart of solution B (by course): ";
		int maxC = new Course().getMax();
		for (int i = 1; i <= maxC; i++) {
			Course course = new Course(i);
			ShowStudent show = new ShowStudent(sort.sortStudent(course));
			list += "\nList of student on course " + new Integer(i).toString();
			list += show.toString();
		}
		list += "\nEnd of solution B (by course).";
		return list;
	}

	private String solutionBbyAllDepartment() {
		String list = "\nStart of solution B (by department): ";
		for (int i = 0; i < listDepartment.length; i++) {
			Department dept = new Department(listDepartment[i]);
			ShowStudent show = new ShowStudent(sort.sortStudent(dept));
			list += "\nList of student on " + dept.toString();
			list += show.toString();
		}
		list += "\nEnd of solution B (by department).";
		return list;
	}

	private String solutionC(int year) {
		String list = "\nStart of solution C: ";
		BirthDay bd = new BirthDay(year);
		ShowStudent show = new ShowStudent(sort.sortStudent(bd));
		list += "\nList of student that born in or after " + bd.getYear();
		list += show.toString();
		list += "\nEnd of solution C.";
		return list;
	}

	private String solutionD(int numberOfGroup) {
		String list = "\nStart of solution D: ";
		StudyGroup group = new StudyGroup(numberOfGroup);
		ShowStudent show = new ShowStudent(sort.sortStudent(group));
		list += "\nList of student that study in group " + group.toString();
		list += show.toString();
		list += "\nEnd of solution D.";
		return list;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionStudent clone() throws CloneNotSupportedException {
		SolutionStudent sol = new SolutionStudent(students, listDepartment, listOfStudent, sort, solutionA,
				solutionBbyAllCourse, solutionBbyAllDepartment, solutionC, solutionD);
		return sol;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionStudent) {
			SolutionStudent sol = (SolutionStudent) obj;
			if (sol.getSolutionA().equals(solutionA) && sol.getSolutionBbyAllCourse().equals(solutionBbyAllCourse)
					&& sol.getSolutionBbyAllDepartment().equals(solutionBbyAllDepartment)
					&& sol.getSolutionC().equals(solutionC) && sol.getSolutionD().equals(solutionD)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 5;
		result = result * ID;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SolutionStudent:" + "\n" + solutionA + "\n" + solutionBbyAllCourse + "\n" + solutionBbyAllDepartment
				+ "\n" + solutionC + "\n" + solutionD;
	}

	/** Getter */
	public String getSolutionA() {
		return solutionA;
	}

	/** Getter */
	public String getSolutionBbyAllCourse() {
		return solutionBbyAllCourse;
	}

	/** Getter */
	public String getSolutionBbyAllDepartment() {
		return solutionBbyAllDepartment;
	}

	/** Getter */
	public String getSolutionC() {
		return solutionC;
	}

	/** Getter */
	public String getListOfStudent() {
		return listOfStudent;
	}

	/** Getter */
	public String getSolutionD() {
		return solutionD;
	}

}
