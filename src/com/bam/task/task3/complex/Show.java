/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.complex;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showComplexNumber(ComplexNumber num) {
		String b = "";
		if (num.getB() >= 0) {
			b = String.format("+%.3f", num.getB());
		} else {
			b = String.format("%.3f", num.getB());
		}
		return String.format("\n%s=%.3f%si", num.getZ(), num.getA(), b);
	}

	public static String showComplexNumber(ComplexNumber num[]) {
		String b = "";
		for (int i = 0; i < num.length; i++) {
			b += showComplexNumber(num[i]);
		}
		return b;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Show clone() throws CloneNotSupportedException {
		return new Show();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object arg0) {
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
		return 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show complex numbers";
	}

}
