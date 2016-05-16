/**
 * Project: Tasks BuildingType.java
 */
package com.bam.task.task3.house;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class BuildingType {
	final private int		PRIME	= 99;
	final private String	TYPE[]	= new String[]{"Brick","Concrete","Wood"};
	private String			type;
	Random					rnd		= new Random();

	public BuildingType() {
		type = randomType();
	}

	private BuildingType(String type) {
		this.type = type;
	}

	private String randomType() {
		return new String(TYPE[rnd.nextInt(TYPE.length)]);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected BuildingType clone() throws CloneNotSupportedException {
		return new BuildingType(type);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BuildingType) {
			if (((BuildingType) obj).getType().equals(type)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;

		}

	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		type = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 9;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return type;
	}

	/** Getter */
	public String[] getTYPE() {
		return TYPE;
	}

	/** Getter */
	public String getType() {
		return type;
	}

}
