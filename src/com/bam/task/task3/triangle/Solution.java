/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.triangle;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, sol;

	public Solution(String source, String sol) {
		this.source = new String(source);
		this.sol = new String(sol);
	}

	public Solution() {
		Random rnd = new Random();
		Triangle t[] = new Triangle[rnd.nextInt(20) + 10];
		for (int i = 0; i < t.length; t[i++] = new Triangle(i));
		Triangle solT[][] = findMaxMinInType(t);
		source = "\nList of source of triangle:\n" + Show.showTriangle(t);
		sol = "\nSolution count triangle by type:\n" + countByType(t) + "\nMaximum area by type:" + "\n"
				+ Show.showTriangle(solT[0][0]) + "\n" + Show.showTriangle(solT[1][0]) + "\n"
				+ Show.showTriangle(solT[2][0]) + "\n" + Show.showTriangle(solT[3][0]) + "\nMinimum area by type:"
				+ "\n" + Show.showTriangle(solT[0][1]) + "\n" + Show.showTriangle(solT[1][1]) + "\n"
				+ Show.showTriangle(solT[2][1]) + "\n" + Show.showTriangle(solT[3][1]) + "\nMaximum perimetr by type:"
				+ "\n" + Show.showTriangle(solT[0][2]) + "\n" + Show.showTriangle(solT[1][2]) + "\n"
				+ Show.showTriangle(solT[2][2]) + "\n" + Show.showTriangle(solT[3][2]) + "\nMinimum perimetr by type:"
				+ "\n" + Show.showTriangle(solT[0][3]) + "\n" + Show.showTriangle(solT[1][3]) + "\n"
				+ Show.showTriangle(solT[2][3]) + "\n" + Show.showTriangle(solT[3][3]);

	}

	public String countByType(Triangle t[]) {
		int rectangular = 0, arbitrator = 0, equilateral = 0, isosceles = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i].isArbitrary()) {
				arbitrator++;
			}
			if (t[i].isEquilateral()) {
				equilateral++;
			}
			if (t[i].isIsosceles()) {
				isosceles++;
			}
			if (t[i].isRectangular()) {
				rectangular++;
			}
		}
		String show = "";
		show += "Arbitrator " + (arbitrator == 0 ? "0" : new Integer(arbitrator).toString());
		show += ", equilateral " + (equilateral == 0 ? "0" : new Integer(equilateral).toString());
		show += ", isosceles " + (isosceles == 0 ? "0" : new Integer(isosceles).toString());
		show += ", rectangular " + (rectangular == 0 ? "0" : new Integer(rectangular).toString());
		return show += ".";
	}

	public Triangle[][] findMaxMinInType(Triangle t[]) {
		Triangle newT[][] = new Triangle[4][];
		int count = 0;
		Triangle maxA = null;
		Triangle maxP = null;
		Triangle minA = null;
		Triangle minP = null;
		try {
			for (int i = 0; i < t.length; i++) {
				if (t[i].isArbitrary()) {
					if (count == 0) {
						maxA = t[i].clone();
						maxP = t[i].clone();
						minA = t[i].clone();
						minP = t[i].clone();
						count++;
					}
					maxA = maxA.getArea() > t[i].getArea() ? maxA.clone() : t[i].clone();
					minA = minA.getArea() < t[i].getArea() ? minA.clone() : t[i].clone();
					maxP = maxP.getPerimetr() > t[i].getPerimetr() ? maxP.clone() : t[i].clone();
					minP = minP.getPerimetr() < t[i].getPerimetr() ? minP.clone() : t[i].clone();
				}
			}
			newT[0] = new Triangle[]{maxA,minA,maxP,minP};
			count = 0;
			maxA = null;
			maxP = null;
			minA = null;
			minP = null;
			for (int i = 0; i < t.length; i++) {
				if (t[i].isEquilateral()) {
					if (count == 0) {
						maxA = t[i].clone();
						maxP = t[i].clone();
						minA = t[i].clone();
						minP = t[i].clone();
						count++;
					}
					maxA = maxA.getArea() > t[i].getArea() ? maxA.clone() : t[i].clone();
					minA = minA.getArea() < t[i].getArea() ? minA.clone() : t[i].clone();
					maxP = maxP.getPerimetr() > t[i].getPerimetr() ? maxP.clone() : t[i].clone();
					minP = minP.getPerimetr() < t[i].getPerimetr() ? minP.clone() : t[i].clone();
				}
			}
			newT[1] = new Triangle[]{maxA,minA,maxP,minP};
			count = 0;
			maxA = null;
			maxP = null;
			minA = null;
			minP = null;
			for (int i = 0; i < t.length; i++) {
				if (t[i].isIsosceles()) {
					if (count == 0) {
						maxA = t[i].clone();
						maxP = t[i].clone();
						minA = t[i].clone();
						minP = t[i].clone();
						count++;
					}
					maxA = maxA.getArea() > t[i].getArea() ? maxA.clone() : t[i].clone();
					minA = minA.getArea() < t[i].getArea() ? minA.clone() : t[i].clone();
					maxP = maxP.getPerimetr() > t[i].getPerimetr() ? maxP.clone() : t[i].clone();
					minP = minP.getPerimetr() < t[i].getPerimetr() ? minP.clone() : t[i].clone();
				}
			}
			newT[2] = new Triangle[]{maxA,minA,maxP,minP};
			count = 0;
			maxA = null;
			maxP = null;
			minA = null;
			minP = null;
			for (int i = 0; i < t.length; i++) {
				if (t[i].isRectangular()) {
					if (count == 0) {
						maxA = t[i].clone();
						maxP = t[i].clone();
						minA = t[i].clone();
						minP = t[i].clone();
						count++;
					}
					maxA = maxA.getArea() > t[i].getArea() ? maxA.clone() : t[i].clone();
					minA = minA.getArea() < t[i].getArea() ? minA.clone() : t[i].clone();
					maxP = maxP.getPerimetr() > t[i].getPerimetr() ? maxP.clone() : t[i].clone();
					minP = minP.getPerimetr() < t[i].getPerimetr() ? minP.clone() : t[i].clone();
				}
			}
			newT[3] = new Triangle[]{maxA,minA,maxP,minP};
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		for (int i = 0; i < newT.length; i++) {
			for (int j = 0; j < newT[i].length; j++) {
				if (newT[i][j] == null) {
					newT[i][j] = new Triangle(0);
				}
			}
		}
		return newT;
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
		if (obj instanceof Solution && ((Solution) obj).getSol().equals(sol)
				&& ((Solution) obj).getSource().equals(source)) {
			return true;
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
		return 877;
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
