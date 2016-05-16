/**
 * Project: Tasks CalcNumber.java
 */
package com.bam.calculator.model;

import java.math.BigDecimal;

import com.bam.calculator.view.MainFrame;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class CalcNumber {
	private String	number;
	private int		maxDigitsLength	= 16;
	boolean			afterMathOperation;
	MainFrame		mainFrame;

	public CalcNumber() {
		number = "0";
		afterMathOperation = false;
	}

	public CalcNumber(String number, int maxDigitsLength, MainFrame mainFrame) {
		this.number = number;
		this.maxDigitsLength = maxDigitsLength;
		afterMathOperation = true;
		this.mainFrame = mainFrame;
	}

	public void addDigit(String digit) {
		if (isAfterMathOperation()) {
			setNumber(digit);
			setAfterMathOperation(false);
		} else {
			if (getNumber().length() == 1 && getNumber().charAt(0) == '0') {
				setNumber(digit);
			} else {
				setNumber(getNumber() + (isExistFreeSpace() ? digit : ""));
			}
		}
	}

	public boolean isExistFreeSpace() {
		int max = isNumberNegative() ? getMaxDigitsLength() + 1 : getMaxDigitsLength();
		return getNumber().length() < max ? true : false;
	}

	public void changeSign() {
		if (getNumber().length() == 1 && getNumber().charAt(0) == '0') {
			setNumber("0");
		} else {
			setNumber(isNumberNegative() ? new String(getNumber().toCharArray(), 1, getNumber().length() - 1)
					: "-" + getNumber());
		}
	}

	public void addPoint() {
		if (isExistFreeSpace()) {
			if (isNumberDouble()) {
				setNumber(getNumber());
			} else {
				setNumber(getNumber() + ".");
			}
		} else {
			setNumber(getNumber());
		}
	}

	public Double convertIntoDouble() {
		return new Double(Double.valueOf(getNumber()));
	}

	public Long convertIntoLong() {
		String res = "";
		for (char ch : getNumber().toCharArray()) {
			if (ch != '.') {
				res += ch;
			} else {
				break;
			}
		}
		return new Long(Long.valueOf(res));
	}

	public boolean isAfterPointOnlyZero() {
		int count = 0;
		boolean isPointExist = false;
		for (int i = 0; i < getNumber().length(); i++) {
			if (isPointExist) {
				count += getNumber().charAt(i) != '0' ? 1 : 0;
			}
			if (getNumber().charAt(i) == '.') {
				isPointExist = true;
			}
		}
		return count == 0 ? true : false;
	}

	public void cancelLastInput() {
		int index = isNumberNegative() ? 2 : 1;
		if (getNumber().length() > index) {
			setNumber(new String(getNumber().toCharArray(), 0, getNumber().length() - 1));
		} else {
			setNumber("0");
		}
	}

	public boolean isNumberNegative() {
		return getNumber().charAt(0) == '-' ? true : false;
	}

	public boolean isNumberDouble() {
		for (char ch : getNumber().toCharArray()) {
			if (ch == '.') {
				return true;
			}
		}
		return false;
	}

	public void clearNumber() {
		setNumber("0");
	}

	public void showOnDisplay() {
		getMainFrame().getDisplay().setText(this.toString());
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		if (getNumber().charAt(getNumber().length() - 1) != '.') {
			if (isAfterPointOnlyZero()) {
				return convertIntoLong().toString();
			} else {
				return new BigDecimal(getNumber()).toPlainString();
			}
		} else {
			return getNumber();
		}
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CalcNumber && ((CalcNumber) obj).getNumber().equals(getNumber())) {
			return true;
		} else {
			return false;
		}
	}

	/* @see java.lang.Object#clone() */
	@Override
	public CalcNumber clone() throws CloneNotSupportedException {
		return new CalcNumber(getNumber(), getMaxDigitsLength(), getMainFrame());
	}

	/** Getter */
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	/** Getter */
	public int getMaxDigitsLength() {
		return maxDigitsLength;
	}

	/** Setter */
	public void setMaxDigitsLength(int maxDigitsLength) {
		this.maxDigitsLength = maxDigitsLength;
	}

	/** Getter */
	public String getNumber() {
		return number;
	}

	/** Getter */
	public boolean isAfterMathOperation() {
		return afterMathOperation;
	}

	/** Setter */
	public void setAfterMathOperation(boolean afterMathOperation) {
		this.afterMathOperation = afterMathOperation;
	}

	/** Setter */
	public void setNumber(String number) {
		this.number = number;
	}

	/** Setter */
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}