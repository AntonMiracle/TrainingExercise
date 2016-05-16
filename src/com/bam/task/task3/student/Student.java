/**
 * Project: Tasks Students.java
 */
package com.bam.task.task3.student;

import com.bam.task.task3.generalclasses.Adress;
import com.bam.task.task3.generalclasses.Human;
import com.bam.task.task3.generalclasses.PhoneNumber;
import com.bam.task.task3.student.university.Course;
import com.bam.task.task3.student.university.Department;
import com.bam.task.task3.student.university.StudyGroup;
import com.bam.task.task3.student.university.University;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 8.02.2016.
 *
 */
public class Student {
	final private int	prime	= 61;
	private int			id;
	private Human		human;
	private Adress		adress;
	private PhoneNumber	phone;
	private University	university;
	private Department	dept;
	private StudyGroup	group;
	private Course		course;

	public Student(int id) {
		this.id = id;
		human = new Human();
		adress = new Adress();
		phone = new PhoneNumber();
		university = new University();
		dept = new Department();
		group = new StudyGroup();
		course = new Course();
	}

	private Student(int id, Human human, Adress adress, PhoneNumber phone, University university, Department dept,
			StudyGroup group, Course course) {
		this.id = id;
		this.human = human;
		this.adress = adress;
		this.phone = phone;
		this.university = university;
		this.dept = dept;
		this.group = group;
		this.course = course;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Student clone() throws CloneNotSupportedException {
		Student student = new Student(id, human, adress, phone, university, dept, group, course);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Student) {
			Student condition = (Student) obj;
			if (condition.getId() == id && condition.getHuman().equals(human) && condition.getAdress().equals(adress)
					&& condition.getPhone().equals(phone) && condition.getUniversity().equals(university)
					&& condition.getDept().equals(dept) && condition.getGroup().equals(group)
					&& condition.getCourse().equals(course)) {
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
		result = result * prime;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student id " + id + "\n" + human + ", birthday " + human.getBirthDay().toString() + "\n" + phone
				+ ", adress " + adress + "\n" + university.toString() + "\n" + dept.toString() + ", " + group.toString()
				+ ", " + course.toString();
	}

	/** Getter */
	public int getId() {
		return id;
	}

	/** Getter */
	public Human getHuman() {
		return human;
	}

	/** Getter */
	public Adress getAdress() {
		return adress;
	}

	/** Getter */
	public PhoneNumber getPhone() {
		return phone;
	}

	/** Getter */
	public University getUniversity() {
		return university;
	}

	/** Getter */
	public Department getDept() {
		return dept;
	}

	/** Getter */
	public StudyGroup getGroup() {
		return group;
	}

	/** Getter */
	public Course getCourse() {
		return course;
	}

}
