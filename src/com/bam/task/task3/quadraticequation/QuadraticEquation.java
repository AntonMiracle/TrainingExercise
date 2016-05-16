/**
 * Project: Tasks QuadraticEquation.java
 */
package com.bam.task.task3.quadraticequation;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class QuadraticEquation {
	private Double	a, b, c, d, x1, x2, x0, y0;
	private String	extremum, intervalInDe, id;

	public QuadraticEquation(int id) {
		this.id = "Y" + new Integer(id).toString() + "(f)=";
		a = randomA();
		b = randomBC();
		c = randomBC();
		d = countDiscriminant(a, b, c);
		x1 = isRootExist(d) ? countRoots(d, a, b)[0] : null;
		x2 = isRootExist(d) ? countRoots(d, a, b)[1] : null;
		x0 = findX0(a, b);
		y0 = findY0(a, b, c);
		extremum = findExtremums(x0, y0, a);
		intervalInDe = findIntervalInDe(x0, a);
	}

	public QuadraticEquation(String id, Double a, Double b, Double c, Double d, Double x1, Double x2, Double x0,
			Double y0, String extremum, String intervalInDe) {
		this.id = new String(id);
		this.a = new Double(a);
		this.b = new Double(b);
		this.c = new Double(c);
		this.d = new Double(d);
		this.x1 = new Double(x1);
		this.x2 = new Double(x2);
		this.x0 = new Double(x0);
		this.y0 = new Double(y0);
		this.intervalInDe = new String(intervalInDe);
		this.extremum = new String(extremum);
	}

	private String findIntervalInDe(Double x0, Double a) {
		String decrease = String.format(
				"Function increase in interval (-infinity:%.2f), and decrease in interval (%.2f: +infinity)", x0, x0);
		String increase = String.format(
				"Function increase in interval (%.2f:+infinity), and decrease in interval (-infinity:%.2f)", x0, x0);
		return a > 0 ? increase : decrease;

	}

	private String findExtremums(Double x0, Double y0, Double a) {
		String value = a > 0 ? "maximum" : "minimum";
		return String.format("Extremum: at the point with coordinates [%.2f:%.2f] function has %s", x0, y0, value);
	}

	private Double findX0(Double a, Double b) {
		return new Double(((-1) * b) / (2 * a));
	}

	private Double findY0(Double a, Double b, Double c) {
		return new Double((-1) * ((b * b - 4 * a * c) / (4 * a)));
	}

	private Double countDiscriminant(Double a, Double b, Double c) {
		return new Double(b * b - 4 * a * c);
	}

	private boolean isRootExist(Double d) {
		return d < 0 ? false : true;
	}

	private Double[] countRoots(Double d, Double a, Double b) {
		if (d == 0) {
			return new Double[]{new Double(((-1) * b) / (2 * a)),new Double(((-1) * b) / (2 * a))};

		} else {
			return new Double[]{new Double(((-1) * b - Math.sqrt(d)) / (2 * a)),
					new Double(((-1) * b + Math.sqrt(d)) / (2 * a))};
		}
	}

	private Double randomA() {
		Random rnd = new Random();
		Double a = new Double(0);
		while (a == 0) {
			a = new Double(rnd.nextDouble() + rnd.nextInt(200) - 100);
		}
		return a;
	}

	private Double randomBC() {
		Random rnd = new Random();
		return new Double(rnd.nextDouble() + rnd.nextInt(200) - 100);
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String b = "", c = "", a = String.format("%.2fx", this.c);
		if (this.c != 0) {
			c = this.c > 0 ? String.format("+%.2f", this.c) : String.format("%.2f", this.c);
		}
		if (this.b != 0) {
			b = this.b > 0 ? String.format("+%.2fx", this.b) : String.format("%.2fx", this.b);
		}
		return id + a + "2" + b + c;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected QuadraticEquation clone() throws CloneNotSupportedException {
		return new QuadraticEquation(id, a, b, c, d, x1, x2, x0, y0, extremum, intervalInDe);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof QuadraticEquation) {
			QuadraticEquation q = (QuadraticEquation) obj;
			if (q.getId().equals(id) && q.getA().equals(a) && q.getB().equals(b) && q.getC().equals(c)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		a = null;
		b = null;
		c = null;
		d = null;
		x1 = null;
		x1 = null;
		x0 = null;
		y0 = null;
		extremum = null;
		intervalInDe = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 251;
	}

	/** Getter */
	public Double getA() {
		return a;
	}

	/** Getter */
	public Double getB() {
		return b;
	}

	/** Getter */
	public Double getC() {
		return c;
	}

	/** Getter */
	public Double getD() {
		return d;
	}

	/** Getter */
	public Double getX1() {
		return x1;
	}

	/** Getter */
	public Double getX2() {
		return x2;
	}

	/** Getter */
	public Double getX0() {
		return x0;
	}

	/** Getter */
	public Double getY0() {
		return y0;
	}

	/** Getter */
	public String getExtremum() {
		return extremum;
	}

	/** Getter */
	public String getIntervalInDe() {
		return intervalInDe;
	}

	/** Getter */
	public String getId() {
		return id;
	}

}
