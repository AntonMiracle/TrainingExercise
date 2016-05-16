/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.circle;

import java.util.Random;

import com.bam.task.task3.generalclasses.CloneArray;
import com.bam.task.task3.straight.Straight;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String		source, sol;
	private Circle		c[], onSameStraight[];
	private Straight	straight;

	public Solution(String source, String sol) {
		this.source = new String(source);
		this.sol = new String(sol);
	}

	public Solution() {
		Random rnd = new Random();
		c = new Circle[rnd.nextInt(20) + 5];
		for (int i = 0; i < c.length; c[i++] = new Circle(i));
		source = "\nSource of circles:" + Show.show(c);
		straight = straightWithMaxCirclesCentre(c);
		sol = "\nStraight on which maximum centre point of circles :" + straight.toString();
		sol += "\nCircle with max and min area and perimetr:" + showMaxAndMinPerimetrArea(c);
		sol += "\nSolution: list of circles which on same straight:\n"
				+ Show.show((onSameStraight.length > 2 ? onSameStraight : new Circle[]{new Circle(0)}));
	}

	public String showMaxAndMinPerimetrArea(Circle c[]) {
		String res = "";
		Circle maxA = null;
		Circle minA = null;
		Circle maxP = null;
		Circle minP = null;
		try {
			maxA = c[0].clone();
			minA = c[0].clone();
			maxP = c[0].clone();
			minP = c[0].clone();
			for (int i = 0; i < c.length; i++) {
				maxA = maxA.getArea() < c[i].getArea() ? c[i].clone() : maxA;
				minA = minA.getArea() > c[i].getArea() ? c[i].clone() : minA;
				maxP = maxP.getPerimetr() < c[i].getPerimetr() ? c[i].clone() : maxP;
				minP = minP.getPerimetr() > c[i].getPerimetr() ? c[i].clone() : minP;
			}
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		res += "\nCircle with maximum area:" + Show.show(maxA);
		res += "\nCircle with minimum area:" + Show.show(minA);
		res += "\nCircle with maximum perimetr:" + Show.show(maxA);
		res += "\nCircle with minimum perimetr:" + Show.show(minA);
		return res;
	}

	public Straight straightWithMaxCirclesCentre(Circle c[]) {
		int count = 0;
		int checkCount = 0;
		Circle checkNewC[] = null;
		Circle newC[] = null;
		Straight checkStraight = null;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (i != j) {
					Straight straight = new Straight(c[i].getC(), c[j].getC());
					for (int k = 0; k < c.length; k++) {
						if (straight.isPointOnStraight(c[k].getC())) {
							count++;
							try {
								if (newC == null) {
									newC = new Circle[1];
									newC[0] = c[k].clone();
								} else {
									Circle tmp[] = CloneArray.circle(newC);
									newC = new Circle[newC.length + 1];
									for (int l = 0; l < tmp.length; l++) {
										newC[l] = tmp[l].clone();
									}
									newC[newC.length - 1] = c[k].clone();
								}
							} catch (CloneNotSupportedException ex) {
								System.out.println(ex);
							}
						}
					}
					if (checkStraight == null) {
						checkStraight = straight;
						checkCount = count;
						checkNewC = newC;
					} else {
						if (checkCount < count) {
							checkStraight = straight;
							checkCount = count;
							checkNewC = newC;
						}
					}
				}
				count = 0;
				newC = null;
			}
		}
		onSameStraight = checkNewC;
		return checkStraight;
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
		c = null;
		onSameStraight = null;
		sol = null;
		source = null;
		straight = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 641;
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
