package ba.bitcamp.task4;

import javax.swing.JOptionPane;

/**
 * This class is asking user to enter one number. after that is asking to enter
 * another number. If user dont want to enter second number on screen will be
 * written sum of all numbers from 0 to that number, and if he enter another
 * number the program will repeating first step and so until user chose cancel
 * or no
 * 
 * @author LAPA
 *
 */
public class Task4Windows {

	public static void main(String[] args) {
		int number1 = 0;
		int choice1 = 0;
		number1 = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter number?"));
		choice1 = JOptionPane.showConfirmDialog(null, "Enter another number?");
		int sum = 0;
		if (choice1 == JOptionPane.NO_OPTION) {

			for (int i = 0; i <= number1; i++) {
				sum += i;
			}
			JOptionPane.showMessageDialog(null,
					"Sum of all numbers from 0 to selected is: " + sum);
		} else if (choice1 == JOptionPane.YES_OPTION) {

			while (choice1 != JOptionPane.NO_OPTION) {
				sum += number1;
				number1 = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter number?"));
				choice1 = JOptionPane.showConfirmDialog(null,
						"Enter another number?");
				if (number1 == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,
							"Sum of entered numbers is: " + sum);
				}
			}

		} else if (choice1 == JOptionPane.CANCEL_OPTION) {
			System.exit(0);

		}
	}

}