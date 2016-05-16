/**
 * Project: Tasks CreditCard.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11.02.2016 ð.
 *
 */
public class CreditCard {
	final private int	PRIME	= 557;
	private Long		creditCard;
	Random				rnd	= new Random();

	public CreditCard() {
		creditCard = randomCreditCard();
	}

	public CreditCard(long number) {
		this.creditCard = number;
	}

	public Long randomCreditCard() {
		String number = "";
		for (int i = 0; i < 16; i++) {
			number += new Integer(rnd.nextInt(10)).toString();
		}
		return Long.valueOf(number);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected CreditCard clone() throws CloneNotSupportedException {
		CreditCard cc = new CreditCard(creditCard);
		return cc;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof CreditCard) {
			isEquals = ((CreditCard) obj).getCreditCard().equals(creditCard) ? true : false;
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		creditCard = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 7;
		result = result * PRIME;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String view = "";
		for (int i = 0; i < creditCard.toString().length(); i++) {
			view += creditCard.toString().charAt(i);
			if ((i + 1) % 4 == 0 && i < 13) {
				view += " ";
			}
		}
		return view;
	}

	/** Getter */
	public Long getCreditCard() {
		return creditCard;
	}

}
