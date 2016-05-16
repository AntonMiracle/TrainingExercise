/**
 * Project: Tasks ShowStudent.java
 */
package com.bam.task.task3.student;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 10.02.2016.
 *
 */
public class ShowStudent {
	final private int	ID	= 7;
	private Student		students[];
	private String		show;

	public ShowStudent(Student students[]) {
		show = "";
		this.students = students;
		for (int i = 0; i < students.length; i++) {
			show += "\n--------------" + "\n| Student ID | " + students[i].getId() + "\n| Full name  | "
					+ students[i].getHuman().getName().toString() + "\n|  Birthday  | "
					+ students[i].getHuman().getBirthDay().toString() + "\n| University | "
					+ students[i].getUniversity().getUniversity() + "\n| Department | "
					+ students[i].getDept().toString() + "\n|    Group   | " + students[i].getGroup().toString()
					+ "\n|   Course   | " + students[i].getCourse().toString() + "\n--------------";
		}
	}

	private ShowStudent(String show, Student students[]) throws CloneNotSupportedException {
		this.show = new String(show);
		this.students = new Student[students.length];
		for (int i = 0; i < students.length; i++) {
			this.students[i] = students[i].clone();
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return show;
	}

	/*
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected ShowStudent clone() throws CloneNotSupportedException {
		ShowStudent newShow = new ShowStudent(show, students);
		return newShow;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof ShowStudent) {
			Student students[] = ((ShowStudent) obj).getStudents();
			if (students.length == this.students.length) {
				int count = 0;
				for (int i = 0; i < students.length; i++) {
					count += students[i].equals(this.students[i]) ? 1 : 0;
				}
				if (count == this.students.length) {
					isEquals = true;
				}
			}
		}
		return isEquals;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 5;
		result = result * ID;
		return result;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		students = null;
		show = null;
	}

	/** Getter */
	public Student[] getStudents() {
		return students;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

}
