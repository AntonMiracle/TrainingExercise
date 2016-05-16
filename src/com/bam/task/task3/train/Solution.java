/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.train;

import java.util.Random;

import com.bam.task.task3.generalclasses.Time;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, solA, solB, solC;

	public Solution() {
		Random rnd = new Random();
		Train random = new Train(0);
		Train tra[] = new Train[rnd.nextInt(20) + 5];
		for (int i = 0; i < tra.length; i++) {
			tra[i] = new Train(i + 1);
		}
		source = com.bam.task.task3.train.Show.showTrain(tra);
		solA = "\nSolution A: list of traines which destination is " + random.getDestination()
				+ Show.showTrain(solA(tra, random.getDestination()));
		solB = "\nSolution B: list of traines which destination is " + random.getDestination()
				+ " , and departure after " + random.getDeparture().toString()
				+ Show.showTrain(solB(tra, random.getDestination(), random.getDeparture()));
		solC = "\nSolution C: list of traines which destination is " + random.getDestination()
				+ " , and value of general seats more then zero " + Show.showTrain(solC(tra, random.getDestination()));

	}

	public Solution(String source, String solA, String solB, String solC) {
		this.source = new String(source);
		this.solA = new String(solA);
		this.solB = new String(solB);
		this.solC = new String(solC);
	}

	private Train[] solA(Train tra[], String destination) {
		int count = 0;
		for (int i = 0; i < tra.length; i++) {
			count += tra[i].getDestination().equals(destination) ? 1 : 0;
		}
		Train t[] = new Train[count];
		count = 0;
		for (int i = 0; i < tra.length; i++) {
			if (tra[i].getDestination().equals(destination)) {
				try {
					t[count++] = tra[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return t;
	}

	private Train[] solB(Train tra[], String destination, Time departure) {
		Train list[] = solA(tra, destination);
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getDeparture().getHour() > departure.getHour()) {
				count++;
			}
			if (list[i].getDeparture().getHour() == departure.getHour()
					&& list[i].getDeparture().getMinut() > departure.getMinut()) {
				count++;
			}
		}
		Train t[] = new Train[count];
		count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getDestination().equals(destination)) {
				try {
					if (list[i].getDeparture().getHour() > departure.getHour()) {
						t[count++] = list[i].clone();
					}
					if (list[i].getDeparture().getHour() == departure.getHour()
							&& list[i].getDeparture().getMinut() > departure.getMinut()) {
						t[count++] = list[i].clone();
					}

				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return t;
	}

	private Train[] solC(Train tra[], String destination) {
		Train list[] = solA(tra, destination);
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			count += list[i].getNumberGeneral() > 0 ? 1 : 0;
		}
		Train t[] = new Train[count];
		count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getNumberGeneral() > 0) {
				try {
					t[count++] = list[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return t;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Solution clone() throws CloneNotSupportedException {
		return new Solution(source, solA, solB, solC);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution) {
			Solution s = (Solution) obj;
			if (s.getSource().equals(source) && s.getSolA().equals(solA) && s.getSolB().equals(solB)
					&& s.getSolC().equals(solC)) {
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
		solC = null;
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
		return source + solA + solB + solC;
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

	/** Getter */
	public String getSolC() {
		return solC;
	}

}
