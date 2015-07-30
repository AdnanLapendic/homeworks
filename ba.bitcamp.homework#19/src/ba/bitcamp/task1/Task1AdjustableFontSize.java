package ba.bitcamp.task1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class extends JFrame. It is using GUI to make slider which change font
 * of JLabel.
 * 
 * @author LAPA
 *
 */
public class Task1AdjustableFontSize extends JFrame {

	private static final long serialVersionUID = -7049353800954796820L;
	private JLabel label = new JLabel("BIT Camp");
	private int size = 15;
	private JSlider slider = new JSlider(0, 50, size);

	/**
	 * Constructor for this class is using BorderLayout, JLabel and JSlider
	 */
	public Task1AdjustableFontSize() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		add(slider, BorderLayout.SOUTH);
		slider.addChangeListener(new Slider());
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * This is private class which implements ChangeListener. It is used to set
	 * font size
	 * 
	 * @author LAPA
	 *
	 */
	private class Slider implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == slider) {
				size = slider.getValue();
				label.setFont(new Font("Serif", Font.ITALIC, size));
				slider.setMajorTickSpacing(5);

			}

		}

	}

	public static void main(String[] args) {

		new Task1AdjustableFontSize();
	}

}