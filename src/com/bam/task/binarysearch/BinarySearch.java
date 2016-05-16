/**
 * Project: Tasks BinarySearch.java
 */
package com.bam.task.binarysearch;

import org.junit.Test;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class BinarySearch {
	private char	arr[];
	private int		countSearchStep, index;

	public BinarySearch(char arr[]) {
		this.arr = arr;
		countSearchStep = 1;
		index = -1;
	}

	/**
	 * Search index of char in array. True is find another false;
	 * 
	 * @param value
	 *        sought of char
	 * @return true if char in array
	 */
	public boolean isFind(char value) {
		int len, mid;
		int begin = 0;
		int end = arr.length - 1;
		if (value >= arr[0] && value <= arr[arr.length - 1]) {
			while (index == -1) {
				countSearchStep++;
				len = end - begin;
				mid = len / 2;
				if (arr[mid] == value) {
					index = mid;
				}
				if (arr[mid] > value) {
					end = mid;
				}
				if (arr[mid] < value) {
					begin = mid;
				}
			}
		}
		if (index != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Self test is search own chars in the array;
	 */
	public void testSearch() {
		for (int i = 0; i < arr.length; i++) {
			boolean isInArr = isFind(arr[i]);
			int res = -1;
			String msg = "\nIs in source array exist char = " + arr[i] + " ?" + " Result = " + isInArr;
			if (isInArr) {
				res = index;
				msg += "\nChar has index #" + new Integer(i).toString() + "\nValue of steps which need to find char: "
						+ new Integer(countSearchStep).toString();
			}
			System.out.println(msg);
		}
		clearResult();
	}

	/**
	 * Test search value of index in source array, if it in array
	 * 
	 * @param value
	 *        sought of char
	 * @return String
	 */
	public String testSearch(char value) {
		boolean isInArr = isFind(value);
		int res = -1;
		String msg = "\nIs in source array exist char = " + value + " ?" + " Result = " + isInArr;
		if (isInArr) {
			res = index;
			msg += "\nChar has index #" + new Integer(index).toString() + "\nValue of steps which need to find char: "
					+ new Integer(countSearchStep).toString();
		} else {
			msg += "\nChar not found. Value of steps which need to find char: "
					+ new Integer(countSearchStep).toString();
		}
		clearResult();
		return msg;
	}

	/**
	 * Test search value of index in source array, if it in array
	 * 
	 * @param value
	 *        sought of array of chars
	 * @return String
	 */
	public String testSearch(char value[]) {
		String msg = "";
		for (int i = 0; i < value.length; msg += testSearch(value[i++]));
		clearResult();
		return msg;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		String res = "";
		for (char ch : arr) {
			res += ch + " ";
		}
		return "BinarySearch char[]: " + res + "\nValue of search step : " + new Integer(countSearchStep).toString();
	}

	/** Getter */
	public int getCountSearchStep() {
		return countSearchStep;
	}

	/** Getter */
	public int getIndex() {
		return index;
	}


	public void clearResult() {
		this.index = -1;
		this.countSearchStep = 1;
	}

}
