/**
 * Project: Tasks Phone.java
 */
package com.bam.task.task3.phone;

import com.bam.task.task3.generalclasses.Adress;
import com.bam.task.task3.generalclasses.CreditCard;
import com.bam.task.task3.generalclasses.DebitCredit;
import com.bam.task.task3.generalclasses.Human;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Phone {
	final private int	PRIME	= 691;
	private Integer		id;
	private Human		human;
	private Adress		adress;
	private CreditCard	cardId;
	private DebitCredit	debitCredit;
	private Calls		calls;

	public Phone(int id) {
		this.id = new Integer(id);
		human = new Human();
		adress = new Adress();
		cardId = new CreditCard();
		debitCredit = new DebitCredit();
		calls = new Calls();
	}

	private Phone(Integer id, Human human, Adress adress, CreditCard cardId, DebitCredit debitCredit, Calls calls) {
		this.id = id;
		this.human = human;
		this.adress = adress;
		this.cardId = cardId;
		this.debitCredit = debitCredit;
		this.calls = calls;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Phone clone() throws CloneNotSupportedException {
		return new Phone(id, human, adress, cardId, debitCredit, calls);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Phone) {
			Phone newP = (Phone) obj;
			if (newP.getAdress().equals(adress) && newP.getCalls().equals(calls) && newP.getCardId().equals(cardId)
					&& newP.getDebitCredit().equals(debitCredit) && newP.getHuman().equals(human)
					&& newP.getId().equals(id)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		adress = null;
		calls = null;
		cardId = null;
		debitCredit = null;
		human = null;
		id = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME;
	}
	
	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Phone [id=" + id + ", human=" + human + ", adress=" + adress + ", \ncardId=" + cardId + ", debitCredit="
				+ debitCredit + ", calls=" + calls + "]";
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
	public CreditCard getCardId() {
		return cardId;
	}

	/** Getter */
	public DebitCredit getDebitCredit() {
		return debitCredit;
	}

	/** Getter */
	public Calls getCalls() {
		return calls;
	}

}
