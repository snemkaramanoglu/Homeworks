package Projeler;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

	public Matrix() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		rnd = new Random();
		setTitle("Homework1 Layouts");
		setSize(540, 578);
		setLocationRelativeTo(null);

		Dimension d;

		for (int i = 0; i < 400; i++) {
			random = rnd.nextInt(2);
			toplam += random;

			dizi[i] = new JLabel("" + random, JLabel.CENTER);
			d = dizi[i].getPreferredSize();
			dizi[i].setPreferredSize(new Dimension(d.width + 20, d.height));
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
