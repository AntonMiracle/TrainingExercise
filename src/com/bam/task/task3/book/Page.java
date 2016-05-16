/**
 * Project: Tasks Page.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Page {
	final private int	PRIME	= 7;
	private Integer		value;
	Random				rnd		= new Random();

	public Page() {
		value = new Integer(10 + rnd.nextInt(1000));
	}

	private Page(Integer value) {
		this.value = value;
	}

	/** Getter */
	public Integer getValue() {
		return value;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Page clone() throws CloneNotSupportedException {
		return new Page(value);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Page) {
			isEquals = ((Page) obj).getValue().equals(value) ? true : false;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		value = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 5 * PRIME;
	}

	/* @see java.lang.Object#toString() */
@Override
public String toString() {
	return value.toString();
}

}
