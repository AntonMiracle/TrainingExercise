/**
 * Project: Tasks SchoolObject.java
 */
package com.bam.task.task3.abiturient.certificate;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class SchoolObject {
	final private int		PRIME		= 503;
	final private String	OBJECTS[]	= new String[]{"Algebra","Art","Biology","Chemistry","Computer science",
			"Economics","English","French","Geography","Math"};
	private String			object;
	Random					rnd			= new Random();

	public SchoolObject() {
		object = new String(OBJECTS[rnd.nextInt(OBJECTS.length)]);
	}

	private SchoolObject(String object) {
		this.object = new String(object);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SchoolObject clone() throws CloneNotSupportedException {
		return new SchoolObject(object);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SchoolObject) {
			if (((SchoolObject) obj).toString().equals(object)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		object = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 431;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return object;
	}

	/** Getter */
	public String getObject() {
		return object;
	}

}
