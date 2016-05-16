/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.interval;

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
		Interval in[] = new Interval[rnd.nextInt(10) + 5];
		for (int i = 0; i < in.length; in[i++] = new Interval(i));
		source = "\nSource list of intervals:\n" + Show.showInterval(in);
		sol = "\nSolution : Maximum distance between edge in source:\n"
				+ new Integer(maxDistanceBetweenEdge(in)).toString();
		bonus = "\nBonus solution : make different operation with first and second interval from source"
				+ "\nIs interval intersection:\n "
				+ new Boolean(Interval.isIntervalsIntersection(in[0], in[1])).toString() + "\nAssociation interval:\n"
				+ Show.showInterval(Interval.associationInterval(in[0], in[1])) + "\nGeneral interval:\n"
				+ Show.showInterval(Interval.generalInterval(in[0], in[1]));

	}

	public Solution(String source, String sol, String bonus) {
		this.source = new String(source);
		this.sol = new String(sol);
		this.bonus = new String(bonus);
	}

	public static int maxDistanceBetweenEdge(Interval... in) {
		int min = in[0].getBegin(), max = in[0].getEnd();
		for (int i = 0; i < in.length; i++) {
			if (in[i].isBeginInclude()) {
				min = min < in[i].getBegin() ? min : in[i].getBegin();
			} else {
				min = min < in[i].getBegin() + 1 ? min : in[i].getBegin() + 1;
			}
			if (in[i].isEndInclude()) {
				max = max > in[i].getEnd() ? max : in[i].getEnd();
			} else {
				max = max > in[i].getEnd() - 1 ? max : in[i].getEnd() - 1;
			}
		}
		return max - min;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Solution clone() throws CloneNotSupportedException {
		return new Solution(source, sol, bonus);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution) {
			Solution s = (Solution) obj;
			if (s.getBonus().equals(bonus) && s.getSol().equals(sol) && s.getSource().equals(source)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		bonus = null;
		sol = null;
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

	/** Getter */
	public String getBonus() {
		return bonus;
	}

}
