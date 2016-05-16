/**
 * Project: Tasks Calls.java
 */
package com.bam.task.task3.phone;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Calls {
	final private int	PRIME	= 709;
	private Integer		local;
	private Integer		international;
	Random				rnd		= new Random();

	public Calls() {
		local = new Integer(rnd.nextInt(200));
		international = new Integer(rnd.nextInt(200));
	}

	private Calls(Integer local, Integer international) {
		this.local = local;
		this.international = international;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Calls clone() throws CloneNotSupportedException {
		return new Calls(local, international);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Calls && ((Calls) obj).getLocal().equals(local)
				&& ((Calls) obj).getInternational().equals(international)) {
			isEquals = true;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		local = null;
		international = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Local calls " + local.toString() + " min , intarnational calls " + international.toString() + " min";
	}

	/** Getter */
	public Integer getLocal() {
		return local;
	}

	/** Getter */
	public Integer getInternational() {
		return international;
	}

}
