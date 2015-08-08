package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;

/**
 * This class is used to make a program for counting letters in any text
 * document. It is using Threads in Producer/Consumer example.
 * 
 * @author Adnan Lapendic
 *
 */
public class Task1 {

	private static BufferedReader reader;
	private static BufferedWriter writer;
	private static LinkedBlockingQueue<Task> queue;
	private static ArrayList<Worker> workers;
	private static char firstLether;
	private static int counter = 0;
	private static Object o = new Object();

	/**
	 * Main is used to test our program
	 */
	public static void main(String[] args) {
		queue = new LinkedBlockingQueue<>();
		workers = new ArrayList<>();
		long start = System.currentTimeMillis();

		try {

			// Finding and remembering first letter in document
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/TLOTR.txt")));
			firstLether = getFirstChar(reader.readLine().toLowerCase());

			// Reading line by line
			while (reader.ready()) {

				String line = reader.readLine().toLowerCase();
				System.out.println(line);
				// Going through every char in every string
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					// If letter is same add 1 to counter
					if (firstLether == c) {
						System.out.println(counter);
						counter++;
					}
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Making Threads/Workers and starting them
		for (int i = 0; i < 8; i++) {
			Worker w = new Worker();
			w.start();
			// adding Threads to ArrayList
			workers.add(w);
		}

		for (Worker w : workers) {

			try {

				w.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("Lether counter: " + counter);

	}

	/**
	 * This class is used to make threads and put them to ArrayList.
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	static class Worker extends Thread {

		@Override
		public void run() {

			while (!queue.isEmpty()) {
				try {

					Task t = queue.take();
					t.run();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * This class implements Runnable, it is used to make jobs for threads It is
	 * using run method to read line by line and putting them to
	 * LinkedBlockingQueue.
	 * 
	 * @author Adnan
	 *
	 */
	static class Task implements Runnable {

		private String line;

		/**
		 * Constructor for class Task
		 */
		public Task(String line) {
			this.line = line;
		}

		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/TLOTR.txt")));
				try {
					while (reader.ready()) {

						synchronized (o) {
							String line = reader.readLine().toLowerCase();
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NullPointerException e1) {

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Method that returns first letter in any text file
	 * 
	 * @param line
	 *            First line in document
	 * @return First letter of first line
	 */
	public static char getFirstChar(String line) {
		char c = line.charAt(0);
		return c;

	}

}
