/**
 * Project: Tasks Room.java
 */
package com.bam.task.task3.house;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Room {
	final private int	PRIME	= 317;
	private Double		area;
	Random				rnd		= new Random();
	DecimalFormat		df		= new DecimalFormat("#.##");

	public Room() {
		area = randomArea();
	}

	private Room(Double area) {
		this.area = area;
	}

	private Double randomArea() {
		return new Double(rnd.nextDouble() + rnd.nextInt(20) + 10);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Room clone() throws CloneNotSupportedException {
		return new Room(area);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Room) {
			if (((Room) obj).getArea().equals(area)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		area = null;
		rnd = null;
		df = null;
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
		return df.format(area);
	}

	/** Getter */
	public Double getArea() {
		return area;
	}

}
