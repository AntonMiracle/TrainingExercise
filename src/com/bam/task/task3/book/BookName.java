/**
 * Project: Tasks BookName.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class BookName {
	final private int		PRIME		= 409;
	private String			name;
	final private String	BOOKNAMES[]	= new String[]{"Avrora and Co","Kill Bill","Grow up","Let`s go","All be good"};
	Random					rnd			= new Random();

	public BookName() {
		name = randomName();
	}

	private BookName(String name) {
		this.name = name;
	}

	private String randomName() {
		return new String(BOOKNAMES[rnd.nextInt(BOOKNAMES.length)]);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected BookName clone() throws CloneNotSupportedException {
		return new BookName(name);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof BookName) {
			if (((BookName) obj).getName().equals(name)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		name = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return name;
	}

	/** Getter */
	public String getName() {
		return name;
	}

	/** Getter */
	public String[] getBOOKNAMES() {
		return BOOKNAMES;
	}

}
