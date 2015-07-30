package ba.bitcamp.task8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * RegisterForm is a class n which is from user asked to enter username and password. 
 * Password must be al least 6 characters long and MUST have at least one number. Username also has to be at least 6 characters long
 * @author LAPA
 *
 */
public class Task8RegisterForm extends JFrame {

	private static final long serialVersionUID = 1544772873246041078L;

	private JPanel panel = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JLabel userName = new JLabel();
	private JLabel pass = new JLabel();
	private JLabel pass2 = new JLabel();
	private JTextField name = new JTextField(20);
	private JPasswordField passField = new JPasswordField(20);
	private JPasswordField passField2 = new JPasswordField(20);
	private JButton clear = new JButton("Clear");
	private JButton submit = new JButton("Submit");

	public Task8RegisterForm() {
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(clear);
		panelSouth.add(submit);
		clear.addActionListener(new Action());
		submit.addActionListener(new Action());
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel.add(userName);
		panel.setBorder(BorderFactory.createTitledBorder("Register"));
		userName.setText("Username;");
		panel.add(name);
		panel.add(pass);
		pass.setText("Password:");
		panel.add(passField);
		panel.add(pass2);
		pass2.setText("Confirm password:");
		panel.add(passField2);

		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clear) {
				name.setText("");
				passField.setText("");
				passField2.setText("");

			} else if (e.getSource() == submit) {
				String pass1 = String.valueOf(passField.getPassword());
				String pass2 = String.valueOf(passField2.getPassword());
				String nameString = name.getText();
				if (pass1.equals(pass2) && pass1.length()>=6) {
					for (int i = 0; i < pass1.length(); i++) {
						if (pass1.charAt(i) >= '0' && pass1.charAt(i) <= '9') {

						} else {
							JOptionPane
									.showMessageDialog(null,
											"Password must contain at least one number");
							break;

						}
					}
					if (nameString.length() >= 6) {

					} else {
						JOptionPane.showMessageDialog(null,
								"Username must have at least 6 leathers");
					}

					JOptionPane.showMessageDialog(null,
							"Thank you for registration");
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect password, password must have min 6 characters");

				}

			}
		}

	}

	public static void main(String[] args) {
		new Task8RegisterForm();

	}

}
