package Xox;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This class is used to build a popular tic-tac-toe game. Game does not have
 * rules, and there can't be a winner.
 * 
 * @author LAPA
 *
 */
public class Xox extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton[] button = new JButton[9];
	private int counter = 0;

	/**
	 * Constructor for game.
	 * 
	 */
	public Xox() {
		GridLayout panel = new GridLayout(3, 3);
		setLayout(panel);
		setTitle("XoX Game");
		setVisible(true);
		setSize(300, 300);
		Action listener = new Action();
		// setting 3x3 panel using for loop
		for (int i = 0; i < button.length; i++) {
			add(button[i] = new JButton("_"));
			button[i].addActionListener(listener);
		}
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < button.length; i++) {
				// placing 'X' in square
				if (e.getSource() == button[i] && counter % 2 == 0) {
					counter++;
					button[i].setText("X");
					// placing 'O' in square
				} else if (e.getSource() == button[i] && counter % 2 != 0) {
					counter++;
					button[i].setText("O");
				}
			}
		}
	}

	public static void main(String[] args) {

		new Xox();
	}

}
