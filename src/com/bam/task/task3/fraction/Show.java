/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.fraction;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showOnefraction(Fraction fra) {
		return String.format("\n%-5d%n%s%n%-5d%n", fra.getNumerator(), fra.getDiv(), fra.getDenominator());
	}

	public static String showFractions(Fraction fra[]) {
		String show = "\n";
		for (int i = 0; i < fra.length; i++) {
			show += String.format("%-5d ", fra[i].getNumerator());
		}
		show += "\n";
		for (int i = 0; i < fra.length; i++) {
			show += String.format("%-5s ", fra[i].getDiv());
		}
		show += "\n";
		for (int i = 0; i < fra.length; i++) {
			show += String.format("%-5d ", fra[i].getDenominator());
		}
		show += "\n";
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Show clone() throws CloneNotSupportedException {
		return new Show();
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
		return 5;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show fraction";
	}

}
