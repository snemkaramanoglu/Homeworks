package Projeler;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Hw2LayoutSettings extends JFrame {

	private JPanel panel1 = null;
	private JPanel panel2 = null;
	JComboBox combobox = null;
	JTextField vgap;
	JTextField hgap;
	JLabel label;
	JLabel label2;
	JLabel label3;

	public Hw2LayoutSettings() {

		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.setBorder(new TitledBorder("A container of flowlayout"));

		JButton button1 = new JButton("Component 0");
		JButton button2 = new JButton("Component 1");
		JButton button3 = new JButton("Component 2");
		JButton button4 = new JButton("Component 3");
		JButton button5 = new JButton("Component 4");
		JButton button6 = new JButton("Component 5");
		JButton button7 = new JButton("Component 6");
		JButton button8 = new JButton("Component 7");
		JButton button9 = new JButton("Component 8");
		JButton button10 = new JButton("Component 9");
		JButton button11 = new JButton("Component 10");
		JButton button12 = new JButton("Component 11");
		JButton button13 = new JButton("Component 12");
		JButton button14 = new JButton("Component 13");
		JButton button15 = new JButton("Component 14");

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
		panel1.add(button6);
		panel1.add(button7);
		panel1.add(button8);
		panel1.add(button9);
		panel1.add(button10);
		panel1.add(button11);
		panel1.add(button12);
		panel1.add(button13);
		panel1.add(button14);
		panel1.add(button15);

		panel2 = new JPanel(new FlowLayout());

		final String[] options = { "LEFT", "RIGHT" };
		combobox = new JComboBox(options);
		combobox.setBounds(100, 100, 150, 150);
		panel2.setBorder(new TitledBorder("FlowLayout Properties"));

		vgap = new JTextField(27);
		hgap = new JTextField(27);

		label = new JLabel("Alignment");
		label2 = new JLabel("HGap");
		label3 = new JLabel("VGap");

		GridLayout panel2Layout = new GridLayout(3, 2);
		panel2.add(label);
		panel2.add(combobox);
		panel2.add(label2);
		panel2.add(hgap);
		panel2.add(label3);
		panel2.add(vgap);

		panel2.setLayout(panel2Layout);

		hgap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				FlowLayout myLayout = new FlowLayout();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (!(hgap.getText().equals(""))) {
						myLayout.setHgap(Integer.parseInt(hgap.getText()));
						panel1.setLayout(myLayout);
						panel1.revalidate();
					}
				}

			}
		});

		vgap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				FlowLayout myLayout = new FlowLayout();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (!(vgap.getText().equals(""))) {
						myLayout.setVgap(Integer.parseInt(vgap.getText()));
						panel1.setLayout(myLayout);
						panel1.revalidate();
					}
				}

			}
		});

		combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (combobox.getSelectedItem().equals(options[0])) {
					panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
					panel1.revalidate();

				} else if (combobox.getSelectedItem().equals(options[1])) {
					panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
					panel1.revalidate();
				}
			}
		});

		setTitle("Hw2LayoutSettings");
		setSize(440, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// setResizable(false);
		getContentPane().setLayout(new GridLayout(2, 0));
		getContentPane().add(panel1);
		getContentPane().add(panel2);

	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Hw2LayoutSettings();

			}
		});

	}

}
