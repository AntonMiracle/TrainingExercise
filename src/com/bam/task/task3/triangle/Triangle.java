/**
 * Project: Tasks Triangle.java
 */
package com.bam.task.task3.triangle;

import static java.lang.Math.*;
import com.bam.task.task3.point.Point2D;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Triangle {
	private Point2D	a, b, c;
	private double	ab, bc, ca, angleABC, angleBCA, angleCAB, perimetr, area;
	private boolean	rectangular, arbitrary, equilateral, isosceles;
	private int		id;

	public Triangle(int id) {
		this.id = id;
		do {
			a = new Point2D(10);
			b = new Point2D(10);
			c = new Point2D(10);
			// a = new Point2D(5.0, 0.0);
			// b = new Point2D(0.0, 5.0);
			// c = new Point2D(0.0, 0.0);
			angle();
		} while (!(isExist(a, b, c)));
		isEquilateral();
		isIsosceles();
		isRectangular();
		isArbitrary();
		getPerimetr();
		getArea();
	}

	public Triangle(int id, Point2D a, Point2D b, Point2D c) {
		this.id = id;
		try {
			this.a = a.clone();
			this.b = b.clone();
			this.c = c.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		isExist(this.a, this.b, this.c);
		angle();
		isEquilateral();
		isIsosceles();
		isRectangular();
		isArbitrary();
		getPerimetr();
		getArea();
	}

	public double getArea() {
		double p = getPerimetr() / 2;
		area = sqrt(p * (p - ab) * (p - bc) * (p - ca));
		return area;
	}

	public double getPerimetr() {
		perimetr = ab + bc + ca;
		return perimetr;
	}

	public boolean isExist(Point2D a, Point2D b, Point2D c) {
		ab = edge(a, b);
		bc = edge(b, c);
		ca = edge(c, a);
		if ((ab + bc) > ca && (ca + ab) > bc && (bc + ca) > ab) {
			// return (angleABC + angleBCA + angleCAB) == 180 ? true : false;
			return true;
		} else {
			return false;
		}
	}

	public boolean isArbitrary() {
		arbitrary = equilateral || isosceles || rectangular ? false : true;
		return arbitrary;
	}

	public boolean isRectangular() {
		rectangular = angleABC == 90 || angleBCA == 90 || angleCAB == 90 ? true : false;
		return rectangular;
	}

	/**
	 * Not work correct, need to refactoring
	 */
	public void angle() {
		Point2D vAB = new Point2D();
		Point2D vBC = new Point2D();
		Point2D vCA = new Point2D();
		vAB.setX(b.getX() - a.getX());
		vAB.setY(b.getY() - a.getY());
		vBC.setX(c.getX() - b.getX());
		vBC.setY(c.getY() - b.getY());
		vCA.setX(a.getX() - c.getX());
		vCA.setY(a.getY() - c.getY());
		double cosABC = (vAB.getX() * vBC.getX()
				+ vAB.getY() * vBC.getY() / (sqrt(vAB.getX() * vAB.getX() + vAB.getY() * vAB.getY())
						* sqrt(vBC.getX() * vBC.getX() + vBC.getY() * vBC.getY())));

		double cosBCA = (vBC.getX() * vCA.getX()
				+ vBC.getY() * vCA.getY() / (sqrt(vBC.getX() * vBC.getX() + vBC.getY() * vBC.getY())
						* sqrt(vCA.getX() * vCA.getX() + vCA.getY() * vCA.getY())));

		double cosCAB = (vCA.getX() * vAB.getX()
				+ vCA.getY() * vAB.getY() / (sqrt(vCA.getX() * vCA.getX() + vCA.getY() * vCA.getY())
						* sqrt(vAB.getX() * vAB.getX() + vAB.getY() * vAB.getY())));
		double sinABC = sqrt(1 - cosABC);
		double sinBCA = sqrt(1 - cosBCA);
		double sinCAB = sqrt(1 - cosCAB);
		double tgABC = sinABC / cosABC;
		double tgBCA = sinBCA / cosBCA;
		double tgCAB = sinCAB / cosCAB;
		angleABC = toDegrees(atan(tgABC));
		angleBCA = toDegrees(atan(tgBCA));
		angleCAB = toDegrees(atan(tgCAB));
	}

	public boolean isIsosceles() {
		double ab = edge(a, b);
		double bc = edge(b, c);
		double ca = edge(c, a);
		isosceles = ab == bc || bc == ca || ca == ab ? true : false;
		return isosceles;
	}

	public boolean isEquilateral() {
		double ab = edge(a, b);
		double bc = edge(b, c);
		double ca = edge(c, a);
		equilateral = ab == bc && bc == ca ? true : false;
		return equilateral;
	}

	public double edge(Point2D p1, Point2D p2) {
		return sqrt(
				(p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", ab=" + ab + ", bc=" + bc + ", ca=" + ca + ", "
				+ "\nangleABC=" + angleABC + ", angleBCA=" + angleBCA + ", angleCAB=" + angleCAB + ", " + "\nperimetr="
				+ perimetr + ", area=" + area + ", " + "\nrectangular=" + rectangular + ", arbitrary=" + arbitrary
				+ ", equilateral=" + equilateral + ", isosceles=" + isosceles + "]";
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Triangle clone() throws CloneNotSupportedException {
		return new Triangle(id, a, b, c);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Triangle && ((Triangle) obj).getA().equals(a) && ((Triangle) obj).getB().equals(b)
				&& ((Triangle) obj).getC().equals(c) && ((Triangle) obj).getId() == id) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		a = null;
		b = null;
		c = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 99;
	}

	/** Getter */
	public Point2D getA() {
		return a;
	}

	/** Getter */
	public Point2D getB() {
		return b;
	}

	/** Getter */
	public Point2D getC() {
		return c;
	}

	/** Getter */
	public double getAb() {
		return ab;
	}

	/** Getter */
	public double getBc() {
		return bc;
	}

	/** Getter */
	public double getCa() {
		return ca;
	}

	/** Getter */
	public double getAngleABC() {
		return angleABC;
	}

	/** Getter */
	public double getAngleBCA() {
		return angleBCA;
	}

	/** Getter */
	public double getAngleCAB() {
		return angleCAB;
	}

	/** Getter */
	public int getId() {
		return id;
	}

}
