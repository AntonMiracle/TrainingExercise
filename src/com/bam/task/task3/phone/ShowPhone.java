/**
 * Project: Tasks ShowPhone.java
 */
package com.bam.task.task3.phone;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class ShowPhone {
	final private int PRIME = 239;

	final static public String showOneAbonent(Phone phone) {
		String show = "";
		show += "\n-----------------------" + "\n|       Phone id      | " + phone.getId().toString()
				+ "\n| Full name           | " + phone.getHuman().toString() + "\n| Adress              | "
				+ phone.getAdress().toString() + "\n| Credit card id      | " + phone.getCardId().toString()
				+ "\n| Debit               | " + phone.getDebitCredit().getDebit().toString() + " units"
				+ "\n| Credit              | " + phone.getDebitCredit().getCredit().toString() + " units"
				+ "\n| Local calls         | " + phone.getCalls().getLocal().toString() + " min"
				+ "\n| International calls | " + phone.getCalls().getInternational().toString() + " min"
				+ "\n-----------------------";
		return show;
	}

	final static public String showAbonents(Phone phone[]) {
		String show = "";
		for (int i = 0; i < phone.length; i++) {
			show += showOneAbonent(phone[i]);
		}
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowPhone clone() throws CloneNotSupportedException {
		return new ShowPhone();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
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
		return "Show phone";
	}

}
