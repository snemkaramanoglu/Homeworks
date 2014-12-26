package Projeler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Hw3BorderLayoutSettings extends JFrame {
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	static JButton button5;
	static JPanel panel1;
	JPanel panel2;
	JLabel label1, label2;
	JTextField field1, field2;

	public Hw3BorderLayoutSettings() {
		
		panel1 = new JPanel(new BorderLayout());
		panel2 = new JPanel(new FlowLayout());

		panel1.setBorder(new TitledBorder("Container of BorderLayout"));
		panel2.setBorder(new TitledBorder("BorderLayout Properties"));

		button1 = new JButton("NORTH");
		button2 = new JButton("EAST");
		button3 = new JButton("WEST");
		button4 = new JButton("SOUTH");
		button5 = new JButton("CENTER");
		this.setLayout(new BorderLayout());

		ekle();

		label1 = new JLabel("HGap");
		label2 = new JLabel("VGap");
		
		field1 = new JTextField(20);
		field2 = new JTextField(20);

		field1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (!field1.getText().equals("")) {
					try {
						panel1.setLayout(new BorderLayout(Integer
								.parseInt(field1.getText()), Integer.parseInt(field2.getText())));
					} catch (Exception k) {
						panel1.setLayout(new BorderLayout(Integer
								.parseInt(field1.getText()), 0));
					}
				} else
					panel1.setLayout(new BorderLayout());
				ekle();
				panel1.invalidate();
				panel1.revalidate();

			}
		});
		
		field2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (!field2.getText().equals("")) {
					try {
						panel1.setLayout(new BorderLayout(Integer.parseInt(field1.getText()), Integer
								.parseInt(field2.getText())));
					} catch (Exception k) {
						panel1.setLayout(new BorderLayout(0, Integer
								.parseInt(field2.getText())));
					}
				} else
					panel1.setLayout(new BorderLayout());
				ekle();
				panel1.invalidate();
				panel1.revalidate();

			}
			
		});

		panel2.add(label1);
		panel2.add(field1);
		panel2.add(label2);
		panel2.add(field2);

		getContentPane().add(panel1, BorderLayout.CENTER);
		getContentPane().add(panel2, BorderLayout.SOUTH);
		this.setTitle("Border Layout");
		this.setSize(640, 580);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		new Hw3BorderLayoutSettings();
	}

	public static void ekle() {
		panel1.add(button1, BorderLayout.NORTH);
		panel1.add(button2, BorderLayout.EAST);
		panel1.add(button3, BorderLayout.WEST);
		panel1.add(button4, BorderLayout.SOUTH);
		panel1.add(button5, BorderLayout.CENTER);
	}
}
