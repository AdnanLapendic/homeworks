package ba.bitcamp.task3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class is used to make example of one password panel. Correct password is
 * 1234, and correct name is mujo.
 * 
 * @author LAPA
 *
 */
public class Task3Login extends JFrame {

	private static final long serialVersionUID = 3840027026156451543L;
	private JTextField name = new JTextField(20);
	private JLabel labelName = new JLabel("Username");
	private JPasswordField pass = new JPasswordField(20);
	private JLabel labelPass = new JLabel("Password");
	private JPanel panel = new JPanel();
	private String mujo = "Mujo";
	private String one = "1234";

	/**
	 * In constructor we had set panel. On that panel we had set two JLabels for
	 * name and password. Below name label is text field to put name, and below
	 * password label is passwordField to write password.
	 */
	public Task3Login() {
		add(panel);
		panel.add(labelName);
		panel.add(name);
		panel.add(labelPass);
		panel.add(pass);
		name.addActionListener(new Action());
		pass.addActionListener(new Action());
		setSize(300, 300);
		setVisible(true);
	}

	/**
	 * Private class Action implements ActionListener and it is used to set Listeners on JTextField and JPasswordField
	 * @author LAPA
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pass) {
				if ((String.valueOf(pass.getPassword()).equals(one))
						&& name.getText().equals(mujo)) {
					System.exit(0);

				} else if (!(String.valueOf(pass.getPassword()).equals(one))
						|| !name.equals(mujo)) {
					JOptionPane.showMessageDialog(null,
							"Invalid username or password");
				}
			}

		}

	}

	public static void main(String[] args) {

		new Task3Login();
	}

}