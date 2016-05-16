/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.point;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showPoint(Point2D p) {
		return "Point (" + String.format("%.2f", p.getX()) + " : " + String.format("%.2f", p.getY()) + ")";

	}

	public static String showPoint(Point2D p[]) {
		String show = "";
		for (int i = 0; i < p.length; i++) {
			show += showPoint(p[i]);
		}
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Show clone() throws CloneNotSupportedException {
		return new Show();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
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
		return "Show point";
	}

}
