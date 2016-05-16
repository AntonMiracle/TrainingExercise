/**
 * Project: Tasks Patient.java
 */
package com.bam.task.task3.patient;

import com.bam.task.task3.generalclasses.Adress;
import com.bam.task.task3.generalclasses.Human;
import com.bam.task.task3.generalclasses.PhoneNumber;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class Patient {
	final private int	PRIME	= 499;
	private Integer			id;
	private Human		human;
	private Adress		adress;
	private PhoneNumber	phone;
	private MedicalCard	cardId;
	private Diagnosis	diagnosis;

	public Patient(int id) {
		this.id = new Integer(id);
		human = new Human();
		adress = new Adress();
		phone = new PhoneNumber();
		cardId = new MedicalCard();
		diagnosis = new Diagnosis();
	}

	private Patient(int id, Human human, Adress adress, PhoneNumber phone, MedicalCard cardId, Diagnosis diagnosis) {
		this.id = new Integer(id);
		this.human = human;
		this.adress = adress;
		this.phone = phone;
		this.cardId = cardId;
		this.diagnosis = diagnosis;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Patient clone() throws CloneNotSupportedException {
		return new Patient(id, human, adress, phone, cardId, diagnosis);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Patient) {
			Patient pat = (Patient) obj;
			if (pat.getId() == id && pat.getHuman().equals(human) && pat.getAdress().equals(adress)
					&& pat.getPhone().equals(phone) && pat.getCardId().equals(cardId)
					&& pat.getDiagnosis().equals(diagnosis)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Patient id:" + id + "\n" + human + "\nAdress: " + adress + "\nPhone number" + phone
				+ "\nMedical card Id: " + cardId + "\nDiagnosis: " + diagnosis;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		human = null;
		adress = null;
		phone = null;
		cardId = null;
		diagnosis = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 7;
		return result * PRIME;
	}

	/** Getter */
	public Human getHuman() {
		return human;
	}

	/** Getter */
	public Adress getAdress() {
		return adress;
	}

	/** Getter */
	public PhoneNumber getPhone() {
		return phone;
	}

	/** Getter */
	public MedicalCard getCardId() {
		return cardId;
	}

	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

}
