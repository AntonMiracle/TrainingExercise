/**
 * Project: Tasks Fraction.java
 */
package com.bam.task.task3.fraction;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Fraction {
	private Integer	numerator;
	private Integer	denominator;
	private String	div;

	public Fraction() {
		Random rnd = new Random();
		numerator = new Integer(rnd.nextInt(100) + 1);
		denominator = new Integer(rnd.nextInt(100) + 1);
		div = "----";
	}

	public Fraction(Integer numerator, Integer denominator, String div) {
		this.numerator = new Integer(numerator);
		this.denominator = new Integer(denominator);
		this.div = new String(div);
	}

	public static Integer randomInput(int bountOfNumber) {
		Random rnd = new Random();
		return new Integer(rnd.nextInt(bountOfNumber) + 1);
	}

	public static Fraction sumTwoFraction(Fraction fra1, Fraction fra2) {
		Fraction newF = new Fraction();
		Integer nok = findNOK(fra1.getDenominator(), fra2.getDenominator());
		newF.setDenominator(nok);
		newF.setNumerator(((nok / fra1.getDenominator()) * fra1.getNumerator())
				+ ((nok / fra2.getDenominator()) * fra2.getNumerator()));
		return newF;
	}

	public static Fraction substractionTwoFraction(Fraction fra1, Fraction fra2) {
		Fraction newF = new Fraction();
		Integer nok = findNOK(fra1.getDenominator(), fra2.getDenominator());
		newF.setDenominator(nok);
		newF.setNumerator(((nok / fra1.getDenominator()) * fra1.getNumerator())
				- ((nok / fra2.getDenominator()) * fra2.getNumerator()));
		return newF;
	}

	public static Fraction divisionTwoFraction(Fraction fra1, Fraction fra2) {
		Fraction newF = new Fraction();
		newF.setNumerator(fra1.getNumerator() * fra2.getDenominator());
		newF.setDenominator(fra1.getDenominator() * fra2.getNumerator());
		return newF;
	}

	public static Fraction compositionTwoFraction(Fraction fra1, Fraction fra2) {
		Fraction newF = new Fraction();
		newF.setNumerator(fra1.getNumerator() * fra2.getNumerator());
		newF.setDenominator(fra1.getDenominator() * fra2.getDenominator());
		return newF;
	}

	public static Integer findNOK(Integer num1, Integer num2) {
		for (int i = 1; i < 20_000; i++) {
			if (new Integer(i) % num1 == 0 && new Integer(i) % num2 == 0) {
				return new Integer(i);
			}
		}
		return null;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Fraction [numerator=" + numerator + ", denominator=" + denominator + ", div=" + div + "]";
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Fraction clone() throws CloneNotSupportedException {
		return new Fraction(numerator, denominator, div);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fraction) {
			if (((Fraction) obj).getDenominator().equals(denominator)
					&& ((Fraction) obj).getNumerator().equals(numerator)) {
				return true;
			}
		}
		return false;
	}

	/** Getter */
	public String getDiv() {
		return div;
	}

	/** Setter */
	public void setDiv(String div) {
		this.div = div;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		denominator = null;
		numerator = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 293;
	}

	/** Getter */
	public Integer getNumerator() {
		return numerator;
	}

	/** Getter */
	public Integer getDenominator() {
		return denominator;
	}

	/** Setter */
	public void setNumerator(Integer numerator) {
		this.numerator = new Integer(numerator);
	}

	/** Setter */
	public void setDenominator(Integer denominator) {
		this.denominator = new Integer(denominator);
	}

}
