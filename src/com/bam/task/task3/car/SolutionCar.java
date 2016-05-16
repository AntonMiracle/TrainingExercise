/**
 * Project: Tasks SolutionCar.java
 */
package com.bam.task.task3.car;

import java.util.Random;

import com.bam.task.task3.generalclasses.Price;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class SolutionCar {
	private Car		car[];
	private String	source;
	private String	solA;
	private String	solB;
	private String	solC;
	Random			rnd	= new Random();

	public SolutionCar() {
		car = new Car[rnd.nextInt(10) + 10];
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car(i + 1);
		}
		source = "Cars source:\n" + ShowCar.showCars(car);
		solA = solA(car);
		solB = solB(car);
		solC = solC(car);
	}

	private String solA(Car car[]) {
		Mark mark = new Mark();
		String sort = "\nSolution A:\nAll cars which mark is :" + mark.getMark();
		try {
			sort +=ShowCar.showCars(SortCar.byValueOfMark(car, mark));
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		return sort;
	}

	private String solB(Car car[]) {
		Mark mark = new Mark();
		Integer valueOfWorking = new Integer(rnd.nextInt(50) + 20);
		String sort = "\nSolution B:\nAll cars which mark is :" + mark.getMark() + " and working upper then "
				+ valueOfWorking.toString() + " years";
		try {
			sort += ShowCar.showCars(SortCar.byValueOfMarkAndWorkingUpperYear(car, mark, valueOfWorking));
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		return sort;
	}

	private String solC(Car car[]) {
		Year year = new Year();
		Price price = new Price();;
		String sort = "\nSolution C:\nAll cars which year of issue is :" + year.getYear().toString()
				+ " and price upper then " + price.getPrice().toString();
		try {
			sort += ShowCar.showCars(SortCar.byYearAndUpperValuePrice(car, year, price));
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		return sort;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionCar clone() throws CloneNotSupportedException {
		return new SolutionCar();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SolutionCar) {
			SolutionCar newS = (SolutionCar) obj;
			if (newS.getSolA().equals(solA) && newS.getSolB().equals(solB) && newS.getSolC().equals(solC)
					&& newS.getSource().equals(source)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		solA = null;
		solB = null;
		solC = null;
		source = null;
		rnd = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 347;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + solA + solB + solC;
	}

	/** Getter */
	public String getSource() {
		return source;
	}

	/** Getter */
	public String getSolA() {
		return solA;
	}

	/** Getter */
	public String getSolB() {
		return solB;
	}

	/** Getter */
	public String getSolC() {
		return solC;
	}

}
