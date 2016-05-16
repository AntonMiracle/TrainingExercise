/**
 * Project: Tasks Calculator.java
 */
package com.bam.calculator.model;

import com.bam.calculator.controller.CalcController;
import com.bam.calculator.view.ActionListener;
import com.bam.calculator.view.MainFrame;
import com.bam.calculator.view.MouseListener;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Calculator {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		History history = new History();
		MathOperation mathOperation = new MathOperation();
		CalcNumber number = new CalcNumber();
		CalcController calcController = new CalcController(number, history, mathOperation);
		MouseListener mouseListener = new MouseListener();
		ActionListener actionListener = new ActionListener();
		mouseListener.setMf(mainFrame);
		actionListener.setCc(calcController);
		actionListener.setMf(mainFrame);
		mathOperation.setMainFrame(mainFrame);
		history.setMainFrame(mainFrame);
		number.setMainFrame(mainFrame);
		mainFrame.setAl(actionListener);
		mainFrame.setMl(mouseListener);
		mainFrame.finishAndRun();
	}

}
