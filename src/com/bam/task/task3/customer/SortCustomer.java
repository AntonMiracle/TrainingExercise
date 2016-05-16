/**
 * Project: Tasks SortCustomer.java
 */
package com.bam.task.task3.customer;

import com.bam.task.task3.generalclasses.CreditCard;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11 лют. 2016 р.
 *
 */
public class SortCustomer {
	final private int	PRIME	= 7;
	private Customer	customer[];

	public SortCustomer() {

	}

	public SortCustomer(Customer customer[]) {
		this.customer = cloneArrayCustomer(customer);
	}

	private Customer[] cloneArrayCustomer(Customer customer[]) {
		Customer newC[] = new Customer[customer.length];
		for (int i = 0; i < customer.length; i++) {
			try {
				newC[i] = customer[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newC;
	}

	final static public boolean isWordUpper(String word, String compareWord) {
		boolean isUpper = false;
		if (word.length() > compareWord.length()) {
			for (int i = 0; i < compareWord.length(); i++) {
				if (word.charAt(i) < compareWord.charAt(i)) {
					isUpper = true;
					break;
				}
				if (word.charAt(i) > compareWord.charAt(i)) {
					isUpper = false;
					break;
				}
				if (i == (compareWord.length() - 1)) {
					isUpper = false;
				}
			}
		}
		if (word.length() == compareWord.length()) {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) < compareWord.charAt(i)) {
					isUpper = true;
					break;
				}
				if (word.charAt(i) > compareWord.charAt(i)) {
					isUpper = false;
					break;
				}
			}
		}
		if (word.length() < compareWord.length()) {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) < compareWord.charAt(i)) {
					isUpper = true;
					break;
				}
				if (word.charAt(i) > compareWord.charAt(i)) {
					isUpper = false;
					break;
				}
				if (i == (word.length() - 1)) {
					isUpper = true;
				}
			}
		}
		return isUpper;
	}

	public Customer[] sortCustomerByName() {
		Customer newC[] = cloneArrayCustomer(customer);
		Customer tmp = new Customer(0);
		for (int i = newC.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				String name[] = newC[j].getHuman().getName().toString().split(" ");
				String nextName[] = newC[j + 1].getHuman().getName().toString().split(" ");
				if (name[0].equals(nextName[0])) {
					if (name[1].equals(nextName[1])) {
						if (!(name[2].equals(nextName[2]))) {
							tmp = newC[j];
							newC[j] = newC[j + 1];
							newC[j + 1] = tmp;
						}
					} else {
						if (isWordUpper(nextName[1], name[1])) {
							tmp = newC[j];
							newC[j] = newC[j + 1];
							newC[j + 1] = tmp;
						}
					}
				} else {
					if (isWordUpper(nextName[0], name[0])) {
						tmp = newC[j];
						newC[j] = newC[j + 1];
						newC[j + 1] = tmp;
					}
				}
			}
		}
		return newC;
	}

	public Customer[] listWhichHaveCreditCardInInterval(CreditCard from, CreditCard to) {
		int count = 0;
		for (int i = 0; i < customer.length; i++) {
			count += from.getCreditCard() <= customer[i].getCreditCard().getCreditCard()
					&& to.getCreditCard() >= customer[i].getCreditCard().getCreditCard() ? 1 : 0;
		}
		Customer newC[] = new Customer[count];
		count = 0;
		for (int i = 0; i < customer.length; i++) {
			if (from.getCreditCard() <= customer[i].getCreditCard().getCreditCard()
					&& to.getCreditCard() >= customer[i].getCreditCard().getCreditCard()) {
				try {
					newC[count] = customer[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
				count++;
			}
		}
		return newC;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortCustomer clone() throws CloneNotSupportedException {
		SortCustomer sc = new SortCustomer(customer);
		return sc;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SortCustomer) {
			SortCustomer sc = (SortCustomer) obj;
			if (new ShowCustomer(customer).toString().equals(new ShowCustomer(sc.getCustomer()).toString())) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Sort array of customer :\n" + new ShowCustomer(customer).toString();
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		customer = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 7;
		result = result * PRIME;
		return result;
	}

	/** Getter */
	public Customer[] getCustomer() {
		return customer;
	}

}
