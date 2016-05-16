/**
 * Project: Tasks CalcController.java
 */
package com.bam.calculator.controller;

import java.security.GeneralSecurityException;

import com.bam.calculator.model.CalcNumber;
import com.bam.calculator.model.History;
import com.bam.calculator.model.MathOperation;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class CalcController {
	CalcNumber		number;
	History			history;
	MathOperation	mathOperation;
	boolean isOperationOff = true;
	// boolean isFirstNumberAdd = false;

	public CalcController(CalcNumber number, History history, MathOperation mathOperation) {
		this.number = number;
		this.history = history;
		this.mathOperation = mathOperation;
	}

	public void action(int operation, String digit) {
		getNumber().addDigit(digit);
		showOnNumberDisplay();
	}

	public void action(int operation) {
		switch (operation) {
			case 1:
				getNumber().cancelLastInput();
				showOnNumberDisplay();
				break;
			case 2:
				getNumber().changeSign();
				showOnNumberDisplay();
				break;
			case 3:
				getNumber().addPoint();
				showOnNumberDisplay();
				break;
			case 10:// summ				
				addToHistory(getNumber(), operation);
				showOnHistoryDisplay();			
				getMathOperation().sum(number);
				setNumber(cloneResult(getMathOperation().getResult()));
				showOnNumberDisplay();
				System.out.println(mathOperation.getResult().toString());				 				
				break;
		}
	}
	
	private CalcNumber cloneResult(CalcNumber num){
		CalcNumber newNum = null;
		try{
			newNum = num.clone();
		}catch (CloneNotSupportedException e){
				System.out.println(e);			
		}
		return newNum;
	}

	private void operationOff(){
		setOperationOff(true);
	}
	private void operationOn(){
		setOperationOff(false);
	}
	
	private void showOnHistoryDisplay() {
		getHistory().showOnHistoryDisplay();
	}

	private void addToHistory(CalcNumber number, int operation) {
		getHistory().addToHistory(number, operation);
	}

	private void showOnNumberDisplay() {
		getNumber().showOnDisplay();
	}

	/** Setter */
	private void setNumber(CalcNumber number) {
		this.number = number;
	}

	/** Getter */
	private History getHistory() {
		return history;
	}

	/** Setter */
	private void setHistory(History history) {
		this.history = history;
	}

	/** Getter */
	private CalcNumber getNumber() {
		return number;
	}

	
	/** Getter */
	private MathOperation getMathOperation() {
		return mathOperation;
	}

	
	/** Setter */
	private void setMathOperation(MathOperation mathOperation) {
		this.mathOperation = mathOperation;
	}

	
	/** Getter */
	private boolean isOperationOff() {
		return isOperationOff;
	}

	
	/** Setter */
	private void setOperationOff(boolean isOperationOff) {
		this.isOperationOff = isOperationOff;
	}

	
	
	

}
