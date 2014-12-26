package Projeler;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Matrix extends JFrame {
	JPanel panel;
	JLabel[] dizi = new JLabel[400];
	Random rnd;
	int random;
	static int toplam;
	Font myFont;
	Dimension d;

	public Matrix() {
		panel = new JPanel();
		myFont = new Font("Times New Roman", Font.PLAIN, 10);

		panel.setLayout(new FlowLayout());
		rnd = new Random();
		setTitle("Homework1 Layouts");
		setSize(600, 600);
		setLocationRelativeTo(null);

		for (int i = 0; i < 400; i++) {

			random = rnd.nextInt(2);
			toplam += random;

			dizi[i] = new JLabel("" + random, JLabel.CENTER);
			dizi[i].setFont(myFont);
			d = dizi[i].getPreferredSize();
			dizi[i].setPreferredSize(new Dimension(d.width + 19, d.height + 10));

			panel.add(dizi[i]);

		}
		getContentPane().add(panel);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		new Matrix().setVisible(true);

		JOptionPane.showMessageDialog(null, "sum=" + toplam);

	}

}
