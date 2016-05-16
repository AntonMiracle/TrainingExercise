/**
 * Project: Tasks PublishingHouse.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class PublishingHouse {
	final private int		PRIME	= 881;
	private String			name;
	final private String	NAMES[]	= new String[]{"B&G publishing","Publishing PAGES","Publishing white house",
			"Gold publishing"};
	Random					rnd		= new Random();

	public PublishingHouse() {
		name = randomName();
	}

	private PublishingHouse(String name) {
		this.name = name;
	}

	private String randomName() {
		return new String(NAMES[rnd.nextInt(NAMES.length)]);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected PublishingHouse clone() throws CloneNotSupportedException {
		return new PublishingHouse(name);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof PublishingHouse) {
			if (((PublishingHouse) obj).getName().equals(name)) {
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
		return 7 * PRIME;
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
	public String[] getNAMES() {
		return NAMES;
	}

}
