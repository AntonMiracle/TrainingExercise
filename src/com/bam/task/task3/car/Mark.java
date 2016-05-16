/**
 * Project: Tasks Mark.java
 */
package com.bam.task.task3.car;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Mark {
	private String			mark;
	final private String	MARKS[]	= new String[]{"BMW","Volvo","Honda","Mitsubishi"};
	Random					rnd		= new Random();

	public Mark() {
		mark = new String(MARKS[rnd.nextInt(MARKS.length)]);
	}

	public Mark(String mark) {
		this.mark = mark;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Mark clone() throws CloneNotSupportedException {
		return new Mark(mark);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Mark) {
			return ((Mark) obj).getMark().equals(mark) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		mark = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 541;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Mark is " + mark;
	}

	/** Getter */
	public String getMark() {
		return mark;
	}

	/** Getter */
	public String[] getMarks() {
		return MARKS;
	}

}
