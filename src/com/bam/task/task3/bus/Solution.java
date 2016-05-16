/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.bus;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String	source;
	private String	solA;
	private String	solB;
	private String	solC;

	public Solution() {
		Random rnd = new Random();
		Bus bus[] = new Bus[rnd.nextInt(25) + 5];
		for (int i = 0; i < bus.length; bus[i++] = new Bus(i));
		Bus tmp = new Bus(0);
		source = "\nSource list of Buses:\n" + Show.showBus(bus);
		solA = String.format("Solution A: list of bus which rout number is %s:%n%s", tmp.getRout().toString(),
				Show.showBus(solA(bus, tmp.getRout())));
		Integer lifeAge = new Integer(rnd.nextInt(30) + 10);
		solB = String.format("Solution B: list of bus which life age upper%s:%n%s", lifeAge.toString(),
				Show.showBus(solB(bus, lifeAge)));
		solC = String.format("Solution C: list of bus which mileage upper then %s:%n%s", tmp.getMileage().toString(),
				Show.showBus(solC(bus, tmp.getMileage())));

	}

	public Solution(String source, String solA, String solB, String solC) {
		this.source = new String(source);
		this.solA = new String(solA);
		this.solB = new String(solB);
		this.solC = new String(solC);
	}

	private Bus[] solA(Bus bus[], Integer rout) {
		int count = 0;
		for (int i = 0; i < bus.length; i++) {
			count += bus[i].getRout().equals(rout) ? 1 : 0;
		}
		Bus newB[] = new Bus[count];
		count = 0;
		for (int i = 0; i < bus.length; i++) {
			if (bus[i].getRout().equals(rout)) {
				try {
					newB[count++] = bus[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newB;
	}

	private Bus[] solB(Bus bus[], Integer lifeAge) {
		int count = 0;
		for (int i = 0; i < bus.length; i++) {
			count += (new Integer(2016) - bus[i].getBorn()) > lifeAge ? 1 : 0;
		}
		Bus newB[] = new Bus[count];
		count = 0;
		for (int i = 0; i < bus.length; i++) {
			if ((new Integer(2016) - bus[i].getBorn()) > lifeAge) {
				try {
					newB[count++] = bus[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newB;
	}

	private Bus[] solC(Bus bus[], Integer mileage) {
		int count = 0;
		for (int i = 0; i < bus.length; i++) {
			count += bus[i].getMileage() > mileage ? 1 : 0;
		}
		Bus newB[] = new Bus[count];
		count = 0;
		for (int i = 0; i < bus.length; i++) {
			if (bus[i].getMileage() > mileage) {
				try {
					newB[count++] = bus[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newB;
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
		return 311;
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
