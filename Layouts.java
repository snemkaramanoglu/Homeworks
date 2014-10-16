package Projeler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts extends JFrame {
	JPanel panel1, panel2;
	JButton button1, button2, button3, button4, button5, button6, button7,
			button8;

	public Layouts() {
		setTitle("Homework1 Layouts");
		getContentPane().setLayout(new BorderLayout());
		button1 = new JButton("Button1");
		button2 = new JButton("Button2");
		button3 = new JButton("Button3");
		button4 = new JButton("Button4");
		button5 = new JButton("Button5");
		button6 = new JButton("Button6");
		button7 = new JButton("Button7");
		button8 = new JButton("Button8");

		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		
	    
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(button7);
		panel2.add(button8);
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel2,BorderLayout.SOUTH);
		setSize(380, 260);

		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Layouts().setVisible(true);

			}
		});
	}
}
