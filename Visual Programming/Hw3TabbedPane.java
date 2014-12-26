package Projeler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Hw3TabbedPane extends JFrame {
	JTabbedPane pane;
	JPanel panel1, panel2;
	JLabel label1, label2, label3, intCalc, rationCalc;

	public Hw3TabbedPane() {

		panel1 = ekleInt();
		intCalc = new JLabel("Integer Calculations");
		intCalc.setHorizontalAlignment(JLabel.CENTER);
		rationCalc = new JLabel("Rational Calculations");
		rationCalc.setHorizontalAlignment(JLabel.CENTER);

		panel1.add(intCalc, BorderLayout.NORTH);
		panel2 = ekleRat();
		panel2.add(rationCalc, BorderLayout.NORTH);

		pane = new JTabbedPane();
		pane.addTab("Integer Operations", panel1);
		pane.addTab("Rational Operations", panel2);
		getContentPane().add(pane);
		this.setTitle("Tabbed Pane");
		this.setSize(480, 360);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new Hw3TabbedPane();
	}

	public JPanel ekleInt() {
		JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		panel1.setLayout(new FlowLayout());
		final JTextField field1;
		final JTextField field2;
		final JTextField field3;

		label1 = new JLabel("Number1");
		label2 = new JLabel("Number2");
		label3 = new JLabel("Result");
		field1 = new JTextField(4);
		field2 = new JTextField(4);
		field3 = new JTextField(6);
		field3.setEditable(false);

		panel2.setLayout(new FlowLayout());
		panel2.add(label1);
		panel2.add(field1);
		panel2.add(label2);
		panel2.add(field2);
		panel2.add(label3);
		panel2.add(field3);

		JButton button1 = new JButton("Add"), button2 = new JButton("Subtract"), button3 = new JButton(
				"Multiply"), button4 = new JButton("Divide");

		button1 = new JButton("Add");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);
				field3.setText(""
						+ ((Integer.parseInt(field1.getText())) + Integer
								.parseInt(field2.getText())));
				panel2.revalidate();
			}
		});
		button2 = new JButton("Subtract");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);
				field3.setText(""
						+ ((Integer.parseInt(field1.getText())) - Integer
								.parseInt(field2.getText())));
				panel2.revalidate();
			}
		});
		button3 = new JButton("Multiply");
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);
				field3.setText(""
						+ (Integer.parseInt(field1.getText()) * Integer
								.parseInt(field2.getText())));
				panel2.revalidate();
			}
		});

		button4 = new JButton("Divide");
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setText("");
				field3.setColumns(6);
				try {
					field3.setText("" + Integer.parseInt(field1.getText())
							/ Integer.parseInt(field2.getText()));
					panel2.revalidate();
				} catch (Exception k) {
					field3.setColumns(15);
					field3.setText("Divisor cannot be zero!");
					panel2.revalidate();
				}
			}
		});

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);

		topPanel.add(panel1, BorderLayout.SOUTH);
		topPanel.add(panel2, BorderLayout.CENTER);
		return topPanel;
	}

	public JPanel ekleRat() {
		JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		panel1.setLayout(new FlowLayout());
		final JTextField field1;
		final JTextField field2;
		final JTextField field3;
		label1 = new JLabel("Number1");
		label2 = new JLabel("Number2");
		label3 = new JLabel("Result");
		field1 = new JTextField(4);
		field2 = new JTextField(4);
		field3 = new JTextField(6);
		field3.setEditable(false);

		JButton button1 = new JButton("Add"), button2 = new JButton("Subtract"), button3 = new JButton(
				"Multiply"), button4 = new JButton("Divide");

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);

				field3.setText(""
						+ String.format(Locale.US, "%.5f", (Double
								.parseDouble(field1.getText()) + Double
								.parseDouble(field2.getText()))));
				panel2.revalidate();
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);
				field3.setText(""
						+ String.format(Locale.US, "%.5f", (Double
								.parseDouble(field1.getText()) - Double
								.parseDouble(field2.getText()))));
				panel2.revalidate();
			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setColumns(6);
				field3.setText(""
						+ String.format(Locale.US, "%.5f", (Double
								.parseDouble(field1.getText()) * Double
								.parseDouble(field2.getText()))));
				panel2.revalidate();
			}
		});

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field3.setText("");
				field3.setColumns(6);
				try {
					field3.setText(""
							+ String.format(Locale.US, "%.5f", (Double
									.parseDouble(field1.getText()) / Double
									.parseDouble(field2.getText()))));
					panel2.revalidate();
				} catch (Exception k) {
					field3.setColumns(15);
					field3.setText("Divisor cannot be zero!");
					panel2.revalidate();
				}
			}
		});

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);

		panel2.setLayout(new FlowLayout());
		panel2.add(label1);
		panel2.add(field1);
		panel2.add(label2);
		panel2.add(field2);
		panel2.add(label3);
		panel2.add(field3);

		topPanel.add(panel1, BorderLayout.SOUTH);
		topPanel.add(panel2, BorderLayout.CENTER);
		return topPanel;
	}
}
