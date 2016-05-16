/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.quadrangle;

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
		Quadrangle q[] = new Quadrangle[rnd.nextInt(20) + 5];
		for (int i = 0; i < q.length; q[i++] = new Quadrangle(i));
		source = "\nList source of quadrangle:" + Show.show(q);
		sol = "\nSolution : Count quadrangle by type:" + countByAllType(q);
		sol += "\nSolution : List of quadrangle with minimum and maximum area and perimetr:"
				+ findMinAndMaxOfTheType(q);
	}

	public Solution(String source, String sol) {
		this.sol = new String(sol);
		this.source = new String(source);
	}

	private String findMinAndMax(String type, Quadrangle q[]) {
		String res = "";
		Quadrangle maxA = findMaxArea(findSameType(type, q)) != null ? findMaxArea(findSameType(type, q))
				: new Quadrangle(0);
		Quadrangle minA = findMinArea(findSameType(type, q)) != null ? findMinArea(findSameType(type, q))
				: new Quadrangle(0);
		Quadrangle maxP = findMaxPerimetr(findSameType(type, q)) != null ? findMaxPerimetr(findSameType(type, q))
				: new Quadrangle(0);
		Quadrangle minP = findMinPerimetr(findSameType(type, q)) != null ? findMinPerimetr(findSameType(type, q))
				: new Quadrangle(0);

		res += "\n" + type + " with maximum area:\n" + Show.show(maxA);
		res += "\n" + type + " with minimum area:\n" + Show.show(minA);
		res += "\n" + type + " with maximum perimetr:\n" + Show.show(maxP);
		res += "\n" + type + " with minimum perimetr:\n" + Show.show(minP);
		return res;
	}

	private String findMinAndMaxOfTheType(Quadrangle q[]) {
		String res = "";
		String type = q[0].getTYPES()[0];
		res += findMinAndMax(type, q);
		type = q[0].getTYPES()[1];
		res += findMinAndMax(type, q);
		type = q[0].getTYPES()[2];
		res += findMinAndMax(type, q);
		type = q[0].getTYPES()[3];
		res += findMinAndMax(type, q);
		return res;
	}

	private Quadrangle[] findSameType(String type, Quadrangle q[]) {
		int count = 0;
		for (int i = 0; i < q.length; i++) {
			count += type.equals(q[i].getType()) ? 1 : 0;
		}
		Quadrangle newQ[] = new Quadrangle[count];
		count = 0;
		for (int i = 0; i < q.length; i++) {
			if (type.equals(q[i].getType())) {
				newQ[count++] = q[i];
			}
		}
		return newQ;
	}

	private Quadrangle findMinArea(Quadrangle q[]) {
		if (q.length != 0) {
			Quadrangle min = q[0];
			for (int i = 0; i < q.length; i++) {
				min = min.getArea() > q[i].getArea() ? min = q[i] : min;
			}
			return min;
		} else {
			return new Quadrangle(0);
		}
	}

	private Quadrangle findMaxArea(Quadrangle q[]) {
		if (q.length != 0) {
			Quadrangle max = q[0];
			for (int i = 0; i < q.length; i++) {
				max = max.getArea() < q[i].getArea() ? max = q[i] : max;
			}
			return max;
		} else {
			return new Quadrangle(0);
		}
	}

	private Quadrangle findMinPerimetr(Quadrangle q[]) {
		if (q.length != 0) {
			Quadrangle min = q[0];
			for (int i = 0; i < q.length; i++) {
				min = min.getPerimetr() > q[i].getPerimetr() ? min = q[i] : min;
			}
			return min;
		} else {
			return new Quadrangle(0);
		}
	}

	private Quadrangle findMaxPerimetr(Quadrangle q[]) {
		if (q.length != 0) {
			Quadrangle max = q[0];
			for (int i = 0; i < q.length; i++) {
				max = max.getPerimetr() < q[i].getPerimetr() ? max = q[i] : max;
			}
			return max;
		} else {
			return new Quadrangle(0);
		}
	}

	private String countByAllType(Quadrangle q[]) {
		String list = "\n";
		list += countType(q[0].getTYPES()[0], q);
		list += ",\n" + countType(q[0].getTYPES()[1], q);
		list += ",\n" + countType(q[0].getTYPES()[2], q);
		list += ",\n" + countType(q[0].getTYPES()[3], q) + ".";
		return list;
	}

	private String countType(String type, Quadrangle q[]) {
		int count = 0;
		for (int i = 0; i < q.length; i++) {
			if (q[i].getType().equals(type)) {
				count++;
			}
		}
		return type + " " + new Integer(count).toString();
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
		sol = null;
		source = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 701;
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
