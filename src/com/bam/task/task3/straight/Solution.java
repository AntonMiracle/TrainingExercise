/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.straight;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, sol;

	public Solution() {
		Random rnd = new Random();
		Straight s[] = new Straight[rnd.nextInt(20) + 5];
		for (int i = 0; i < s.length; s[i++] = new Straight(i));
		source = "\nSoURCE:\n" + Show.showStraight(s);
		sol = "\nSolution:\nPoint of intersection with OX and OY:\n" + intersectionOXOY(s) + intersectionTwoStraight(s) + parallelStraight(s);

	}

	public Solution(String source, String sol) {
		this.source = new String(source);
		this.sol = new String(sol);
	}

	{
		System.gc();
	}

	private String intersectionOXOY(Straight s[]) {
		String sol = "";
		for (int i = 0; i < s.length; i++) {
			sol += "\n" + Show.showStraight(s[i]);
			sol += "\nPoint of intersection with OX:";
			sol += "\n" + com.bam.task.task3.point.Show.showPoint(s[i].intersectionOX());
			sol += "\nPoint of intersection with OY:";
			sol += "\n" + com.bam.task.task3.point.Show.showPoint(s[i].intersectionOY());
		}
		return sol;
	}

	private String parallelStraight(Straight s[]) {
		String sol = "";
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (i != j && s[i].isTwoStraightParallel(s[i], s[j])) {
					sol += "\nParralel straight:";
					sol += Show.showStraight(s[i]);
					sol += Show.showStraight(s[j]);
				}
			}
		}
		return sol;
	}

	private String intersectionTwoStraight(Straight s[]) {
		String sol = "";
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (i != j && !(s[i].isTwoStraightParallel(s[i], s[j]))) {
					sol += "\n\nPoint of intersection with:";
					sol += Show.showStraight(s[i]);
					sol += Show.showStraight(s[j]);
					sol += "\n" + com.bam.task.task3.point.Show.showPoint(s[i].intersectionOfTwoStraight(s[i], s[j]));
				}
			}
		}
		return sol;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Solution clone() throws CloneNotSupportedException {
		return new Solution(source, sol);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution && ((Solution) obj).getSol().equals(sol)
				&& ((Solution) obj).getSource().equals(source)) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		sol = null;
		source = null;
		super.finalize();
		System.gc();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + sol;
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
