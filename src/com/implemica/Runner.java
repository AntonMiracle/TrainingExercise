/**
 * Project: TrainingExercise Runner.java
 */
package com.implemica;

import java.util.Scanner;

import com.implemica.cities.Cities;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Runner {
	public static Scanner scn = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Solutin B. Find cheapest price
		 */
		Cities c = new Cities();
		c.solution();
//		c.testSolution();// test

		/**
		 * Solution A. Count correct bracket(s) sequence
		 */
		Brackets brk = new Brackets();
		brk.solution();

		/**
		 * Solutin C. Count digits of number 100!(100 factorial)
		 */
		Factorial.solution();

		scn.close();
		scn = null;
	}

}
