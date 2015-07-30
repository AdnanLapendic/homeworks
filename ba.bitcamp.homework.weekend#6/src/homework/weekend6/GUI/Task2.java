package homework.weekend6.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This class is used to create panel with two buttons "Name" and "Last name" ,
 * buttons are used to randomly generate name and last name.
 * 
 * @author LAPA
 *
 */
public class Task2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel name = new JLabel("_ _ _ _ _ _ _ _", SwingConstants.CENTER);
	private JButton firstName = new JButton("First name");
	private JButton lastName = new JButton("Last name");
	private Name fName = new Name();
	private LastName lName = new LastName();

	/**
	 * Constructor used to create layout with two buttons and display in between
	 */
	public Task2() {
		setLayout(new BorderLayout());
		setTitle("Task 2");
		setVisible(true);
		setSize(500, 200);
		Action firstNameListener = new Action();
		Action lastNameListener = new Action();
		// adding listener to buttons
		firstName.addActionListener(firstNameListener);
		lastName.addActionListener(lastNameListener);
		name.setAlignmentX(CENTER_ALIGNMENT);
		// setting text on display
		add(name, BorderLayout.CENTER);
		// adding buttons on left and right side
		add(firstName, BorderLayout.WEST);
		add(lastName, BorderLayout.EAST);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == firstName) {

				// randomly generate name
				Name.generateName();

			} else if (e.getSource() == lastName) {
				// randomly generate last name
				LastName.generateLastName();

			}
			name.setText("Name=" + fName + " " + "Last name=" + lName);
		}

	}

	/**
	 * This class is used to randomly select name from array of names
	 * 
	 * @author LAPA
	 *
	 */
	static class Name {
		static String[] name = { "A", "B", "C", "D" };
		private static String firstName = "";

		protected static String generateName() {
			int i = (int) (Math.random() * name.length);
			firstName = name[i];
			return firstName;
		}

		@Override
		public String toString() {
			return firstName;
		}

	}

	/**
	 * This class is used to randomly select last name from array
	 * 
	 * @author LAPA
	 *
	 */
	private static class LastName {
		static String[] lastName = { "A", "B", "C", "D" };
		private static String surname;

		protected static String generateLastName() {
			int i = (int) (Math.random() * lastName.length);
			surname = lastName[i];
			return surname;
		}

		@Override
		public String toString() {
			return surname;
		}

	}

	/**
	 * Main class used to test methods and classes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Task2();
	}

}
