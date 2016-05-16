/**
 * Project: Tasks MouseListener.java
 */
package com.bam.calculator.view;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class MouseListener implements java.awt.event.MouseListener {
	MainFrame mf;	

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			((JButton) e.getSource()).setBorderPainted(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			((JButton) e.getSource()).setBorderPainted(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	
	/** Setter */
	public void setMf(MainFrame mf) {
		this.mf = mf;
	}
	
	

}
