/**
 * Project: Tasks BindingType.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class BindingType {
	final private int	PRIME	= 251;
	private String		type;
	final String		TYPES[]	= new String[]{"Binding type #1","Binding type #2","Binding type #3","Binding type #4",
			"Binding type #5"};
	Random				rnd		= new Random();

	public BindingType() {
		type = randomType();
	}

	private BindingType(String type) {
		this.type = type;
	}

	private String randomType() {
		return new String(TYPES[rnd.nextInt(TYPES.length)]);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected BindingType clone() throws CloneNotSupportedException {
		return new BindingType(type);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof BindingType) {
			isEquals = ((BindingType) obj).getType().equals(type) ? true : false;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		type = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 9 * PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return type;
	}

	/** Getter */
	public String getType() {
		return type;
	}

	/** Getter */
	public String[] getTYPES() {
		return TYPES;
	}

}
