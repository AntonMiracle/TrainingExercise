/**
 * Project: Tasks Bus.java
 */
package com.bam.task.task3.bus;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Bus {
	private String	driver, mark;
	private Integer	number, rout, born, mileage;

	final private String	NAMES[]	= new String[]{"Arnold D.F.","Bred P.G.","Holond P.R."};
	final private String	MARKS[]	= new String[]{"MAN","Volvo","Mercedes","Mitsubishi"};
	Random					rnd		= new Random();

	public Bus(int number) {
		this.number = new Integer(number);
		driver = new String(NAMES[rnd.nextInt(NAMES.length)]);
		mark = new String(MARKS[rnd.nextInt(MARKS.length)]);
		born = new Integer(rnd.nextInt(50) + 1950);
		mileage = randomNumber(4);
		rout = randomNumber(1);
	}

	public Bus(Integer number, Integer rout, Integer born, Integer mileage, String driver, String mark) {
		this.number = new Integer(number);
		this.rout = new Integer(rout);
		this.born = new Integer(born);
		this.mileage = new Integer(mileage);
		this.driver = new String(driver);
		this.mark = new String(mark);
	}

	private Integer randomNumber(int numberOfDigit) {
		String number = "";
		for (int i = 0; i < numberOfDigit; i++) {
			number += new Integer(rnd.nextInt(10)).toString();
		}
		return Integer.valueOf(number);
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Bus clone() throws CloneNotSupportedException {
		return new Bus(number, rout, born, mileage, driver, mark);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bus) {
			Bus b = (Bus) obj;
			if (b.getBorn().equals(born) && b.getDriver().equals(driver) && b.getMark().equals(mark)
					&& b.getMileage().equals(mileage) && b.getNumber().equals(number) && b.getRout().equals(rout)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		driver = null;
		mark = null;
		number = null;
		rout = null;
		born = null;
		mileage = null;
		rnd = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 317;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Bus [driver=" + driver + ", mark=" + mark + ", number=" + number + ", rout=" + rout + ", born=" + born
				+ ", mileage=" + mileage + "]";
	}

	/** Getter */
	public String getDriver() {
		return driver;
	}

	/** Getter */
	public String getMark() {
		return mark;
	}

	/** Getter */
	public Integer getNumber() {
		return number;
	}

	/** Getter */
	public Integer getRout() {
		return rout;
	}

	/** Getter */
	public Integer getBorn() {
		return born;
	}

	/** Getter */
	public Integer getMileage() {
		return mileage;
	}

}
