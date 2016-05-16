/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.complex;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, solA, solB;

	public Solution() {
		Random rnd = new Random();
		ComplexNumber num[] = new ComplexNumber[rnd.nextInt(15) + 5];
		for (int i = 0; i < num.length; num[i++] = new ComplexNumber(i));
		source = "\nSource of complex:" + Show.showComplexNumber(num);
		solA = "\nSolution A: composition of all complex:" + Show.showComplexNumber(solAComposition(num));
		solB = "\nSolution B: summ of all complex:" + Show.showComplexNumber(solBSum(num));
	}

	public Solution(String source, String solA, String solB) {
		this.source = new String(source);
		this.solA = new String(solA);
		this.solB = new String(solB);
	}

	private ComplexNumber solAComposition(ComplexNumber num[]) {
		ComplexNumber tmp = new ComplexNumber(0);
		try {
			tmp = num[0].clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		for (int i = 1; i < num.length; i++) {
			tmp = ComplexNumber.compositionTwoNumber(tmp, num[i]);
		}
		return tmp;
	}

	private ComplexNumber solBSum(ComplexNumber num[]) {
		ComplexNumber tmp = new ComplexNumber(0);
		try {
			tmp = num[0].clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		for (int i = 1; i < num.length; i++) {
			tmp = ComplexNumber.sumTwoNumber(tmp, num[i]);
		}
		return tmp;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Solution clone() throws CloneNotSupportedException {
		return new Solution(source, solA, solB);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution) {
			if (((Solution) obj).getSource().equals(source) && ((Solution) obj).getSolA().equals(solA)
					&& ((Solution) obj).getSolB().equals(solB)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		solA = null;
		solB = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 281;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + solA + solB;
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

}
