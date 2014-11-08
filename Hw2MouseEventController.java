package Projeler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hw2MouseEventController extends JFrame {

	static String mousePosition = "";
	static JLabel label;

	public Hw2MouseEventController() {
		label = new JLabel(mousePosition);
		this.setLayout(null); //
		this.getContentPane().add(label); //

		label.setBounds(100, 100, 50, 50);
		this.getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				label.setText("(" + e.getX() + "," + e.getY() + ")");
				label.

				setBounds(e.getX(), e.getY(), 100, 50);
			}
		});

		this.setSize(900, 500);
		this.setVisible(true);
		this.setTitle("Hw2MouseEventController");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Hw2MouseEventController();

	}

}