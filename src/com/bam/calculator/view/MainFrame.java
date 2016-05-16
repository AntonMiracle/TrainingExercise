/**
 * Project: Tasks MainFrame.java
 */
package com.bam.calculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class MainFrame extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private Font				fontB				= new Font("AREAL", 2, 15);
	private Font				fontD				= new Font("AREAL", 2, 23);	// 23
	private Font				fontH				= new Font("AREAL", 2, 15);
	JButton			b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, c, sign, res, point, sum, minus, div, multi;
	JTextArea		display, display2;
	JScrollPane scroll;
	ActionListener	actionListener;
	MouseListener	mouseListener;

	/**
	 * @throws HeadlessException
	 */
	public MainFrame() throws HeadlessException {
		super();
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(240, 377));
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void finishAndRun() {
		addComponents(getContentPane());
		pack();
		setVisible(true);
	}

	/**
	 * @param contentPane
	 */
	private void addComponents(Container cp) {
		cp.setLayout(null);
		Color numberBack = Color.WHITE;
		Color numberFont = Color.DARK_GRAY;
		Color otherBack = Color.LIGHT_GRAY;
		Color otherFont = Color.BLACK;
		int buttonH = 40;
		int buttonW = 60;
		c = button("C", 0, 150, Color.RED, otherBack, buttonH, buttonW);
		sign = button("+/-", 60, 150, otherFont, otherBack, buttonH, buttonW);
		b1 = button("1", 0, 270, numberFont, numberBack, buttonH, buttonW);
		b2 = button("2", 60, 270, numberFont, numberBack, buttonH, buttonW);
		b3 = button("3", 120, 270, numberFont, numberBack, buttonH, buttonW);
		b4 = button("4", 0, 230, numberFont, numberBack, buttonH, buttonW);
		b5 = button("5", 60, 230, numberFont, numberBack, buttonH, buttonW);
		b6 = button("6", 120, 230, numberFont, numberBack, buttonH, buttonW);
		b7 = button("7", 0, 190, numberFont, numberBack, buttonH, buttonW);
		b8 = button("8", 60, 190, numberFont, numberBack, buttonH, buttonW);
		b9 = button("9", 120, 190, numberFont, numberBack, buttonH, buttonW);
		b0 = button("0", 0, 310, numberFont, numberBack, buttonH, buttonW * 3);
		point = button(".", 120, 150, otherFont, otherBack, buttonH, buttonW);
		res = button("=", 180, 310, otherFont, otherBack, buttonH, buttonW);
		sum = button("+", 180, 150, otherFont, otherBack, buttonH, buttonW);
		minus = button("-", 180, 190, otherFont, otherBack, buttonH, buttonW);
		multi = button("*", 180, 270, otherFont, otherBack, buttonH, buttonW);
		div = button("/", 180, 230, otherFont, otherBack, buttonH, buttonW);
		display = textArea("0", 0, 120, otherFont, Color.white, 1, fontD);
		display2 = textArea("History", 0, 0, otherFont, Color.white, 4, fontH);
		scroll = jscrollPane(display2, 0, 0);
		
		JComponent jc[] = {c,sign,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,res,point,sum,minus,div,multi,display,display2,scroll};
		for (JComponent comp : jc) {
			cp.add(comp);
		}
	}
	
	private JScrollPane jscrollPane(JTextArea ta, int x, int y){
		JPanel jp = new JPanel();
		
		jp.add(ta);
		jp.setVisible(true);
		jp.setBounds(x, y, 200, 200);
		JScrollPane sp = new JScrollPane(jp);	
	
		return sp;
	}

	private JTextArea textArea(String name, int x, int y, Color textColor, Color backColor, int numberOfLines,
			Font font) {		
		JTextArea jt = new JTextArea();
//		JScrollPane sp = new JScrollPane(Scrollbar.VERTICAL);
//		jt.add(sp);
		jt.setFont(font);
		jt.setEditable(false);
		jt.setForeground(textColor);
		jt.setBackground(backColor);
		jt.setText(name);
		jt.setBounds(x, y, 240, numberOfLines * 30);
		return jt;
	}

	private JButton button(String name, int x, int y, Color textColor, Color backColor, int sizeH, int sizeW) {
		JButton jb = new JButton(name);
		jb.setBackground(backColor);
		jb.setForeground(textColor);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
		jb.setToolTipText(name);
		jb.setFont(fontB);
		jb.setBorderPainted(false);
		jb.setBounds(x, y, sizeW, sizeH);
		jb.addMouseListener(mouseListener);
		jb.addActionListener(actionListener);
		return jb;
	}

	/** Setter */
	public void setAl(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/** Setter */
	public void setMl(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}

	/** Getter */
	public JButton getB1() {
		return b1;
	}

	/** Getter */
	public JButton getB0() {
		return b0;
	}

	/** Getter */
	public JTextArea getDisplay() {
		return display;
	}

	/** Getter */
	public JButton getB2() {
		return b2;
	}

	/** Getter */
	public JButton getB3() {
		return b3;
	}

	/** Getter */
	public JButton getB4() {
		return b4;
	}

	/** Getter */
	public JButton getB5() {
		return b5;
	}

	/** Getter */
	public JButton getB6() {
		return b6;
	}

	/** Getter */
	public JButton getB7() {
		return b7;
	}

	/** Getter */
	public JButton getB8() {
		return b8;
	}

	/** Getter */
	public JButton getB9() {
		return b9;
	}

	/** Getter */
	public JButton getC() {
		return c;
	}

	/** Getter */
	public JButton getSign() {
		return sign;
	}

	/** Getter */
	public JButton getRes() {
		return res;
	}

	/** Getter */
	public JButton getPoint() {
		return point;
	}

	/** Getter */
	public JButton getSum() {
		return sum;
	}

	/** Getter */
	public JButton getMinus() {
		return minus;
	}

	/** Getter */
	public JButton getDiv() {
		return div;
	}

	/** Getter */
	public JButton getMulti() {
		return multi;
	}

//	/** Getter */
//	public JScrollPane getDisplay2() {
//		return display2;
//	}
	
	/** Getter */
	public JTextArea getDisplay2() {
		return display2;
	}

}
