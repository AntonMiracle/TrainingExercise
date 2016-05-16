/**
 * Project: Tasks DebitCredit.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class DebitCredit {
	final private int	PRIME	= 491;
	private Integer		debit;
	private Integer		credit;
	Random				rnd		= new Random();

	public DebitCredit() {
		debit = new Integer(rnd.nextInt(1000));
		credit = new Integer(rnd.nextInt(1000));
	}

	private DebitCredit(Integer debit, Integer credit) {
		this.debit = debit;
		this.credit = credit;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected DebitCredit clone() throws CloneNotSupportedException {
		return new DebitCredit(debit, credit);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof DebitCredit) {
			DebitCredit newD = (DebitCredit) obj;
			if (newD.getCredit().equals(credit) && newD.getDebit().equals(debit)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		debit = null;
		credit = null;
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
		return "Debit: " + debit.toString() + ", credit: " + credit.toString();
	}

	/** Getter */
	public Integer getDebit() {
		return debit;
	}

	/** Getter */
	public Integer getCredit() {
		return credit;
	}

}
