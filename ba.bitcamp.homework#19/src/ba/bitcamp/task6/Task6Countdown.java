package ba.bitcamp.task6;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Task6Contown is a simple class in which is user asked to enter one number.
 * After that countdown starts to 0
 * 
 * @author LAPA
 *
 */
public class Task6Countdown extends JFrame {

	private static final long serialVersionUID = 3814350248483041481L;
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JLabel label = new JLabel("Time");
	private JTextField field = new JTextField(10);
	private JButton button = new JButton("Start");
	private Timer t = new Timer(1000, new Action());
	private int sec;

	/**
	 * Countdown constructor is setting JPanel. On panel is added JLabel which
	 * will represent countdown, and JButton to start.
	 */
	public Task6Countdown() {
		setLayout(new GridLayout(2, 1, 5, 5));
		add(panel);
		add(panel2);

		panel2.add(label);
		label.setFont(new Font("SansSerif", Font.BOLD, 30));
		panel.add(field);
		panel.add(button);
		button.addActionListener(new Action());
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * this private class is used to connect timer with label. Label will change
	 * every second and that will represent countdown
	 * 
	 * @author LAPA
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				sec = Integer.parseInt(field.getText());
				t.start();
			} else if (e.getSource() == t) {
				label.setText(sec + "");
				sec--;
			}

		}

	}

	public static void main(String[] args) {
		new Task6Countdown();
	}

}