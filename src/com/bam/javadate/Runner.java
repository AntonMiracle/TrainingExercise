package com.bam.javadate;
import java.time.LocalDate;
import java.time.Period;

/** 
 * Project: WorkWithJavaDate
 * Runner.java  
 */

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate b = LocalDate.of(1951, 5, 26);
		LocalDate d = LocalDate.of(2012, 7, 23);
		
		Period p = Period.between(b,d);
		int daysInYearsWhere366 = 14 * 366;
		int daysInYearsWhere365 = (p.getYears() - 14) * 365;
		int days = daysInYearsWhere365 + daysInYearsWhere366 + 58;	
		
		System.out.println();		
		System.out.println(	p.toTotalMonths());		
		System.out.println(p.getDays());
		System.out.println(days);
		
	}

}
