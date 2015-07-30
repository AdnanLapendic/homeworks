package ba.bitcamp.task2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class using GUI to make a little demonstration of changing font style from Italic to Bold to Plain.
 * Class extends JFrame, and using a JLabel, JCheckBox and JButton.   
 * @author LAPA
 *
 */
public class Task2AdjustableFontStyle extends JFrame {

	private static final long serialVersionUID = -3008049119321593781L;

	private JLabel label = new JLabel("Set Font Size");
	private JCheckBox box1 = new JCheckBox("Bold");
	private JCheckBox box2 = new JCheckBox("Italic");
	private JButton button = new JButton("Submit");
	private Font font1 = new Font("SerifSans", Font.PLAIN, 30);

	/**
	 * In constructor we had sat label to use for text example, two check boxes and one button
	 */
	public Task2AdjustableFontStyle() {
		setLayout(new GridLayout(4, 1, 5, 5));
		add(label);
		label.setFont(font1);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(box1);
		add(box2);
		add(button);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box1.addActionListener(new Action());
		box2.addActionListener(new Action());
		button.addActionListener(new Action());
		setVisible(true);

	}

	/**
	 * Private class Action implements ActionListener and it is used to set or change font when checkBox is marked
	 * @author LAPA
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				if(box1.isSelected()){
					label.setFont(new Font("SerifSans", Font.BOLD, 30));
				}else if (box2.isSelected()){
					font1.isItalic();
					label.setFont(new Font("SerifSans", Font.ITALIC, 30));
				}else if(box1.isSelected()&&box2.isSelected()){
					label.setFont(new Font("SerifSans", Font.BOLD+Font.ITALIC, 30));
				}else{
					label.setFont(font1);
				}

			}

		}
	}

	public static void main(String[] args) {
		new Task2AdjustableFontStyle();
	}
}