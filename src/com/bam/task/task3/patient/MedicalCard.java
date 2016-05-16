/**
 * Project: Tasks MedicalCard.java
 */
package com.bam.task.task3.patient;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class MedicalCard {
	final private int	PRIME	= 97;
	private Integer		cardId;
	Random				rnd		= new Random();

	public MedicalCard() {
		cardId = randomCardId();
	}

	public MedicalCard(Integer cardId) {
		this.cardId = cardId;
	}

	private Integer randomCardId() {
		String num = "";
		for (int i = 0; i < 6; i++) {
			num += new Integer(rnd.nextInt(10)).toString();
		}
		return Integer.valueOf(num);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected MedicalCard clone() throws CloneNotSupportedException {
		return new MedicalCard(cardId);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof MedicalCard) {
			if (((MedicalCard) obj).getCardId().equals(cardId)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		cardId = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		int result = 7;
		result = result * PRIME;
		return result;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return cardId.toString();
	}

	/** Getter */
	public Integer getCardId() {
		return cardId;
	}

}
