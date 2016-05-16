/**
 * Project: Tasks Price.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Price {
	final private int	PRIME	= 547;
	private Integer		price;
	Random				rnd		= new Random();

	public Price() {
		price = randomPrice();
	}

	private Price(Integer price) {
		this.price = price;
	}

	private Integer randomPrice() {
		return new Integer(100 + rnd.nextInt(1_000_000));
	}

	/** Getter */
	public Integer getPrice() {
		return price;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Price clone() throws CloneNotSupportedException {
		return new Price(price);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Price) {
			isEquals = ((Price) obj).getPrice().equals(price) ? true : false;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		price = null;
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
		return price.toString();
	}

}
