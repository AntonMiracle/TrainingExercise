/**
 * Project: Tasks SolutionAbiturient.java
 */
package com.bam.task.task3.abiturient;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class SolutionAbiturient {
	final private int	PRIME	= 139;
	private Abiturient	abi[];
	private String		show;
	private String		solutionA;
	private String		solutionB;
	private String		solutionC;
	Random				rnd		= new Random();

	public SolutionAbiturient(int valueOfAbiturients, int numberOfAbiturientWithUpeerMarks) {
		abi = new Abiturient[valueOfAbiturients];
		for (int i = 0; i < abi.length; i++) {
			abi[i] = new Abiturient(i + 1);
		}
		show = new ShowAbiturient(abi).getShow();
		solutionA = solutionA(abi);
		solutionB = solutionB(abi);
		solutionC = solutionC(numberOfAbiturientWithUpeerMarks, abi);
	}

	private SolutionAbiturient(Abiturient abi[], String show, String solutionA, String solutionB, String solutionC) {
		this.abi = abi;
		this.show = show;
		this.solutionA = solutionA;
		this.solutionB = solutionB;
		this.solutionC = solutionC;
	}

	private String solutionA(Abiturient abi[]) {
		String list = "\nAbiturients which have marks less than 3:";
		Abiturient newA[] = SortAbiturient.lessMark(2, abi);
		list += new ShowAbiturient(newA).getShow();
		return list;
	}

	private String solutionB(Abiturient abi[]) {
		String list = "\nAbiturients which have sum of all marks upper 20:";
		Abiturient newA[] = SortAbiturient.sumOfMarksUpperValue(20, abi);
		list += new ShowAbiturient(newA).getShow();
		return list;
	}

	private String solutionC(int numberOfAbiturient, Abiturient abi[]) {
		String list = "\n" + new Integer(numberOfAbiturient).toString()
				+ " abiturients which have best value sum of all marks:";
		Abiturient newA[] = SortAbiturient.maxValueOfMarks(numberOfAbiturient, abi);
		list += new ShowAbiturient(newA).getShow();
		return list;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SolutionAbiturient :\nList of all abiturient " + show + "\nSolution A:\n" + solutionA
				+ "\nSolution B:\n" + solutionB + "\nSolution C:\n" + solutionC;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionAbiturient clone() throws CloneNotSupportedException {
		return new SolutionAbiturient(abi, show, solutionA, solutionB, solutionC);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionAbiturient) {
			SolutionAbiturient cond = (SolutionAbiturient) obj;
			if (cond.getShow().equals(show) && cond.getSolutionA().equals(solutionA)
					&& cond.getSolutionB().equals(solutionB) && cond.getSolutionC().equals(solutionC)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		show = null;
		solutionA = null;
		solutionB = null;
		solutionC = null;
		abi = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 3 * PRIME;
	}

	/** Getter */
	public String getSolutionA() {
		return solutionA;
	}

	/** Getter */
	public String getSolutionB() {
		return solutionB;
	}

	/** Getter */
	public String getSolutionC() {
		return solutionC;
	}

	/** Getter */
	public Abiturient[] getAbi() {
		return abi;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

}
