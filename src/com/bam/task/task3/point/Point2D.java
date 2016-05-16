/**
 * Project: Tasks Point2D.java
 */
package com.bam.task.task3.point;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Point2D {
	private double x, y;

	public Point2D() {
		Random rnd = new Random();
		x = (double) (rnd.nextInt(100) + rnd.nextDouble() - 50);
		y = (double) (rnd.nextInt(100) + rnd.nextDouble() - 50);
	}
	
	public Point2D(int bound) {
		Random rnd = new Random();
		x = (double) (rnd.nextInt(bound));
		y = (double) (rnd.nextInt(bound));
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}	

	/* @see java.lang.Object#clone() */
	@Override
	public Point2D clone() throws CloneNotSupportedException {
		return new Point2D(x, y);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point2D && ((Point2D) obj).getX() == x && ((Point2D) obj).getY() == y) {
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
		return 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return String.format("(%.2f : %.2f)", x, y);
	}

	/** Getter */
	public double getX() {
		return x;
	}

	/** Setter */
	public void setX(double x) {
		this.x = x;
	}

	/** Getter */
	public double getY() {
		return y;
	}

	/** Setter */
	public void setY(double y) {
		this.y = y;
	}

}
