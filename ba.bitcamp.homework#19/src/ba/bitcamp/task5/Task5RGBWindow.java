package ba.bitcamp.task5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * In this class user can see, make and generate all colors in color specter
 * using only three sliders which represents three colors-red, green and blue
 * 
 * @author LAPA
 *
 */
public class Task5RGBWindow extends JPanel {

	private static final long serialVersionUID = -6547072530759402884L;

	private int red;
	private int green;
	private int blue;
	private JButton click;

	public Task5RGBWindow(int width, int height) {

		initButton(500, 500);

		int sliderHeight = height / 7;
		Dimension sliderDimension = new Dimension(width, sliderHeight);

		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "Red", sliderDimension);

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "Green", sliderDimension);

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "Blue", sliderDimension);

		JLabel redLabel = new JLabel("Red");
		JLabel greenLabel = new JLabel("Green");
		JLabel blueLabel = new JLabel("Blue");

		add(redLabel);
		add(redSlider);
		add(greenLabel);
		add(greenSlider);
		add(blueLabel);
		add(blueSlider);
		redLabel.setForeground(Color.RED);
		greenLabel.setForeground(Color.GREEN);
		blueLabel.setForeground(Color.BLUE);
	}

	/**
	 * Method to add center button on which will appear selected colors
	 * @param width Button width
	 * @param height Button height
	 */
	private void initButton(int width, int height) {
		click = new JButton("Click me");
		click.setPreferredSize(new Dimension(width - 30, height / 2));
		click.setOpaque(true);
		click.setBorderPainted(false);
		click.setFont(new Font("SansSerif", Font.BOLD, 30));
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				String copy = String.format("%d, %d, %d", red, green, blue);
				clip.setContents(new StringSelection(copy), null);

			}
		});
		updateButton();
		add(click);

	}

	/**
	 * Setting sliders on the panel
	 * @param slider - JSlider
	 * @param name - Color name
	 * @param d - dimension
	 */
	private void initSlider(JSlider slider, String name, Dimension d) {
		slider.setName(name);
		slider.setValue(0);
		slider.setPreferredSize(d);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.setOrientation(JSlider.HORIZONTAL);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();
				String name = changed.getName();
				switch (name) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updateButton();

			}
		});
	}

	private void updateButton() {
		click.setBackground(new Color(red, green, blue));
		click.setForeground(new Color(255 - red, 255 - green, 255 - blue));

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		Task5RGBWindow cp = new Task5RGBWindow(500, 500);
		window.add(cp);
		window.setSize(500, 550);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}