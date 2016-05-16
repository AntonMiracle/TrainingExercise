/**
 * Project: Tasks SortCar.java
 */
package com.bam.task.task3.car;

import com.bam.task.task3.generalclasses.Price;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class SortCar {

	public static Car[] byValueOfMark(Car car[], Mark value) throws CloneNotSupportedException {
		int count = 0;
		for (int i = 0; i < car.length; i++) {
			count += car[i].getMark().equals(value) ? 1 : 0;
		}
		Car newC[] = new Car[count];
		count = 0;
		for (int i = 0; i < car.length; i++) {
			if (car[i].getMark().equals(value)) {
				newC[count++] = car[i].clone();
			}
		}
		return newC;
	}

	public static Car[] byValueOfMarkAndWorkingUpperYear(Car car[], Mark value, Integer valueOfworkingYear)
			throws CloneNotSupportedException {
		Car newC[] = byValueOfMark(car, value);
		int count = 0;
		for (int i = 0; i < newC.length; i++) {
			count += (new Integer(2016) - newC[i].getYear().getYear()) > valueOfworkingYear ? 1 : 0;
		}
		Car newCar[] = new Car[count];
		count = 0;
		for (int i = 0; i < newC.length; i++) {
			if ((new Integer(2016) - newC[i].getYear().getYear()) > valueOfworkingYear) {
				newCar[count++] = newC[i].clone();
			}
		}
		return newCar;
	}

	public static Car[] byYearAndUpperValuePrice(Car car[], Year year, Price valueofPrice)
			throws CloneNotSupportedException {
		int count = 0;
		for (int i = 0; i < car.length; i++) {
			count += car[i].getYear().equals(year) && car[i].getPrice().getPrice() > valueofPrice.getPrice() ? 1 : 0;
		}
		Car newC[] = new Car[count];
		count = 0;
		for (int i = 0; i < car.length; i++) {
			if (car[i].getYear().equals(year) && car[i].getPrice().getPrice() > valueofPrice.getPrice()) {
				newC[count++] = car[i].clone();
			}
		}
		return newC;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortCar clone() throws CloneNotSupportedException {
		return new SortCar();
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
		return "Sort car";
	}

}
