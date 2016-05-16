/**
 * Project: Tasks Colour.java
 */
package com.bam.task.task3.car;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Colour {
	private String			colour;
	final private String	COLOURS[]	= new String[]{"Red","Blue","Black"};;
	Random					rnd			= new Random();

	public Colour() {
		colour = new String(COLOURS[rnd.nextInt(COLOURS.length)]);
	}

	public Colour(String colour) {
		this.colour = new String(colour);
	}

	/** Getter */
	public String getColour() {
		return colour;
	}

	/** Getter */
	public String[] getCOLOURS() {
		return COLOURS;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Colour clone() throws CloneNotSupportedException {
		return new Colour(colour);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Colour) {
			return ((Colour) obj).getColour().equals(colour) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		colour = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 877;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Colour is " + colour;
	}

}
