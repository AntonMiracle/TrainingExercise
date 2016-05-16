/**
 * Project: Tasks BankAccount.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11.02.2016 ð.
 *
 */
public class BankAccount {
	final private int	PRIME	= 7;
	private Long		accountId;
	Random				rnd	= new Random();

	public BankAccount() {
		accountId = randomAccountId();
	}

	public BankAccount(Long accountId) {
		this.accountId = accountId;

	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		accountId = null;
	}

	private Long randomAccountId() {
		String account = "";
		for (int i = 0; i < 18; i++) {
			account += new Integer(rnd.nextInt(10)).toString();
		}
		return Long.valueOf(account);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected BankAccount clone() throws CloneNotSupportedException {
		BankAccount account = new BankAccount(accountId);
		return account;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEqulas = false;
		if (obj instanceof BankAccount) {
			BankAccount compare = (BankAccount) obj;
			if (compare.getAccountId() == accountId) {
				isEqulas = true;
			}
		}
		return isEqulas;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 5;
		result = result * PRIME;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String view = "";
		for (int i = 0; i < accountId.toString().length(); i++) {
			view += accountId.toString().charAt(i);
			if ((i + 1) % 3 == 0 && i < 16) {
				view += " ";
			}
		}
		return view;
	}

	/** Getter */
	public Long getAccountId() {
		return accountId;
	}

}
