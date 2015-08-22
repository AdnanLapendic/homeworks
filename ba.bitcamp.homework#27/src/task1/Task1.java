package task1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class is used to make a program for counting letters in any text
 * document. It is using Threads in Producer/Consumer example.
 * 
 * @author Adnan Lapendic
 *
 */
public class Task1 {

	private static BufferedReader reader;
	private static LinkedBlockingQueue<Task> queue;
	private static ArrayList<Worker> workers;
	private static char firstLetter;
	private static int counter = 0;
	private static Object o = new Object();

	/**
	 * Main is used to test our program
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {
		queue = new LinkedBlockingQueue<>();
		workers = new ArrayList<>();
		long start = System.currentTimeMillis();

		try {
			// Finding and remembering first letter in document
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/TLOTR.txt")));
			firstLetter = reader.readLine().toLowerCase().charAt(0);
			System.out.println("First letter in text=" + firstLetter);

			// Reading line by line
			while (reader.ready()) {

				String line = reader.readLine().toLowerCase();
				queue.add(new Task(line));
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
			System.out.println("Letter counter: " + counter);
			
			reader.close();

		} catch (FileNotFoundException e1) {
			System.out.println("Could not open file. Check if file exist, or check file path");
	
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
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

					Runnable r = queue.take();
					r.run();

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
			// Going through every char in every string
			for (int i = 0; i < line.length() - 1; i++) {
				// if letters are same increase counter by one
				if (firstLetter == line.charAt(i)) {
					synchronized (o) {
						System.out.println(counter);
						counter++;
					}
				}
			}
		}
	}
}
