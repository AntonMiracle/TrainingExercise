/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.point;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String source, sol;

	public Solution() {
		Random rnd = new Random();
		Point2D p1 = new Point2D();
		Point2D p2 = new Point2D();
		Point2D p1e = new Point2D();
		Point2D p2e = new Point2D();
		Point2D sol1 = new Point2D();
		Point2D sol2 = new Point2D();
		Move m1 = new Move(p1, p1e.getX(), p1e.getY());
		Move m2 = new Move(p2, p2e.getX(), p2e.getY());
		double solTime = m1.getTime() > m2.getTime() ? (double) rnd.nextInt((int) m2.getTime() + 1)
				: (double) rnd.nextInt((int) m1.getTime() + 1);
		sol1 = m1.findPointOnTrayectory(solTime);
		sol2 = m2.findPointOnTrayectory(solTime);

		source = "\nList of source:" + "\n#1 " + Show.showPoint(p1) + " move to coordinat " + p1e.toString()
				+ "\nSpeed " + String.format("%.2f", m1.getSpeed()) + "\nAcceleration "
				+ String.format("%.3f", m1.getAcceleration()) + "\nDistance : "
				+ String.format("%.2f", m1.getDistance()) + "\nElapsed time : " + String.format("%.0f", m1.getTime())
				+ "\n\n#2 " + Show.showPoint(p2) + " move to coordinat " + p2e.toString() + "\nSpeed "
				+ String.format("%.2f", m2.getSpeed()) + "\nAcceleration " + String.format("%.3f", m2.getAcceleration())
				+ "\nDistance : " + String.format("%.2f", m2.getDistance()) + "\nElapsed time : "
				+ String.format("%.0f", m2.getTime());
		sol = "\n\nSolution : Calculate distance between points 1 and 2 after move by "
				+ String.format("time = %.0f", solTime) + "\nDistance = "
				+ String.format("%.2f", m1.distanceBetweenTwoPoint2D(sol1, sol2))
				+ "\nAditional solution : is move trajectory of the point #1 and #2" + "\nIntersection : "
				+ new Boolean(Move.isLineSegmentIntersection(p1, p1e, p2, p2e)).toString();

	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution && ((Solution) obj).getSource().equals(source)
				&& ((Solution) obj).getSol().equals(sol)) {
			return true;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		sol = null;
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
		return source + sol;
	}

	/** Getter */
	public String getSource() {
		return source;
	}

	/** Getter */
	public String getSol() {
		return sol;
	}

}
