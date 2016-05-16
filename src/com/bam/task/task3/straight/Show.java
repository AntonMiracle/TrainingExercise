/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.straight;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {
	public static String showStraight(Straight s[]) {
		String show = "";
		for (int i = 0; i < s.length; i++) {
			show += showStraight(s[i]);
		}
		return show;
	}

	public static String showStraight(Straight s) {
		String show = "\n-------------------------------------------" + String.format("\n|%15s|%25s|", "ID", s.getId())
				+ String.format("\n|%15s|%25s|", "Straight", s.toString()) + "\n-------------------------------------------";
		return show;
	}

}
