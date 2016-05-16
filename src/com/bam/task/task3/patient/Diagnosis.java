/**
 * Project: Tasks Diagnosis.java
 */
package com.bam.task.task3.patient;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class Diagnosis {
	final private int		PRIME		= 47;
	private String			diagnosis;
	final private String	DIAGNOSIS[]	= new String[]{"ORZ","Vospalenie hitrosti","Bolit golova","Ranenie","Nasmork"};
	Random					rnd			= new Random();

	public Diagnosis() {
		diagnosis = randomDiagnosis();
	}

	public Diagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	private String randomDiagnosis() {
		return DIAGNOSIS[rnd.nextInt(DIAGNOSIS.length)];
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Diagnosis clone() throws CloneNotSupportedException {
		return new Diagnosis(diagnosis);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Diagnosis) {
			if (((Diagnosis) obj).getDiagnosis().equals(diagnosis)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		diagnosis = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 3;
		result = result * PRIME;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return diagnosis;
	}

	/** Getter */
	public String getDiagnosis() {
		return diagnosis;
	}

	/** Getter */
	public String[] getDIAGNOSIS() {
		return DIAGNOSIS;
	}

}
