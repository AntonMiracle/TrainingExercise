/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.bus;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showBus(Bus bus) {
		int maxDigit = 43;
		String show = line(maxDigit);
		show += line("Driver", bus.getDriver());
		show += line("Bus number", bus.getNumber().toString());
		show += line("Number of rout", bus.getRout().toString());
		show += line("Mark", bus.getMark());
		show += line("Start running", bus.getBorn().toString());
		show += line("Mileage", bus.getMileage().toString());
		show += line(maxDigit);
		return show;
	}

	public static String showBus(Bus bus[]) {
		String show = "";
		for (int i = 0; i < bus.length; i++) {
			show += showBus(bus[i]);
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
		return "Show bus";
	}

}
