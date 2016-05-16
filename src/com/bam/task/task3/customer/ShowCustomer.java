/**
 * Project: Tasks ShowCustomer.java
 */
package com.bam.task.task3.customer;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 11 лют. 2016 р.
 *
 */
public class ShowCustomer {
	final private int	PRIME	= 353;
	private Customer	customer[];
	private String		show;

	public ShowCustomer(Customer customer[]) {
		this.customer = cloneArrayCustomer(customer);
		for (int i = 0; i < customer.length; i++) {
			try {
				this.customer[i] = customer[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		show = creatListOfCustomer(this.customer);
	}

	private ShowCustomer(Customer customer[], String show) {
		this.customer = cloneArrayCustomer(customer);
		this.show = new String(show);
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

	private String creatListOfCustomer(Customer customer[]) {
		String list = "";
		for (int i = 0; i < customer.length; i++) {
			list += "\n-----------------------" + "\n|     Customer id     | " + customer[i].getId().toString()
					+ "\n|      Full name      | " + customer[i].getHuman().toString() + "\n|        Adress       | "
					+ customer[i].getAdress().toString() + "\n| Credit card number  | "
					+ customer[i].getCreditCard().toString() + "\n| Bank account number | "
					+ customer[i].getBankAccount().toString() + "\n-----------------------";
		}
		return list;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowCustomer clone() throws CloneNotSupportedException {
		ShowCustomer newC = new ShowCustomer(customer, show);
		return newC;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof ShowCustomer) {
			ShowCustomer condition = (ShowCustomer) obj;
			if (this.isCustomerArrayEquals(condition.getCustomer()) && this.show.equals(condition.getShow())) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	private boolean isCustomerArrayEquals(Customer customer[]) {
		boolean isEquals = false;
		int count = 0;
		if (this.customer.length == customer.length) {
			for (int i = 0; i < this.customer.length; i++) {
				count += this.customer[i].equals(customer[i]) ? 1 : 0;
			}
		}
		isEquals = count == this.customer.length ? true : false;
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		customer = null;
		show = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 3;
		result = result * PRIME;
		return result;
	}

	/** Getter */
	public Customer[] getCustomer() {
		return customer;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return show;
	}

}
