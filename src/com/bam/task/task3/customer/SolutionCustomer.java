/**
 * Project: Tasks SolutionCustomer.java
 */
package com.bam.task.task3.customer;

import com.bam.task.task3.generalclasses.CreditCard;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11 лют. 2016 р.
 *
 */
public class SolutionCustomer {
	final private int		PRIME	= 971;
	private String			solutionA;
	private String			solutionB;
	private Customer		customer[];
	private SortCustomer	sort;

	public SolutionCustomer(int valueOfCustomers) {
		customer = new Customer[valueOfCustomers];
		for (int i = 0; i < customer.length; i++) {
			customer[i] = new Customer(i + 1);
		}
		sort = new SortCustomer(customer);
		solutionA = "\nResult of solution A:\n" + solutionA();
		solutionB = "\nResult of solution B:\n" + solutionB();
	}

	private SolutionCustomer(Customer customer[], String solutionA, String solutionB, SortCustomer sort) {
		this.customer = customer;
		this.solutionA = solutionA;
		this.solutionB = solutionB;
		this.sort = sort;
	}

	private String solutionA() {
		return new ShowCustomer(sort.sortCustomerByName()).getShow();
	}

	private String solutionB() {
		String list = "";
		CreditCard cc[] = randomIntervalCreditCardNumber();
		list += "Interval:\nFrom " + cc[0].toString() + "\nTo " + cc[1].toString();
		list += new ShowCustomer(sort.listWhichHaveCreditCardInInterval(cc[0], cc[1])).getShow();
		return list;
	}

	private CreditCard[] randomIntervalCreditCardNumber() {
		CreditCard cc1 = new CreditCard();
		CreditCard cc2 = new CreditCard();
		while (cc1.getCreditCard() >= cc2.getCreditCard()) {
			cc2 = new CreditCard();
		}
		return new CreditCard[]{cc1,cc2};
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionCustomer clone() throws CloneNotSupportedException {
		SolutionCustomer sc = new SolutionCustomer(customer, solutionA, solutionB, sort);
		return sc;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionCustomer) {
			SolutionCustomer sc = (SolutionCustomer) obj;
			if (sc.getSolutionA().equals(solutionA) && sc.getSolutionB().equals(solutionB)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		customer = null;
		solutionA = null;
		solutionB = null;
		sort = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 1;
		result = result * PRIME;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SolutionCustomer:\nList of customers (before sorting)" + new ShowCustomer(customer).toString()
				+ solutionA + solutionB;
	}

	/** Getter */
	public String getSolutionA() {
		return solutionA;
	}

	/** Getter */
	public String getSolutionB() {
		return solutionB;
	}

	/** Getter */
	public Customer[] getCustomer() {
		return customer;
	}

}
