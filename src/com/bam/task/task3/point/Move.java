/**
 * Project: Tasks Move.java
 */
package com.bam.task.task3.point;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Move {
	private double	distance, speed, time, acceleration, endX, endY, deltaX, deltaY;
	private Point2D	point;

	public Move(Point2D p, double destinationX, double destinationY) {
		Random rnd = new Random();
		endX = destinationX;
		endY = destinationY;
		try {
			this.point = p.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		time = (double) (rnd.nextInt(80) + 20);
		deltaX = point.getX() > endX ? point.getX() - endX : endX - point.getX();
		deltaY = point.getY() > endY ? point.getY() - endY : endY - point.getY();
		distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		speed = distance / time;
		acceleration = speed / time;
	}

	public Move(Point2D point, double distance, double speed, double time, double acceleration, double endX,
			double endY, double deltaX, double deltaY) {
		try {
			this.point = point.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		this.distance = distance;
		this.speed = speed;
		this.time = time;
		this.acceleration = acceleration;
		this.endX = endX;
		this.endY = endY;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	public Point2D findPointOnTrayectory(double time) {
		if (time > 0 && time <= this.time) {
			Point2D newP = new Point2D();
			double distance = (acceleration * time * time) / 2;
			double deltaX = (this.deltaX / (this.distance / distance));
			double deltaY = (this.deltaY / (this.distance / distance));
			newP.setX(point.getX() > endX ? point.getX() - deltaX : point.getX() + deltaX);
			newP.setY(point.getY() > endY ? point.getY() - deltaY : point.getY() + deltaY);
			return newP;
		} else {
			return null;
		}

	}

	public double distanceBetweenTwoPoint2D(Point2D p1, Point2D p2) {
		double deltaX = p1.getX() > p2.getX() ? p1.getX() - p2.getX() : p2.getX() - p1.getX();
		double deltaY = p1.getY() > p2.getY() ? p1.getY() - p2.getY() : p2.getY() - p1.getY();
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}
	
	public static boolean isLineSegmentIntersection(Point2D p1, Point2D p1e, Point2D p2, Point2D p2e){
		double v1=(p2e.getX()-p2.getX())*(p1.getY()-p2.getY())-(p2e.getY()-p2.getY())*(p1.getX()-p2.getX());
	    double v2=(p2e.getX()-p2.getX())*(p1e.getY()-p2.getY())-(p2e.getY()-p2.getY())*(p1e.getX()-p2.getX());
	    double v3=(p1e.getX()-p1.getX())*(p2.getY()-p1.getY())-(p1e.getY()-p1.getY())*(p2.getX()-p1.getX());
	    double v4=(p1e.getX()-p1.getX())*(p2e.getY()-p1.getY())-(p1e.getY()-p1.getY())*(p2e.getX()-p1.getX());
	    return ((v1*v2<=0) && (v3*v4<=0));
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Move clone() throws CloneNotSupportedException {
		return new Move(point, distance, speed, time, acceleration, endX, endY, deltaX, deltaY);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Move && ((Move) obj).getPoint().equals(point) && ((Move) obj).getEndX() == endX
				&& ((Move) obj).getEndY() == endY && ((Move) obj).getTime() == time) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		point = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 463;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Move [distance=" + String.format("%.2f", distance) + ", speed=" + String.format("%.2f", speed) 
		+ ", time=" + time + ", acceleration=" + String.format("%.6f", acceleration) 
				+ "]";
	}

	/** Getter */
	public double getDistance() {
		return distance;
	}

	/** Getter */
	public double getSpeed() {
		return speed;
	}

	/** Getter */
	public double getTime() {
		return time;
	}

	/** Getter */
	public double getAcceleration() {
		return acceleration;
	}

	/** Getter */
	public double getEndX() {
		return endX;
	}

	/** Getter */
	public double getEndY() {
		return endY;
	}

	/** Getter */
	public Point2D getPoint() {
		return point;
	}

}
