/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.triangle;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showTriangle(Triangle t[]) {
		String show = "";
		for (int i = 0; i < t.length; i++) {
			show += showTriangle(t[i]);
		}
		return show;
	}

	public static String showTriangle(Triangle t) {
		if (t.getId() != 0) {
			String show = line(95)
					+ String.format("\n| %-30s| %-60s|", "Triangle #" + new Integer(t.getId()).toString() + ". Type is",
							triangleType(t))
					+ String.format("\n| %-30s| %-60s|", "Vertex a, b, c", vertexABC(t))
					+ String.format("\n| %-30s| %-60s|", "Edges AB, BC, CA", edges(t))
					+ String.format("\n| %-30s| %-60s|", "Angle (not correct)", angles(t))
					+ String.format("\n| %-30s| %-60s|", "Perimetr", String.format("%.2f", t.getPerimetr()))
					+ String.format("\n| %-30s| %-60s|", "Area", String.format("%.2f", t.getArea())) + line(95);
			return show;
		} else {
			String show = line(95) + String.format("\n| %-30s| %-60s|", "Triangle", "not exist") + line(95);
			return show;
		}
	}

	public static String line(int bount) {
		String show = "\n";
		for (int i = 0; i < bount; i++) {
			show += "-";
		}
		return show;
	}

	public static String angles(Triangle t) {
		return String.format("ABC = %.2f, BCA = %.2f, CAB = %.2f", t.getAngleABC(), t.getAngleBCA(), t.getAngleCAB());
	}

	public static String edges(Triangle t) {
		return String.format("AB = %.2f, BC = %.2f, CA = %.2f,", t.getAb(), t.getBc(), t.getCa());
	}

	public static String vertexABC(Triangle t) {
		return String.format("a %s, b %s, c %s", t.getA().toString(), t.getB().toString(), t.getC().toString());
	}

	public static String triangleType(Triangle t) {
		String type = "";
		if (t.isArbitrary()) {
			type = "arbitratory";
			return type;
		} else {
			type += t.isRectangular() ? "rectangular " : "";
			type += t.isEquilateral() ? "equilateral " : "";
			type += t.isIsosceles() ? "isosceles " : "";
			return type;
		}
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
		return 337;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show triangle";
	}

}
