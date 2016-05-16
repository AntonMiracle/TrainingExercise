/**
 * Project: Tasks MathOperation.java
 */
package com.bam.calculator.model;

import javax.print.attribute.SetOfIntegerSyntax;

import org.omg.CORBA.IdentifierHelper;

import com.bam.calculator.view.MainFrame;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class MathOperation {
	int			lastOperation;
	boolean		isFirstAdd, isSecondAdd;
	MainFrame	mainFrame;
	CalcNumber	number, result;

	public MathOperation() {
		lastOperation = 0;
		isFirstAdd = false;
	}

	public void addNumber(CalcNumber number) {
		if (isFirstAdd()) {
			setNumber(number);
			setSecondAdd(true);
		} else {
			setResult(number);
			setFirstAdd(true);

		}
	}

	// public void clearOperation(){
	// setLastOperation(0);
	// setFirstAdd(false);
	// setSecondAdd(false);
	// }

	public void sum(CalcNumber number) {
		addNumber(number);
		if (isSecondAdd()) {
			Double dResult = getResult().convertIntoDouble();
			Double dNumber = getNumber().convertIntoDouble();
			getResult().setNumber(new Double(dResult + dNumber).toString());
		}

	}

	private Double convertIntoDouble(CalcNumber num) {
		return Double.valueOf(num.getNumber());
	}

	/** Getter */
	public CalcNumber getNumber() {
		return number;
	}

	/** Setter */
	public void setNumber(CalcNumber number) {
		this.number = number;
	}

	/** Getter */
	public CalcNumber getResult() {
		return result;
	}

	/** Setter */
	public void setResult(CalcNumber result) {
		this.result = result;
	}

	/** Getter */
	public int getLastOperation() {
		return lastOperation;
	}

	/** Setter */
	public void setLastOperation(int lastOperation) {
		this.lastOperation = lastOperation;
	}

	/** Getter */
	public boolean isFirstAdd() {
		return isFirstAdd;
	}

	/** Setter */
	public void setFirstAdd(boolean isFirstAdd) {
		this.isFirstAdd = isFirstAdd;
	}

	/** Getter */
	private boolean isSecondAdd() {
		return isSecondAdd;
	}

	/** Setter */
	private void setSecondAdd(boolean isSecondAdd) {
		this.isSecondAdd = isSecondAdd;
	}

	/** Setter */
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	// public static CalcNumber sum(CalcNumber buff, CalcNumber num) {
	// // CalcNumber cn = new CalcNumber();
	// Double dBuff = convertIntoDouble(buff);
	// Double dNum = convertIntoDouble(num);
	// cn.setNumber(Double.valueOf(dBuff + dNum).toString());
	// return cn;
	// }
	//
	// public static CalcNumber minus(CalcNumber buff, CalcNumber num) {
	// CalcNumber cn = new CalcNumber();
	// Double dBuff = convertIntoDouble(buff);
	// Double dNum = convertIntoDouble(num);
	// cn.setNumber(Double.valueOf(dBuff - dNum).toString());
	// return cn;
	// }
	//
	// public static CalcNumber multi(CalcNumber buff, CalcNumber num) {
	// CalcNumber cn = new CalcNumber();
	// Double dBuff = convertIntoDouble(buff);
	// Double dNum = convertIntoDouble(num);
	// cn.setNumber(Double.valueOf(dBuff * dNum).toString());
	// return cn;
	// }
	//
	// public static CalcNumber div(CalcNumber buff, CalcNumber num) {
	// CalcNumber cn = new CalcNumber();
	// Double dBuff = convertIntoDouble(buff);
	// Double dNum = convertIntoDouble(num);
	// cn.setNumber(Double.valueOf(dBuff / dNum).toString());
	// return cn;
	// }
	//
	//

}
