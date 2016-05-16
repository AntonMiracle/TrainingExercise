/**
 * Project: Tasks SortPhone.java
 */
package com.bam.task.task3.phone;

import com.bam.task.task3.customer.SortCustomer;
import com.bam.task.task3.generalclasses.CloneArray;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class SortPhone {
	final private int PRIME = 7;

	final static public Phone[] localCallsUpperThenValue(Phone phone[], int value) {
		int count = 0;
		for (int i = 0; i < phone.length; i++) {
			if (phone[i].getCalls().getLocal() > new Integer(value)) {
				count++;
			}
		}
		Phone newP[] = new Phone[count];
		count = 0;
		for (int i = 0; i < phone.length; i++) {
			if (phone[i].getCalls().getLocal() > new Integer(value)) {
				try {
					newP[count++] = phone[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newP;
	}

	final static public Phone[] internationalCallsUpperZero(Phone phone[]) {
		int count = 0;
		for (int i = 0; i < phone.length; i++) {
			if (phone[i].getCalls().getInternational() > new Integer(0)) {
				count++;
			}
		}
		Phone newP[] = new Phone[count];
		count = 0;
		for (int i = 0; i < phone.length; i++) {
			if (phone[i].getCalls().getInternational() > new Integer(0)) {
				try {
					newP[count++] = phone[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newP;
	}

	final static public Phone[] sortAbonentByAlphabet(Phone phone[]) {
		Phone newP[] = CloneArray.phone(phone);
		Phone tmp = new Phone(0);
		for (int i = newP.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				String name[] = newP[j].getHuman().getName().toString().split(" ");
				String nextName[] = newP[j + 1].getHuman().getName().toString().split(" ");
				if (name[0].equals(nextName[0])) {
					if (name[1].equals(nextName[1])) {
						if (!(name[2].equals(nextName[2]))) {
							if (new SortCustomer().isWordUpper(nextName[2], name[2])) {
								tmp = newP[j];
								newP[j] = newP[j + 1];
								newP[j + 1] = tmp;
							}
						}
					} else {
						if (new SortCustomer().isWordUpper(nextName[1], name[1])) {
							tmp = newP[j];
							newP[j] = newP[j + 1];
							newP[j + 1] = tmp;
						}
					}
				} else {
					if (new SortCustomer().isWordUpper(nextName[0], name[0])) {
						tmp = newP[j];
						newP[j] = newP[j + 1];
						newP[j + 1] = tmp;
					}
				}
			}
		}
		return newP;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortPhone clone() throws CloneNotSupportedException {
		return new SortPhone();
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
		return "Sort phone";
	}

}
