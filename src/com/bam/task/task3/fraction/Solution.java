/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.fraction;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, sol, bonus;

	public Solution() {
		Random rnd = new Random();
		Fraction fra[] = new Fraction[rnd.nextInt(20) + 5];
		for (int i = 0; i < fra.length; fra[i++] = new Fraction());
		source = "Source list of fractions: \n" + Show.showFractions(fra);
		sol = "Solution: list of fractions where every second element add next to himself\n"
				+ Show.showFractions(sol(fra));
		bonus = solBonus(fra);
	}

	public Solution(String source, String sol) {
		this.sol = new String(sol);
		this.source = new String(source);

	}

	private String solBonus(Fraction fra[]) {
		String show = "\nAditional solution with first and last element from source:";
		show += "\nComposition:" + Show.showOnefraction(Fraction.compositionTwoFraction(fra[0], fra[fra.length - 1]));
		show += "\nDivision:" + Show.showOnefraction(Fraction.divisionTwoFraction(fra[0], fra[fra.length - 1]));
		show += "\nSubstraction:" + Show.showOnefraction(Fraction.substractionTwoFraction(fra[0], fra[fra.length - 1]));
		return show;
	}

	private Fraction[] sol(Fraction fra[]) {
		for (int i = 0; i < fra.length; i++) {
			if (i % 2 != 0 && i < fra.length - 1) {
				fra[i] = Fraction.sumTwoFraction(fra[i], fra[i + 1]);
			}
		}
		return fra;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Solution(source, sol);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution) {
			if (((Solution) obj).getSol().equals(sol) && ((Solution) obj).getSource().equals(source)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		sol = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 569;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + sol + bonus;
	}

	/** Getter */
	public String getSource() {
		return source;
	}

	/** Getter */
	public String getSol() {
		return sol;
	}

}
