/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.train;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showTrain(Train tra) {
		String show = "\n-------------------" + "\n| Train number    | " + tra.getNumber().toString()
				+ "\n| Destination     | " + tra.getDestination() + "\n| Departure       | "
				+ tra.getDeparture().toString() + "\n| Number of seats |" + "\n| General         | "
				+ tra.getNumberGeneral().toString() + "\n| Cupe            | " + tra.getNumberCupe().toString()
				+ "\n| Plackart        | " + tra.getNumberPlackart().toString() + "\n| Lux             | "
				+ tra.getNumberLux().toString() + "\n-------------------";
		return show;
	}

	public static String showTrain(Train tra[]) {
		String show = "";
		for (int i = 0; i < tra.length; show += showTrain(tra[i++]));
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
		return "Show train";
	}

}
