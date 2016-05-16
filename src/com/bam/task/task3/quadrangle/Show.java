/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.quadrangle;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String show(Quadrangle q[]) {
		String show = "";
		for (int i = 0; i < q.length; i++) {
			show += show(q[i]);
		}
		return show;
	}

	public static String show(Quadrangle q) {
		String show = "";
		if (q.getId() > 0) {
			show += line(74);
			show += line("Quadrangle ID", new Integer(q.getId()).toString());
			show += line("Type : ", q.getType());
			show += line("Vertex", "a " + q.getA().toString() + ", b " + q.getB().toString());
			show += line("Vertex", "c " + q.getC().toString() + ", d " + q.getD().toString());
			show += line("Edges", "AB " + number(q.getAb()) + ", BC " + number(q.getBc()) + ", CD " + number(q.getCd())
					+ ", DA " + number(q.getDa()));
			show += line("Perimetr", number(q.getPerimetr()));
			show += line("Area", number(q.getArea()));
			show += line("Angles (not correct)", "ABC " + number(q.getAngleABC()) + ", BCD " + number(q.getAngleBCD())
					+ ", CDA " + number(q.getAngleCDA()) + ", DAB " + number(q.getAngleDAB()));
			show += line(74);
		} else {
			show += line(74);
			show += line("Quadrangle", "not exist");
			show += line(74);
		}
		return show;
	}

	public static String line(String first, String second) {
		return String.format("\n|%-25s| %-45s|", first, second);
	}

	public static String line(int bound) {
		String line = "\n";
		for (int i = 0; i < bound; i++) {
			line += "-";
		}
		return line;
	}

	public static String number(double d) {
		return String.format("%.2f", d);
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
		return 109;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show quadrangle";
	}

}
