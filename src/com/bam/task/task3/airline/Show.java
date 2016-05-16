/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.airline;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {
	public static String air(AirLine air) {
		int maxDigit = 43;
		String show = line(maxDigit);
		show += line("Flight number", air.getNumber().toString());
		show += line("Aircraft type", air.getType());
		show += line("Destination", air.getDestination());
		show += line("Day of week", air.getDay());
		show += line("Departure", air.getDeparture().toString());
		show += line(maxDigit);
		return show;
	}

	public static String air(AirLine air[]) {
		String show = "";
		for (int i = 0; i < air.length; i++) {
			show += air(air[i]);
		}
		return show;
	}

	private static String line(String title, String value) {
		String line = String.format("|%-20s|%-20s|%n", title, value);
		return line;
	}

	private static String line(int valueOfDigits) {
		String line = "";
		for (int i = 0; i < valueOfDigits; i++) {
			line += "-";
		}
		return String.format("%s%n", line);
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
		return "Show Airline";
	}

}
