/**
 * Project: TrainingExercise Brackets.java
 */
package com.implemica;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Bondarenko Anton Michailovich
 * @version 1.5
 *
 */
public class Brackets {
	private final String	OPEN	= "(";
	private final String	CLOSE	= ")";
	private Set<String>		set;
	private int				numberPairs;
	private boolean			systemPro;

	/**
	 * Constructor Create one pair of bracket sequence.
	 */
	public Brackets() {
		this(1);
	}

	/**
	 * Constructor Create bracket sequence with specified number of pairs. If
	 * pairs are more than ten, system automation change pairs number on 7.
	 * 
	 * @param numberOfPairs
	 *        number of pairs.
	 */
	public Brackets(int numberOfPairs) {
		if (numberOfPairs <= 10) {
			this.numberPairs = numberOfPairs;
			this.systemPro = false;
		} else {
			this.numberPairs = 7;
			this.systemPro = true;
		}
		this.set = new HashSet<String>();
		makeBrackets(1);
	}

	/**
	 * Method add one pair of bracket sequence '()' to the exist bracket
	 * sequence variation. Create additional, correct bracket sequence
	 * variations and add there to the collection of bracket variations.
	 * 
	 * @param bracket
	 *        exist bracket sequence variation.
	 */
	private void addBracketPair(String bracket) {
		String result = getOPEN() + getCLOSE() + bracket;
		getSet().add(result);
		for (int i = 0; i < bracket.length(); i++) {
			result = getOPEN() + insertWord(bracket, getCLOSE(), i);
			getSet().add(result);
			result = insertWord(bracket, getOPEN(), i) + getCLOSE();
			getSet().add(result);
		}
	}

	/**
	 * Create correct bracket sequence variations from one to maximum number of
	 * pairs
	 * 
	 * @param pair
	 *        current pair on which create correct bracket sequance variations
	 */
	private void makeBrackets(int pair) {
		if (pair == 1) {
			addBracketPair("");
			pair++;
			makeBrackets(pair);
		} else {
			if (pair <= getNumberPairs()) {
				Set<String> tmp = new HashSet<String>(getSet());
				for (String brackets : tmp) {
					addBracketPair(brackets);
				}
				pair++;
				makeBrackets(pair);
			}
		}
	}

	/**
	 * Insert word into another word.
	 * 
	 * @param insertTo
	 *        word where want to insert the another word
	 * @param word
	 *        word which need to insert
	 * @param afterIndex
	 *        index of char after which need to insert another word
	 * @return String new word
	 */
	private String insertWord(String insertTo, String word, int afterIndex) {
		String before = insertTo.substring(0, afterIndex + 1);
		String after = insertTo.substring(afterIndex + 1, insertTo.length());
		return before + word + after;
	}

	/**
	 * Create bracket sequence with user input number of pairs. If input data
	 * not a number, system automation give additional try while input data is
	 * not number
	 */
	public static void run() {
		Scanner scn = new Scanner(System.in);
		boolean inputPro = true;
		int number = 0;
		String title = "----- Enter number of bracket pairs -----";
		String error = "----- You enter not number -----";
		do {
			System.out.println(title);
			String text = scn.nextLine();
			try {
				number = Integer.parseInt(text.trim());
				inputPro = false;
			} catch (NumberFormatException ex) {
				System.out.println(error);
			} finally {
				scn.close();
			}
		} while (inputPro);
		System.out.println(new Brackets(number));
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		int i = 1;
		String title = String.format("\n----- Brackets with %s pairs -----", numberPairs);
		String result = "";
		String end = "";
		for (String brackets : getSet()) {
			if (brackets.length() == getNumberPairs() * 2) {
				result += String.format("\n%s : %s", brackets, new Integer(i++).toString());
			}
		}
		end = isSystemPro()
				? String.format("\nNumbers of pairs more than 10 (user set : %s). System automation set 7 pairs",
						getNumberPairs())
				: "";
		return String.format("%s%s%s", title, result, end);
	}

	/**
	 * Open bracket
	 * 
	 * @return String
	 */
	public String getOPEN() {
		return OPEN;
	}

	/**
	 * Close bracket
	 * 
	 * @return String
	 */
	public String getCLOSE() {
		return CLOSE;
	}

	/**
	 * Collection of correct bracket sequence variations
	 * 
	 * @return Set<String>
	 */
	public Set<String> getSet() {
		return set;
	}

	/**
	 * Number of maximum pairs of bracket siquence variations
	 * 
	 * @return int
	 */
	public int getNumberPairs() {
		return numberPairs;
	}

	/**
	 * System protection. Which do not let user input data which can crush or
	 * slow system
	 * 
	 * @return boolean
	 */
	public boolean isSystemPro() {
		return systemPro;
	}

}
