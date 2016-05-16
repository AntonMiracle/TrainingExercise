/**
 * Project: Tasks SolutionPatient.java
 */
package com.bam.task.task3.patient;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class SolutionPatient {
	final private int	PRIME	= 467;
	private Patient		pats[];
	private String		solutionA;
	private String		solutionB;

	public SolutionPatient(int valueNumberOfPatient) {
		pats = new Patient[valueNumberOfPatient];
		for (int i = 0; i < pats.length; i++) {
			pats[i] = new Patient(i + 1);
		}
		solutionA = solutionA(pats);
		solutionB = solutionB(pats);
	}

	public SolutionPatient(Patient pats[], String solutionA, String solutionB) {
		this.pats = pats;
		this.solutionA = solutionA;
		this.solutionB = solutionB;
	}

	private String solutionA(Patient pats[]) {
		String sol = "";
		Diagnosis dia = new Diagnosis();
		sol += "\nList of patient with diagnosis : " + dia.toString();
		for (int i = 0; i < pats.length; i++) {
			if (pats[i].getDiagnosis().equals(dia)) {
				sol += new ShowPatient(pats[i]).getShow();
			}
		}
		return sol;
	}

	private String solutionB(Patient pats[]) {
		MedicalCard interval[] = randomIntervalCardId();
		String list = "Patient which has number of card ID in interval:\nFrom " + interval[0] + "\nTo " + interval[1];
		for (int i = 0; i < pats.length; i++) {
			if (interval[0].getCardId() <= pats[i].getCardId().getCardId()
					&& interval[1].getCardId() >= pats[i].getCardId().getCardId()) {
				list += new ShowPatient(pats[i]).getShow();
			}
		}
		return list;
	}

	private MedicalCard[] randomIntervalCardId() {
		MedicalCard mc1 = new MedicalCard();
		MedicalCard mc2 = new MedicalCard();
		while (mc1.getCardId() >= mc2.getCardId()) {
			mc2 = new MedicalCard();
		}
		return new MedicalCard[]{mc1,mc2};
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionPatient clone() throws CloneNotSupportedException {
		return new SolutionPatient(pats, solutionA, solutionB);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionPatient) {
			SolutionPatient pat = (SolutionPatient) obj;
			if (pat.getSolutionA().equals(solutionA) && pat.getSolutionB().equals(solutionB)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		pats = null;
		solutionA = null;
		solutionB = null;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SolutionPatient list of patient:\n " + new ShowPatient(pats).toString() + "\nSolutionA: \n" + solutionA
				+ "\nSolutionB: \n" + solutionB;

	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 7 * PRIME;
	}

	/** Getter */
	public Patient[] getPats() {
		return pats;
	}

	/** Getter */
	public String getSolutionA() {
		return solutionA;
	}

	/** Getter */
	public String getSolutionB() {
		return solutionB;
	}

}
