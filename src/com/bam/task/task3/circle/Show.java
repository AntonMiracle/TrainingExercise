/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.circle;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String show(Circle c[]) {
		String show = "";
		for (Circle data : c) {
			show += show(data);
		}
		return show;
	}

	public static String show(Circle c) {
		String show = "";
		if (c.getId() > 0) {
			show += line(75);
			show += line("Circle ID", new Integer(c.getId()).toString());
			show += line("Centre", c.getC().toString());
			show += line("Point on circle", c.getR().toString());
			show += line("Radius", number(c.getRadius()));
			show += line("Area", number(c.getArea()));
			show += line("Perimetr", number(c.getPerimetr()));
			show += line(75);
			return show;
		} else {
			show += line(75);
			show += line("Circle", "not exist");
			show += line(75);
			return show;
		}
	}

	public static String line(String s1, String s2) {
		return String.format("\n| %-30s| %-40s|", s1, s2);
	}

	public static String number(double d) {
		return String.format("%.2f", d);
	}

	public static String line(int bound) {
		String line = "\n";
		for (int i = 0; i < bound; i++) {
			line += "-";
		}
		return line;
	}

}
