package homework.weekend6.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Task1 class is used to create 10 buttons with digits from 0 to 9. Each button
 * can be used only one time. After three buttons are clicked on display will
 * appear three digit number
 * 
 * @author LAPA
 *
 */
public class Task1 extends JFrame {
	private StringBuilder sb = new StringBuilder();
	private static final long serialVersionUID = 1L;
	private JButton[] button = new JButton[10];
	int counter = 0;

	/**
	 * Constructor used to create panel with 10 buttons
	 */
	public Task1() {
		GridLayout panel = new GridLayout(10, 1);
		setLayout(panel);
		setTitle("Task 1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		// panel size
		setSize(300, 700);
		Action listener = new Action();
		// adding buttons with for loop
		for (int i = 0; i < button.length; i++) {
			add(button[i] = new JButton(String.valueOf(i)));
			button[i].addActionListener(listener);
		}

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < button.length; i++) {

				// disable button when clicked
				if (e.getSource() == button[i]) {
					counter++;
					// using StringBuilder to generate number
					sb.append(i);
					button[i].setEnabled(false);
					// printing results
					if (counter == 3) {
						JOptionPane.showMessageDialog(null, sb.toString());
						System.exit(0);
						break;
					}
				}
			}
		}
	}

	/**
	 * Main method used to call and test our methods and classes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Task1();

	}

}
