/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.airline;

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
		AirLine air[] = new AirLine[rnd.nextInt(30) + 5];
		for (int i = 0; i < air.length; air[i++] = new AirLine(i));
		source = "Source list of airline:\n" + Show.air(air);
		AirLine tmp = new AirLine(0);
		solA = "Solution A: list of aircraft which destination is " + tmp.getDestination() + "\n"
				+ Show.air(solA(air, tmp.getDestination()));
		solB = "Solution B: list of aircraft which departure in " + tmp.getDay() + "\n"
				+ Show.air(solB(air, tmp.getDay()));
		solC = "Solution C: list of aircraft  which departure in " + tmp.getDay() + " after "
				+ tmp.getDeparture().toString() + "\n" + Show.air(solC(air, tmp.getDay(), tmp.getDeparture()));
	}

	private Solution(String source, String solA, String solB, String solC) {
		this.solA = new String(source);
		this.solA = new String(solA);
		this.solB = new String(solB);
		this.solC = new String(solC);
	}

	private AirLine[] solA(AirLine air[], String destination) {
		int count = 0;
		for (int i = 0; i < air.length; i++) {
			count += air[i].getDestination().equals(destination) ? 1 : 0;
		}
		AirLine newA[] = new AirLine[count];
		count = 0;
		for (int i = 0; i < air.length; i++) {
			if (air[i].getDestination().equals(destination)) {
				try {
					newA[count++] = air[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newA;
	}

	private AirLine[] solB(AirLine air[], String day) {
		int count = 0;
		for (int i = 0; i < air.length; i++) {
			count += air[i].getDay().equals(day) ? 1 : 0;
		}
		AirLine newA[] = new AirLine[count];
		count = 0;
		for (int i = 0; i < air.length; i++) {
			if (air[i].getDay().equals(day)) {
				try {
					newA[count++] = air[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newA;
	}

	private AirLine[] solC(AirLine newA[], String day, Time time) {
		AirLine air[] = solB(newA, day);
		int count = 0;
		for (int i = 0; i < air.length; i++) {
			if (air[i].getDeparture().getHour() > time.getHour()) {
				count++;
			}
			if (air[i].getDeparture().getHour() == time.getHour()
					&& air[i].getDeparture().getMinut() > time.getMinut()) {
				count++;
			}
		}
		AirLine a[] = new AirLine[count];
		count = 0;
		for (int i = 0; i < air.length; i++) {
			try {
				if (air[i].getDeparture().getHour() > time.getHour()) {
					a[count++] = air[i].clone();
				}
				if (air[i].getDeparture().getHour() == time.getHour()
						&& air[i].getDeparture().getMinut() > time.getMinut()) {
					a[count++] = air[i].clone();
				}
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return a;
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
			if (s.getSolA().equals(solA) && s.getSolB().equals(solB) && s.getSolC().equals(solC)
					&& s.getSource().equals(source)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		solA = null;
		solB = null;
		solC = null;
		source = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 7;
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
