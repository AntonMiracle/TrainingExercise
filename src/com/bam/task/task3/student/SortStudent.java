/**
 * Project: Tasks SortStudent.java
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
public class SortStudent {
	final private int	ID	= 331;
	private Student		students[];

	public SortStudent(Student students[]) throws CloneNotSupportedException {
		this.students = new Student[students.length];
		for (int i = 0; i < students.length; i++) {
			this.students[i] = students[i].clone();
		}

	}

	public <T> Student[] sortStudent(T condition) {
		Student sortStudents[] = new Student[countEqualsConditionInStudent(condition)];
		int index = 0;

		for (int i = 0; i < students.length; i++) {
			try {
				if (condition instanceof Course && students[i].getCourse().equals(condition)) {
					sortStudents[index++] = students[i].clone();
				}
				if (condition instanceof Department && students[i].getDept().equals(condition)) {
					sortStudents[index++] = students[i].clone();
				}
				if (condition instanceof StudyGroup && students[i].getGroup().equals(condition)) {
					sortStudents[index++] = students[i].clone();
				}
				if (condition instanceof BirthDay) {
					int studentYear = Integer.parseInt(students[i].getHuman().getBirthDay().getYear());
					int conditionYear = Integer.parseInt(((BirthDay) condition).getYear());
					if (conditionYear <= studentYear) {
						sortStudents[index++] = students[i].clone();
					}
				}
			} catch (CloneNotSupportedException ex) {
				System.err.println(ex);
			}
		}
		return sortStudents;
	}

	public <T> int countEqualsConditionInStudent(T condition) {
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (condition instanceof Course && students[i].getCourse().equals(condition)) {
				count++;
			}
			if (condition instanceof Department && students[i].getDept().equals(condition)) {
				count++;
			}
			if (condition instanceof StudyGroup && students[i].getGroup().equals(condition)) {
				count++;
			}
			if (condition instanceof BirthDay) {
				int studentYear = Integer.parseInt(students[i].getHuman().getBirthDay().getYear());
				int conditionYear = Integer.parseInt(((BirthDay) condition).getYear());
				if (conditionYear <= studentYear) {
					count++;
				}
			}
		}
		return count;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortStudent clone() throws CloneNotSupportedException {
		SortStudent newSort = new SortStudent(students);
		return newSort;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 5;
		result = result * ID;
		return result;
	}

	/** Getter */
	public Student[] getStudents() {
		return students;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SortStudent) {
			if (new ShowStudent(students).toString()
					.equals(new ShowStudent(((SortStudent) obj).getStudents()).toString())) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		students = null;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return new String("Sort array of student :\n" + new ShowStudent(students).toString());
	}

}
