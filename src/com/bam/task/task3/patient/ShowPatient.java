/**
 * Project: Tasks ShowPatient.java
 */
package com.bam.task.task3.patient;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class ShowPatient {
	final private int	PRIME	= 7;
	private String		show;

	public ShowPatient(Patient pat) {
		show = showOnePatient(pat);
	}

	public ShowPatient(Patient pat[]) {
		show = "";
		for (int i = 0; i < pat.length; i++) {
			show += showOnePatient(pat[i]);
		}
	}

	private ShowPatient(String show) {
		this.show = new String(show);
	}

	private String showOnePatient(Patient pat) {
		String show = "";
		show += "\n-------------------" + "\n|    Patient id   | " + pat.getId().toString() + "\n|    Full name    | "
				+ pat.getHuman().toString() + "\n|     Adress      | " + pat.getAdress().toString()
				+ "\n|     Phone       | " + pat.getPhone().toString() + "\n| Medical card id | "
				+ pat.getCardId().toString() + "\n|    Diagnosis    | " + pat.getDiagnosis().toString()
				+ "\n-------------------";
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowPatient clone() throws CloneNotSupportedException {
		return new ShowPatient(show);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof ShowPatient) {
			if (((ShowPatient) obj).getShow().equals(show)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		show = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 7;
		return result * PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return show;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

}
