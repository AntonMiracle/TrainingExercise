/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.interval;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showInterval(Interval i) {
		String begin = i.isBeginInclude() ? "[" : "(";
		String end = i.isEndInclude() ? "]" : ")";
		String show = line(34);
		show += String.format("\n|%-10s |", String.format(" %s : %d", " ID", i.getId()));
		show += String.format("%-20s|", String.format(" %s %d : %d %s", begin, i.getBegin(), i.getEnd(), end));
		show += line(34);
		return show;
	}

	public static String showInterval(Interval in[]) {
		String show = "";
		for (int i = 0; i < in.length; i++) {
			show += showInterval(in[i]);
		}
		return show;
	}

	private static String line(int bount) {
		String show = "\n";
		for (int i = 0; i < bount; i++) {
			show += "-";
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
		return 5;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show interval";
	}

}
