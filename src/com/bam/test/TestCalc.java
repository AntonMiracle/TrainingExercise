/**
 * Project: Tasks TestCalc.java
 */
package com.bam.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class TestCalc {
	private Calc c;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before methods");
		c = new Calc();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After methods");
	}

	/**
	 * Test method for {@link com.bam.test.Calc#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		assertEquals(2, c.add(1, 1));
	}

	/**
	 * Test method for {@link com.bam.test.Calc#div(double, double)}.
	 */
	@Test
	public void testDiv() {
		assertTrue(10.0 == c.div(20, 2));

	}

}
