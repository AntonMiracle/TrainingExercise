/**
 * Project: Tasks Main.java
 */
package com.bam.task.binarysearch;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Main {

	public static void main(String[] args) {
		char ch1 = 'z', ch2 = '1';
		char arr[] = {'a','b','c','d','e','f','g','h'};
		BinarySearch bs = new BinarySearch(arr);
		System.out.println(bs);
		
		//Search index of character from same array	
		bs.testSearch();
		//Search index of ch1, ch2;
		System.out.println(bs.testSearch(ch1));
		System.out.println(bs.testSearch(ch2));
	}

}
