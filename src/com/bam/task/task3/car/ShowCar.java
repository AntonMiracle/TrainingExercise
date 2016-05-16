/**
 * Project: Tasks ShowCar.java
 */
package com.bam.task.task3.car;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class ShowCar {

	public static String showOneCar(Car car) {
		String show = "\n-----------------------" + "\n| Car ID              | " + car.getId().toString()
				+ "\n| Mark                | " + car.getMark().getMark() + "\n| Model               | "
				+ car.getModel().getModel() + "\n| Year of issue       | " + car.getYear().getYear().toString()
				+ "\n| Colour              | " + car.getColour().getColour() + "\n| Price               | "
				+ car.getPrice().getPrice().toString() + "\n| Registration number | "
				+ car.getRegNum().getRegNum().toString() + "\n-----------------------";
		return show;
	}

	public static String showCars(Car car[]) {
		String show = "";
		for (int i = 0; i < car.length; i++) {
			show += showOneCar(car[i]);
		}
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowCar clone() throws CloneNotSupportedException {
		return new ShowCar();
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
		return 953;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show car";
	}

}
