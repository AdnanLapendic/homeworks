package task2;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is used to change any picture to negative. The result will be
 * shown in a small GUI panel.
 * 
 * @author Adnan Lapendic
 *
 */
public class Task2 extends JFrame {

	private static final long serialVersionUID = -7094819882137433748L;
	private static BufferedImage image;
	private JPanel panel;
	private static LinkedBlockingQueue<Runnable> queue;
	private static ArrayList<Worker> workers;

	/**
	 * Constructor for Task2
	 */
	public Task2() {

		queue = new LinkedBlockingQueue<Runnable>();
		workers = new ArrayList<Worker>();
		setSize(1100, 630);
		setTitle("C O O L      S T U F F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Adding picture to panel by using anonymous class an paintComponent
		add(panel = new JPanel() {

			private static final long serialVersionUID = 7326380564338514931L;

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, null);
				repaint();
			}
		});

		setVisible(true);
	}

	/**
	 * This class is used to make threads and add them to LinkedBlockingQueue
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	private static class Worker extends Thread {

		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Runnable r = queue.take();
					r.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This class is used to make jobs for thread by reading picture in pixels
	 * line by line. Every line represent one task for thread
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	private static class Task implements Runnable {
		private int column;

		public Task(int column) {
			this.column = column;
		}

		@Override
		public void run() {

			for (int i = 0; i < image.getWidth(); i++) {

				int pixel = image.getRGB(i, column);
				image.setRGB(i, column, 255 - pixel);
				
				//Setting thread to sleep for one [ms] 
				//just for visual effect
				try {
					Thread.sleep(1);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		//Trying to read image from disk
		try {
			image = ImageIO.read(new File("src/img1.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		new Task2();

		//Adding threads
		for (int i = 0; i < 16; i++) {
			Worker w = new Worker();
			w.start();
			workers.add(w);
		}
		
		//Adding jobs to queue
		for (int i = 0; i < image.getHeight(); i++) {
			queue.add(new Task(i));
		}

		//Sending them to work
		for(Worker w:workers){
			try {
				w.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
