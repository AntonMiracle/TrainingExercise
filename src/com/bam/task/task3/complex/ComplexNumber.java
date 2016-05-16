/**
 * Project: Tasks ComplexNumber.java
 */
package com.bam.task.task3.complex;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class ComplexNumber {
	private String	z;
	private Double	a, b;

	public ComplexNumber(int id) {
		Random rnd = new Random();
		z = "z" + new Integer(id).toString();
		a = new Double(rnd.nextDouble() + rnd.nextInt(20) - 10);
		b = new Double(rnd.nextDouble() + rnd.nextInt(20) - 10);		
	}

	public ComplexNumber(String z, Double a, Double b) {
		this.z = new String(z);
		this.a = new Double(a);
		this.b = new Double(b);
	}

	public static ComplexNumber sumTwoNumber(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber tmp = new ComplexNumber(0);
		tmp.setZ(num1.getZ() + "+" + num2.getZ());
		tmp.setA(num1.getA() + num2.getA());
		tmp.setB(num1.getB() + num2.getB());
		return tmp;
	}

	public static ComplexNumber[] substractionTwoNumber(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber tmp = new ComplexNumber(0);
		ComplexNumber tmp2 = new ComplexNumber(0);
		tmp.setZ(num2.getZ() + "-" + num1.getZ());
		tmp.setA(num2.getA() - num1.getA());
		tmp.setB(num2.getB() - num1.getB());
		tmp2.setZ(num1.getZ() + "-" + num2.getZ());
		tmp2.setA(num1.getA() - num2.getA());
		tmp2.setB(num1.getB() - num2.getB());
		return new ComplexNumber[]{tmp,tmp2};
	}

	public static ComplexNumber compositionTwoNumber(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber tmp = new ComplexNumber(0);
		tmp.setZ(num1.getZ() + "*" + num2.getZ());
		tmp.setA(num1.getA() * num2.getA() + num1.getB() * num2.getB() * (-1D));
		tmp.setB(num1.getA() * num2.getB() + num2.getA() * num1.getB());
		return tmp;
	}

	public static ComplexNumber divisionTwoNumber(ComplexNumber num1, ComplexNumber num2) {
		ComplexNumber res = new ComplexNumber(0);
		ComplexNumber factor = new ComplexNumber(0);
		ComplexNumber numerator = new ComplexNumber(0);
		ComplexNumber denominator = new ComplexNumber(0);
		try {
			numerator = num1.clone();
			denominator = num2.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		if (num2.getA() < 0) {
			numerator = compositionMinusOne(num1);
			denominator = compositionMinusOne(num2);
		}
		factor.setA(denominator.getA());
		factor.setB(denominator.getB() * (-1));
		numerator = compositionTwoNumber(numerator, factor);
		Double resultDenominator = new Double(
				denominator.getA() * denominator.getA() + denominator.getB() * denominator.getB());
		res.setA(numerator.getA() / resultDenominator);
		res.setA(numerator.getB() / resultDenominator);
		res.setZ("Z" + num1.getZ() + "/" + num2.getZ());
		return res;
	}

	private static ComplexNumber compositionMinusOne(ComplexNumber num) {
		ComplexNumber tmp = new ComplexNumber(0);
		tmp.setA(num.getA() * (-1));
		tmp.setB(num.getB() * (-1));
		return tmp;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ComplexNumber clone() throws CloneNotSupportedException {
		return new ComplexNumber(z, a, b);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ComplexNumber) {
			if (((ComplexNumber) obj).getZ().equals(z) && ((ComplexNumber) obj).getA().equals(a)
					&& ((ComplexNumber) obj).getB().equals(b)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		z = null;
		a = null;
		b = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 173;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "ComplexNumber [z=" + z + ", a=" + a + ", b=" + b + "]";
	}

	/** Getter */
	public String getZ() {
		return z;
	}

	/** Getter */
	public Double getA() {
		return a;
	}

	/** Getter */
	public Double getB() {
		return b;
	}

	/** Setter */
	public void setZ(String z) {
		this.z = new String(z);
	}

	/** Setter */
	public void setA(Double a) {
		this.a = new Double(a);
	}

	/** Setter */
	public void setB(Double b) {
		this.b = new Double(b);
	}

}
