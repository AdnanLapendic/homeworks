package homework.weekend6.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This class is used to create string with given letters. It uses left and
 * right buttons to navigate through letters and Insert button to put letter on
 * display.
 *
 * @author LAPA
 *
 */
public class Task4 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton top = new JButton("Char: A");
	private JButton insert = new JButton("Insert");
	private JButton left = new JButton("<");
	private JButton right = new JButton(">");
	private String s2 = "";
	private JLabel text = new JLabel(s2, SwingConstants.CENTER);
	String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int index = 0;

	/**
	 * Task4 constructor, make layout with 4 buttons and center display
	 */
	public Task4() {
		setLayout(new BorderLayout());
		setTitle("Task4");
		setSize(500, 300);
		// add text to center display
		add(text, BorderLayout.CENTER);
		// adding buttons
		add(top, BorderLayout.NORTH);
		add(insert, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		setVisible(true);
		Action listener = new Action();
		// adding listener
		top.addActionListener(listener);
		insert.addActionListener(listener);
		left.addActionListener(listener);
		right.addActionListener(listener);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// if clicked on left button
			if (e.getSource() == left) {
				index -= 1;
				if (index > 0 && index < s.length()) {
					top.setText("Char: " + s.charAt(index));
				} else if (index < 0) {
					index = 0;
				}
				text.setText(s2.substring(0, index) + "_"
						+ s2.substring(index, s2.length()));

				// if clicked on right button
			} else if (e.getSource() == right) {
				index += 1;
				if (index > 0 && index < s.length()) {
					top.setText("Char: " + s.charAt(index));
				} else if (index > s.length()) {
					index = s.length();
				}
				text.setText(s2.substring(0, index) + "_"
						+ s2.substring(index - 1, s2.length()));

				// if clicked on Insert button
			} else if (e.getSource() == insert) {
				s2 += s.charAt(index);
				text.setText(s2);

			}

		}

	}

	public static void main(String[] args) {
		new Task4();
	}
}
