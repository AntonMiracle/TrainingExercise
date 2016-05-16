/**
 * Project: Tasks BirthDay.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 9.02.2016.
 *
 */
public class BirthDay {
	Random				rnd	= new Random();
	final private int	ID	= 997;
	private String		day;
	private String		month;
	private String		year;

	public BirthDay() {
		year = randomYearOfBirth(1950, 60);
		month = randomMonthOfBirth();
		day = randomDayOfBirth(month);
	}

	public BirthDay(int year) {
		this.year = new Integer(year).toString();
		month = randomMonthOfBirth();
		day = randomDayOfBirth(month);
	}

	private BirthDay(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String randomYearOfBirth(int from, int bount) {
		String newYear = new Integer(from + rnd.nextInt(bount)).toString();
		return newYear;
	}

	public String randomMonthOfBirth() {
		int monthId = rnd.nextInt(12) + 1;
		String month = monthId < 10 ? "0" + new Integer(monthId).toString() : new Integer(monthId).toString();
		return month;
	}

	public String randomDayOfBirth(String numberOfMonth) {
		int monthId = -1;
		if (numberOfMonth.charAt(0) == '0' && numberOfMonth.length() == 2) {
			monthId = Character.getNumericValue(numberOfMonth.charAt(1));
		} else {
			monthId = Integer.parseInt(numberOfMonth);
		}
		String dayOfBirth = new Integer(rnd.nextInt(getBoundDaysOfTheMonth(monthId) + 1)).toString();
		return dayOfBirth;
	}

	private int getBoundDaysOfTheMonth(int month) {
		int bount = 0;
		if (month > 0 && month <= 12) {
			if (month == 2) {
				bount = 28;
			}
			if (month == 4 && month == 6 && month == 9 && month == 11) {
				bount = 30;
			} else {
				bount = 31;
			}
		}
		return bount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected BirthDay clone() throws CloneNotSupportedException {
		BirthDay bd = new BirthDay(day, month, year);
		return bd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof BirthDay) {
			if (((BirthDay) obj).getDay().equals(day) && ((BirthDay) obj).getMonth().equals(month)
					&& ((BirthDay) obj).getYear().equals(year)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = result * ID * 7 * Integer.parseInt(day) * Integer.parseInt(year);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return day + "." + month + "." + year + " y.";
	}

	/**
	 * Getting this.day from BirthDay.java
	 * 
	 * @return this.day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Getting this.month from BirthDay.java
	 * 
	 * @return this.month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Getting this.year from BirthDay.java
	 * 
	 * @return this.year
	 */
	public String getYear() {
		return year;
	}

}
