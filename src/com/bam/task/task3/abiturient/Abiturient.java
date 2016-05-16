/**
 * Project: Tasks Abiturient.java
 */
package com.bam.task.task3.abiturient;

import com.bam.task.task3.abiturient.certificate.Certificate;
import com.bam.task.task3.generalclasses.Adress;
import com.bam.task.task3.generalclasses.Human;
import com.bam.task.task3.generalclasses.PhoneNumber;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12 лют. 2016 р.
 *
 */
public class Abiturient {
	final private int	PRIME	= 797;
	private Integer		id;
	private Human		human;
	private Adress		adress;
	private PhoneNumber	phone;
	private Certificate	certificate;

	public Abiturient(int id) {
		this.id = new Integer(id);
		human = new Human();
		adress = new Adress();
		phone = new PhoneNumber();
		certificate = new Certificate();
	}

	private Abiturient(Integer id, Human human, Adress adress, PhoneNumber phone, Certificate certificate) {
		this.id = id;
		this.human = human;
		this.adress = adress;
		this.phone = phone;
		this.certificate = certificate;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Abiturient clone() throws CloneNotSupportedException {
		return new Abiturient(id, human, adress, phone, certificate);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Abiturient) {
			Abiturient newA = (Abiturient) obj;
			if (newA.getId().equals(id) && newA.getHuman().equals(human) && newA.getAdress().equals(adress)
					&& newA.getPhone().equals(phone) && newA.getCertificate().equals(certificate)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		human = null;
		adress = null;
		phone = null;
		certificate = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/** Getter */
	public Integer getId() {
		return id;
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
	public Certificate getCertificate() {
		return certificate;
	}

}
