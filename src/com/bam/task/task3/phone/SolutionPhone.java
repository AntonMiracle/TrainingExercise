/**
 * Project: Tasks SolutionPhone.java
 */
package com.bam.task.task3.phone;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class SolutionPhone {
	final private int	PRIME	= 643;
	private Phone		phone[];
	private String		source;
	private String		solA;
	private String		solB;
	private String		solC;
	Random				rnd		= new Random();

	public SolutionPhone() {
		phone = new Phone[rnd.nextInt(10) + 1];
		for (int i = 0; i < phone.length; phone[i++] = new Phone(i + 1));
		source = ShowPhone.showAbonents(phone);
		solA = solA(phone);
		solB = solB(phone);
		solC = solC(phone);
	}

	private SolutionPhone(String source, String solA, String solB, String solC) {
		this.source = source;
		this.solA = solA;
		this.solB = solB;
		this.solC = solC;
	}

	private String solA(Phone phone[]) {
		int value = rnd.nextInt(100) + 30;
		String sol = "\nSolution A:\nPhone where local calls are upper than " + new Integer(value).toString();
		sol += ShowPhone.showAbonents(SortPhone.localCallsUpperThenValue(phone, value));
		return sol;
	}

	private String solB(Phone phone[]) {
		String sol = "\nSolution B:\nPhone where international calls are upper than zero";
		sol += ShowPhone.showAbonents(SortPhone.internationalCallsUpperZero(phone));
		return sol;
	}

	private String solC(Phone phone[]) {
		String sol = "\nSolution C:\nSort phone abonent by alphabet";
		sol += ShowPhone.showAbonents(SortPhone.sortAbonentByAlphabet(phone));
		return sol;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionPhone clone() throws CloneNotSupportedException {
		return new SolutionPhone(source, solA, solB, solC);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SolutionPhone && ((SolutionPhone) obj).getSource().equals(source)
				&& ((SolutionPhone) obj).getSolA().equals(solA) && ((SolutionPhone) obj).getSolB().equals(solB)
				&& ((SolutionPhone) obj).getSolC().equals(solC)) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		solA = null;
		solB = null;
		solC = null;
		rnd = null;
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
		return "SolutionPhone source:\n" + source + solA + solB + solC;
	}

	/** Getter */
	public String getSource() {
		return source;
	}

	/** Getter */
	public String getSolA() {
		return solA;
	}

	/** Getter */
	public String getSolB() {
		return solB;
	}

	/** Getter */
	public String getSolC() {
		return solC;
	}

}
