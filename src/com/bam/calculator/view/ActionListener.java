/**
 * Project: Tasks ActionListener.java
 */
package com.bam.calculator.view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.bam.calculator.controller.CalcController;
import com.bam.calculator.model.CalcNumber;
import com.bam.calculator.model.History;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class ActionListener implements java.awt.event.ActionListener {
	MainFrame		mf;
	CalcController	cc;

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			String text = new Integer(i).toString();
			if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals(text)) {
				cc.action(0, text);
			}
		}
		if (e.getSource() == mf.getC()) {
			cc.action(1);
		}
		if (e.getSource() == mf.getSign()) {
			cc.action(2);
		}
		if (e.getSource() == mf.getPoint()) {
			cc.action(3);
		}
		if (e.getSource() == mf.getSum()) {
			cc.action(10);
		}
	}

	
	/** Setter */
	public void setMf(MainFrame mf) {
		this.mf = mf;
	}

	
	/** Setter */
	public void setCc(CalcController cc) {
		this.cc = cc;
	}
	
}
//
//
//
// if (e.getSource() == mf.getRes() && history.getLastOperation() != 5) {
// if (history.getLastOperation() == 4) {
// mf.getDisplay2().setText(history.divisionByZero(num));
// } else {
// num = history.addNumberToHistory(num, 5);
// mf.getDisplay2().setText(history.getHistory());
// }
// }
// if (e.getSource() == mf.getMinus()) {
// num = history.addNumberToHistory(num, 2);
// mf.getDisplay2().setText(history.getHistory());
// }
// if (e.getSource() == mf.getMulti()) {
// num = history.addNumberToHistory(num, 3);
// mf.getDisplay2().setText(history.getHistory());
// }
// if (e.getSource() == mf.getDiv()) {
// num = history.addNumberToHistory(num, 4);
// mf.getDisplay2().setText(history.getHistory());
// }
// mf.getDisplay().setText(num.getNumber());
// }
// }
