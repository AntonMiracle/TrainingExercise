/**
 * Project: Tasks History.java
 */
package com.bam.calculator.model;

import com.bam.calculator.view.MainFrame;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class History {
	String		history;
	MainFrame	mainFrame;

	public History() {
		history = "";
	}

	public void addToHistory(String text) {
		history += isEmpty() ? text : "\n" + text;
	}

	public void addToHistory(CalcNumber number, int operation) {
		addToHistory(number.toString());
		addToHistory(getOperation(operation));
	}

	public void clearHistory() {
		history = "history";
	}

	public boolean isEmpty() {
		return history.length() == 0 ? true : false;
	}

	public void showOnHistoryDisplay() {
		mainFrame.getDisplay2().setText(history);
	}

	public String getOperation(int operation) {
		String res = null;
		switch (operation) {
			case 10:
				res = " + ";
				break;
			case 11:
				res = " - ";
				break;
			case 12:
				res = " * ";
				break;
			case 13:
				res = " / ";
				break;
			case 14:
				res = " = ";
		}
		return res;
	}

	/** Setter */
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}
// String history;
// CalcNumber number, bufferedNumber, test;
// int maxDigitInLine = 21, currentCharInLine = 0, lastOperation = 0;
//
// public History(CalcNumber test) {
// this.test = test;
// history = "";
// }
//
// public CalcNumber addNumberToHistory(CalcNumber number, int operation) {
// number.setNumberAddToHistory(true);
// if (isHistoryEmpty()) {
// this.number = number;
// bufferedNumber = number;
// } else {
// this.number = number;
//// mathOperation(lastOperation);
// }
// lastOperation = operation;
// if (operation == 5) {
// bufferedNumber.setNumberAddToHistory(true);
// number = bufferedNumber;
// }
// CalcNumber newNumber = cloneAddedNumber(number);
// addToHistory(operation);
// return newNumber;
// }
//
// private boolean isHistoryEmpty() {
// return history.length() == 0 ? true : false;
// }
//
// private CalcNumber cloneAddedNumber(CalcNumber number) {
// CalcNumber newNumber = null;
// try {
// newNumber = number.clone();
// } catch (CloneNotSupportedException ex) {
// System.out.println(ex);
// }
// return newNumber;
// }
//
//// public void mathOperation(int operation) {
//// switch (operation) {
//// case 1:
//// bufferedNumber = MathOperation.sum(bufferedNumber, number);
//// break;
//// case 2:
//// bufferedNumber = MathOperation.minus(bufferedNumber, number);
//// break;
//// case 3:
//// bufferedNumber = MathOperation.multi(bufferedNumber, number);
//// break;
//// case 4:
//// bufferedNumber = MathOperation.sum(bufferedNumber, number);
//// break;
//// case 5:
//// history = "";
//// }
//// }
//
//
//
// public void addToHistory(int operation) {
// if (isHistoryEmpty()) {
// correctHistory(operation);
// } else {
// history += "\n";
// correctHistory(operation);
// }
// }
//
// private void correctHistory(int operation) {
// if (operation == 5) {
// history += " " + number + "\n" + getOperation(operation) + bufferedNumber;
// } else {
// history += " " + number + "\n" + getOperation(operation);
// }
// }
//
// public String divisionByZero(CalcNumber num){
// String res = history + "\nDivision by zero";
// history = "";
// num.setNumberAddToHistory(true);
// return res;
// }
//
// /** Getter */
// public String getHistory() {
// return history;
// }
//
// /** Getter */
// public int getLastOperation() {
// return lastOperation;
// }
//
//
// /** Setter */
// public void setHistory(String history) {
// this.history = history;
// }
//
// }
