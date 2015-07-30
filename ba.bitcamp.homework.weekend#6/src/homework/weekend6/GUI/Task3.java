package homework.weekend6.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * In this class we can wrote 5 digit number, but we can use only one number
 * from first roe and then use one from second row.
 * 
 * @author LAPA
 *
 */
public class Task3 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton[] button = new JButton[10];
	String s = "";
	int counter = 0;

	/**
	 * Task3 constructor make 10 digit panel.
	 */
	public Task3() {
		GridLayout panel = new GridLayout(2, 5);
		setLayout(panel);
		setTitle("Task 3");
		setVisible(true);
		setSize(400, 200);
		Action listener = new Action();
		for (int i = 0; i < button.length; i++) {
			add(button[i] = new JButton(String.valueOf(i)));
			button[i].addActionListener(listener);
		}
	}

	/**
	 * This class is used to make action listener and add it to buttons.
	 * 
	 * @author LAPA
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < button.length; i++) {
				if (e.getSource() == button[i]) {
					counter++;
					button[i].setEnabled(false);
					s += String.valueOf(i);
					if (counter == 5) {
						// printing results
						char[] arr = new char[counter];
						arr = s.toCharArray();
						JOptionPane.showMessageDialog(null,
								Arrays.toString(arr));
						break;
					}
					if (counter % 2 == 0 && counter != 0) {
						for (int j = 0; j <= 4; j++) {
							// disable row when clicked
							button[j].setEnabled(false);
							for (int j2 = 5; j2 < button.length; j2++) {
								button[j2].setEnabled(true);
							}
						}
					} else if (counter % 2 != 0 && counter != 0) {
						for (int k = 5; k < button.length; k++) {
							// disable row when clicked
							button[k].setEnabled(false);
							for (int k2 = 0; k2 < 5; k2++) {
								button[k2].setEnabled(true);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Task3();
	}
}
