/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.quadraticequation;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showFunction(QuadraticEquation q[]) {
		String show = "";
		for (int i = 0; i < q.length; i++) {
			show += showFunction(q[i]);
		}
		return show;
	}

	public static String showFunction(QuadraticEquation q) {
		String show = "\n" + line(94);
		show += String.format("\n|%-40s| %-50s|", q.toString(), "Function");
		show += String.format("\n|%-40s| %-50s|", String.format("[%.2f:%.2f]", q.getX0(), q.getY0()),
				"Function vertex");
		show += String.format("\n|%-40s| %-50s|",
				"Extremum [" + String.format("%.2f", q.getX0()) + ":" + String.format("%.2f", q.getY0()) + "]",
				"Function has " + (q.getA() > 0 ? "minimum" : "maximum"));
		show += String.format("\n|%-40s| %-50s|", String.format("D=%.3f", q.getD()), "Discriminant");
		show += String.format("\n|%-40s| %-50s|", String.format("x1=%.4f , x2=%.4f", q.getX1(), q.getX2()),
				"Roots, if discrimenant >= 0");
		show += String.format("\n|%-92s|", q.getIntervalInDe());
		show += "\n" + line(94);
		return show;
	}

	private static String line(int value) {
		String line = "";
		for (int i = 0; i < value; i++) {
			line += "-";
		}
		return line;
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
		return "Show quadratic equation";
	}

}
