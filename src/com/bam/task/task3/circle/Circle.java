/**
 * Project: Tasks Circle.java
 */
package com.bam.task.task3.circle;

import static java.lang.Math.*;

import com.bam.task.task3.point.Point2D;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Circle {
	private Point2D	c, r;
	private int		id;
	private double	radius, perimetr, area;

	public Circle(int id) {
		this.id = id;
		do {
			c = new Point2D();
			r = new Point2D();
			getRadius();
		} while (radius == 0);
		getArea();
		getPerimetr();
	}

	public Circle(int id, Point2D c, Point2D r) {
		this.id = id;
		try {
			this.c = c.clone();
			this.r = r.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		getRadius();
		getArea();
		getPerimetr();
	}

	public double getRadius() {
		radius = edge(c, r);
		return radius;
	}

	public double edge(Point2D p1, Point2D p2) {
		return sqrt(
				(p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}

	public double getPerimetr() {
		perimetr = 2 * PI * radius;
		return perimetr;
	}

	public double getArea() {
		area = PI * radius * radius;
		return area;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Circle clone() throws CloneNotSupportedException {
		return new Circle(id, c, r);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle && ((Circle) obj).getC().equals(c) && ((Circle) obj).getR().equals(r)
				&& ((Circle) obj).getId() == id) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		c = null;
		r = null;
		super.finalize();
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Circle [c=" + c + ", r=" + r + ", id=" + id + ", \nradius=" + radius + ", perimetr=" + perimetr
				+ ", area=" + area + "]";
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 401;
	}

	/** Getter */
	public Point2D getC() {
		return c;
	}

	/** Getter */
	public Point2D getR() {
		return r;
	}

	/** Getter */
	public int getId() {
		return id;
	}

}
