/**
 * Project: Tasks LifeTime.java
 */
package com.bam.task.task3.house;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class LifeTime {
	final private int	PRIME	= 439;
	private Integer		lifeTime;
	Random				rnd		= new Random();

	public LifeTime() {
		lifeTime = randomLifeTime();
	}

	private LifeTime(Integer lifeTime) {
		this.lifeTime = lifeTime;
	}

	private Integer randomLifeTime() {
		return new Integer(rnd.nextInt(60) + 1);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected LifeTime clone() throws CloneNotSupportedException {
		return new LifeTime(lifeTime);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LifeTime && ((LifeTime) obj).getLifeTime().equals(lifeTime)) {
			return true;
		} else {
			return false;
		}
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		lifeTime = null;
		rnd = null;
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
		return lifeTime.toString();
	}

	/** Getter */
	public Integer getLifeTime() {
		return lifeTime;
	}

}
