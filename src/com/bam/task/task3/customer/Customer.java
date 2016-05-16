/**
 * Project: Tasks Customer.java
 */
package com.bam.task.task3.customer;

import com.bam.task.task3.generalclasses.Adress;
import com.bam.task.task3.generalclasses.BankAccount;
import com.bam.task.task3.generalclasses.CreditCard;
import com.bam.task.task3.generalclasses.Human;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11.02.2016 ð.
 *
 */
public class Customer {
	final private int	PRIME	= 131;
	private Integer		id;
	private Human		human;
	private Adress		adress;
	private BankAccount	bankAccount;
	private CreditCard	creditCard;

	public Customer(int id) {
		this.id = new Integer(id);
		human = new Human();
		adress = new Adress();
		bankAccount = new BankAccount();
		creditCard = new CreditCard();
	}

	private Customer(Integer id, Human human, Adress adress, BankAccount bankAccount, CreditCard creditCard) {
		this.id = id;
		this.human = human;
		this.adress = adress;
		this.bankAccount = bankAccount;
		this.creditCard = creditCard;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Customer clone() throws CloneNotSupportedException {
		Customer newC = new Customer(id, human, adress, bankAccount, creditCard);
		return newC;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Customer) {
			Customer condition = (Customer) obj;
			if (condition.getId() == id && condition.getHuman().equals(human) && condition.getAdress().equals(adress)
					&& condition.getBankAccount().equals(bankAccount) && condition.getCreditCard().equals(creditCard)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		human = null;
		adress = null;
		bankAccount = null;
		creditCard = null;
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
		return "id: " + id + ", " + human + ", " + adress + ", bank account (" + bankAccount
				+ "), number of credit card (" + creditCard + ")";
	}
	
	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public Human getHuman() {
		return human;
	}

	/** Getter */
	public Adress getAdress() {
		return adress;
	}

	/** Getter */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/** Getter */
	public CreditCard getCreditCard() {
		return creditCard;
	}

}
