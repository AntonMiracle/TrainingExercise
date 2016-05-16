/**
 * Project: Tasks Quadrangle.java
 */
package com.bam.task.task3.quadrangle;

import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import static java.lang.Math.toDegrees;

import com.bam.task.task3.point.Point2D;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Quadrangle {
	private Point2D		a, b, c, d;
	private int			id;
	private double		ab, bc, cd, da, perimetr, area, angleABC, angleBCD, angleCDA, angleDAB;
	private String		type;
	public final String	TYPES[]	= new String[]{"Arbitrary","Rectangle","Square","Rhombus"};

	public Quadrangle(int id) {
		this.id = id;
		do {
			a = new Point2D();
			b = new Point2D();
			c = new Point2D();
			d = new Point2D();
			angle();
		} while (!(isExist()));
		getType();
		getPerimetr();
		getArea();
	}

	public Quadrangle(int id, Point2D a, Point2D b, Point2D c, Point2D d) {
		this.id = id;
		try {
			this.a = a.clone();
			this.b = b.clone();
			this.c = c.clone();
			this.d = d.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		angle();
		getType();
		getPerimetr();
		getArea();
	}

	public void angle() {
		Point2D vAB = new Point2D();
		Point2D vBC = new Point2D();
		Point2D vCD = new Point2D();
		Point2D vDA = new Point2D();
		vAB.setX(b.getX() - a.getX());
		vAB.setY(b.getY() - a.getY());
		vBC.setX(c.getX() - b.getX());
		vBC.setY(c.getY() - b.getY());
		vCD.setX(d.getX() - c.getX());
		vCD.setY(d.getY() - c.getY());
		vDA.setY(a.getY() - d.getX());
		vDA.setX(a.getY() - d.getY());
		double cosABC = (vAB.getX() * vBC.getX()
				+ vAB.getY() * vBC.getY() / (sqrt(vAB.getX() * vAB.getX() + vAB.getY() * vAB.getY())
						* sqrt(vBC.getX() * vBC.getX() + vBC.getY() * vBC.getY())));

		double cosBCD = (vBC.getX() * vCD.getX()
				+ vBC.getY() * vCD.getY() / (sqrt(vBC.getX() * vBC.getX() + vBC.getY() * vBC.getY())
						* sqrt(vCD.getX() * vCD.getX() + vCD.getY() * vCD.getY())));

		double cosCDA = (vCD.getX() * vDA.getX()
				+ vCD.getY() * vDA.getY() / (sqrt(vCD.getX() * vCD.getX() + vCD.getY() * vCD.getY())
						* sqrt(vDA.getX() * vDA.getX() + vDA.getY() * vDA.getY())));
		double cosDAB = (vDA.getX() * vAB.getX()
				+ vDA.getY() * vAB.getY() / (sqrt(vDA.getX() * vDA.getX() + vDA.getY() * vDA.getY())
						* sqrt(vAB.getX() * vAB.getX() + vAB.getY() * vAB.getY())));

		double sinABC = sqrt(1 - cosABC);
		double sinBCD = sqrt(1 - cosBCD);
		double sinCDA = sqrt(1 - cosCDA);
		double sinDAB = sqrt(1 - cosDAB);
		double tgABC = sinABC / cosABC;
		double tgBCD = sinBCD / cosBCD;
		double tgCDA = sinCDA / cosCDA;
		double tgDAB = sinDAB / cosDAB;
		angleABC = toDegrees(atan(tgABC));
		angleBCD = toDegrees(atan(tgBCD));
		angleCDA = toDegrees(atan(tgCDA));
		angleDAB = toDegrees(atan(tgDAB));
	}

	public double getArea() {
		double p = getPerimetr() / 2;
		area = sqrt(p * (p - ab) * (p - bc) * (p - cd) * (p - da));
		return area;
	}

	public double getPerimetr() {
		perimetr = ab + bc + cd + da;
		return perimetr;
	}

	public String getType() {
		double ac = edge(a, c);
		double db = edge(a, c);
		if (db == ac) {
			if (angleABC == 90 && angleBCD == 90 && angleCDA == 90 && angleDAB == 90) {
				type = ab == bc && bc == cd && cd == da ? TYPES[2] : "";
			}
			type = ab == cd && bc == da ? TYPES[1] : "";
		}
		if (angleABC != 90 && angleBCD != 90 && angleCDA != 90 && angleDAB != 90) {
			type = ab == bc && bc == cd && cd == da ? TYPES[3] : "";
		}
		type = TYPES[0];
		return type;
	}

	public boolean isExist() {
		ab = edge(a, b);
		bc = edge(b, c);
		cd = edge(c, d);
		da = edge(d, a);
		double ac = edge(a, c);
		double db = edge(a, c);
		if (ac == (ab + bc) || ac == (da + cd) || db == (ab + da) || db == (bc + cd)) {
			return false;
		} else {
			return true;
		}
	}

	public double edge(Point2D p1, Point2D p2) {
		return sqrt(
				(p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Quadrangle clone() throws CloneNotSupportedException {
		return new Quadrangle(id, a, b, c, d);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quadrangle && ((Quadrangle) obj).getId() == id && ((Quadrangle) obj).getA().equals(a)
				&& ((Quadrangle) obj).getB().equals(b) && ((Quadrangle) obj).getC().equals(c)
				&& ((Quadrangle) obj).getD().equals(d)) {
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
		d = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 619;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Quadrangle [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", id=" + id + ", " + "\nab=" + ab
				+ ", bc=" + bc + ", cd=" + cd + ", da=" + da + ", " + "\nperimetr=" + perimetr + ", area=" + area + ", "
				+ "\nangleABC=" + angleABC + ", angleBCD=" + angleBCD + ", angleCDA=" + angleCDA + ", angleDAB="
				+ angleDAB + ", type=" + type + "]";
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
	public Point2D getD() {
		return d;
	}

	/** Getter */
	public int getId() {
		return id;
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
	public double getCd() {
		return cd;
	}

	/** Getter */
	public double getDa() {
		return da;
	}

	/** Getter */
	public double getAngleABC() {
		return angleABC;
	}

	/** Getter */
	public double getAngleBCD() {
		return angleBCD;
	}

	/** Getter */
	public double getAngleCDA() {
		return angleCDA;
	}

	/** Getter */
	public double getAngleDAB() {
		return angleDAB;
	}

	/** Getter */
	public String[] getTYPES() {
		return TYPES;
	}

}
