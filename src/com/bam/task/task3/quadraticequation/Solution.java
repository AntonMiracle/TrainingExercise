/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.quadraticequation;

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
		QuadraticEquation q[] = new QuadraticEquation[rnd.nextInt(15) + 5];
		for (int i = 0; i < q.length; q[i++] = new QuadraticEquation(i));
		source = "\nSorce list of functions:\n" + Show.showFunction(q);
		sol = "\nSolution : Root from source list:" + "\nFunction with minimal root:" + Show.showFunction(sol(q)[0])
				+ "\nFunction with maximum root:" + Show.showFunction((sol(q))[1]);
	}

	public Solution(String source, String sol) {
		this.source = new String(source);
		this.sol = new String(sol);
	}

	private QuadraticEquation[] sol(QuadraticEquation q[]) {
		QuadraticEquation q1min = new QuadraticEquation(0);
		QuadraticEquation q2max = new QuadraticEquation(0);
		Double min = new Double(0);
		Double max = new Double(0);
		for (int i = 0; i < q.length; i++) {
			if (q[i].getD() >= 0) {
				min = q[i].getX1() > q[i].getX2() ? q[i].getX2() : q[i].getX1();
				max = q[i].getX1() > q[i].getX2() ? q[i].getX1() : q[i].getX2();
				break;
			}
		}
		for (int i = 0; i < q.length; i++) {
			if (q[i].getD() >= 0) {
				min = min > q[i].getX1() ? q[i].getX1() : min;
				min = min > q[i].getX2() ? q[i].getX2() : min;
				max = max < q[i].getX1() ? q[i].getX1() : max;
				max = max < q[i].getX2() ? q[i].getX2() : max;
			}
		}
		try {
			for (int i = 0; i < q.length; i++) {
				if (q[i].getD() >= 0 && q[i].getX1() == min) {
					q1min = q[i].clone();
					break;
				}
				if (q[i].getD() >= 0 && q[i].getX2() == min) {
					q1min = q[i].clone();
					break;
				}
			}
			for (int i = 0; i < q.length; i++) {
				if (q[i].getD() >= 0 && q[i].getX1() == max) {
					q2max = q[i].clone();
					break;
				}
				if (q[i].getD() >= 0 && q[i].getX2() == max) {
					q2max = q[i].clone();
					break;
				}
			}
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		return new QuadraticEquation[]{q1min,q2max};
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + sol;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Solution clone() throws CloneNotSupportedException {
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

	/** Getter */
	public String getSource() {
		return source;
	}

	/** Getter */
	public String getSol() {
		return sol;
	}

}
