/**
 * Project: Tasks Straight.java
 */
package com.bam.task.task3.straight;

import com.bam.task.task3.point.Point2D;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Straight {
	private double	a, b, c;
	private int		id;

	public Straight(int id) {
		this.id = id;
		Point2D a = new Point2D();
		Point2D b = new Point2D();
		this.a = a.getY() - b.getY();
		this.b = b.getX() - a.getX();
		this.c = a.getX() * b.getY() - b.getX() * a.getY();
	}

	public Straight(int id, double a, double b, double c) {
		this.id = id;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Straight(int id, Point2D a, Point2D b) {
		this.id = id;
		this.a = a.getY() - b.getY();
		this.b = b.getX() - a.getX();
		this.c = a.getX() * b.getY() - b.getX() * a.getY();
	}

	public Straight(Point2D a, Point2D b) {
		id = 1;
		this.a = a.getY() - b.getY();
		this.b = b.getX() - a.getX();
		this.c = a.getX() * b.getY() - b.getX() * a.getY();
	}

	public boolean isPointOnStraight(Point2D p) {
		double res = a * p.getX() + b * p.getY() + c;
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTwoStraightParallel(Straight s1, Straight s2) {
		double p = s1.getA() * s2.getB() - s2.getA() * s2.getB();
		return p == 0 ? true : false;
	}

	public Point2D intersectionOfTwoStraight(Straight s1, Straight s2) {
		double y = (s2.getA() * s1.getC() - s2.getC()) / (s1.getA() * s2.getB() - s2.getA() * s1.getB());
		double x = (-1) * ((s1.getC() + s1.getB() * y) / s1.getA());
		Point2D newP = new Point2D();
		newP.setX(x);
		newP.setY(y);
		return newP;
	}

	public Point2D intersectionOY() {
		Point2D newP = new Point2D();
		double x = 0;
		newP.setX(x);
		double y = (-1) * (c / b);
		newP.setY(y);
		return newP;
	}

	public Point2D intersectionOX() {
		Point2D newP = new Point2D();
		double y = 0;
		newP.setY(y);
		double x = (-1) * (c / a);
		newP.setX(x);
		return newP;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Straight clone() throws CloneNotSupportedException {
		return new Straight(id, a, b, c);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Straight && ((Straight) obj).getA() == a && ((Straight) obj).getB() == b
				&& ((Straight) obj).getC() == c && ((Straight) obj).getId() == id) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 617;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String b = this.b >= 0 ? String.format("+%.2f", this.b) : String.format("%.2f", this.b);
		String c = this.c >= 0 ? String.format("+%.2f", this.c) : String.format("%.2f", this.c);
		return String.format("%.2fx" + b + "y" + c + "=0", a);
	}

	/** Getter */
	public double getA() {
		return a;
	}

	/** Getter */
	public double getB() {
		return b;
	}

	/** Getter */
	public double getC() {
		return c;
	}

	/** Getter */
	public int getId() {
		return id;
	}

}
