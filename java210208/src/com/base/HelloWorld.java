package com.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld extends JFrame implements ActionListener {

	JButton	button	= new JButton("button");
	JPanel	panel	= new JPanel(new BorderLayout());

	public void initDislay() {

		button.addActionListener(this);
		panel.add("North", button);
		this.add("Center", panel);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		hw.initDislay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == button) {
			panel.setBackground(Color.ORANGE);
			button.setVisible(false);
		}
	}
}
