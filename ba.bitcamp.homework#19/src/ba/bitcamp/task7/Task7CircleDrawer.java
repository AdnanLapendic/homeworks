package ba.bitcamp.task7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is used to draw a circle with simple mouse click. And also has
 * slider which can resize that circle
 * 
 * @author LAPA
 *
 */
public class Task7CircleDrawer extends JFrame {

	private static final long serialVersionUID = 1769690653577998087L;
	private MyPanel panel = new MyPanel();
	private JSlider slider = new JSlider(0, 500);
	private int x;
	private int y;
	private int size;

	/**
	 * Constructor is using BorderLayout. On center is set panel to draw circle,
	 * and on south is set slider
	 */
	public Task7CircleDrawer() {
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		add(slider, BorderLayout.SOUTH);
		panel.addMouseListener(new Mouse());
		slider.addChangeListener(new Change());
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class MyPanel extends JPanel {

		private static final long serialVersionUID = -5939467972888991633L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(x - size / 2, y - size / 2, size, size);
			repaint();
		}
	}

	/**
	 * Class used to implements ChangeListener which is set on slider.
	 * 
	 * @author LAPA
	 *
	 */
	private class Change implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == slider) {
				size = slider.getValue();
			}
		}
	}

	/**
	 * Private class Mouse implements MouseListener, and it is used to set
	 * circle center whit mouse click
	 * 
	 * @author LAPA
	 *
	 */
	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

	public static void main(String[] args) {

		new Task7CircleDrawer();
	}

}