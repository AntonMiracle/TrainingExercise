/**
 * Project: Tasks Mark.java
 */
package com.bam.task.task3.abiturient.certificate;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class Mark {
	final private int	PRIME	= 7;
	final private int	MAXMARK	= 5;
	private Integer	mark;
	Random			rnd	= new Random();

	public Mark() {
		mark = new Integer(rnd.nextInt(5) + 1);
	}

	private Mark(Integer mark) {
		this.mark = mark;
	}

	/** Getter */
	public Integer getMark() {
		return mark;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Mark clone() throws CloneNotSupportedException {
		return new Mark(mark);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Mark) {
			if (((Mark) obj).getMark().equals(mark)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		mark = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 733;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return mark.toString();
	}

	/** Getter */
	public int getMAXMARK() {
		return MAXMARK;
	}

}
