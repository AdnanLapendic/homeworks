package task2;

import java.util.Random;

/**
 * This class is used to make and test three completely different Threads. First
 * Thread is printing numbers from 1 to 100 every 200[ms]. Second Thread is
 * printing String "BIT Camp" every 1000[ms]. Third Thread is printing random
 * numbers form 1 to 5 every 700[ms].
 * 
 * @author Adnan Lapendic
 *
 */
public class TaskThreads {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// First Thread
		System.out.println("First Thread:");
		MyThread t1 = new MyThread(1, 10);

		// Second Thread
		System.out.println("\nSecond Thread:");
		MyThread t2 = new MyThread("BIT Camp", 4);

		// Third Thread
		System.out.println("\nThird Thread:");
		MyThread t3 = new MyThread(5);
		
		System.out.println("\nEND!");
	}

	/**
	 * This inner static class is used to make Threads. Class implements
	 * Interface Runnable, and has method run() implemented. It has three
	 * different constructors.
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	static class MyThread implements Runnable {

		/**
		 * First Constructor is used to make Thread which prints numbers from
		 * start to end every 200 ms.
		 * 
		 * @param start
		 *            From which number printing starts
		 * @param end
		 *            To which number will be printed
		 */
		@SuppressWarnings("static-access")
		public MyThread(int start, int end) {
			Thread t = new Thread();
			t.start();

			try {
				t.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = start; i <= end; i++) {
				System.out.println(i);

				try {
					t.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * Second Constructor make Thread which print one string as many time as
		 * we want.
		 * 
		 * @param string
		 *            - String for printing
		 * @param numOfPrinting
		 *            - How many time string will be printed
		 */
		@SuppressWarnings("static-access")
		public MyThread(String string, int numOfPrinting) {
			Thread t = new Thread();
			t.start();

			try {
				t.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 1; i <= numOfPrinting; i++) {
				System.out.println(string);

				try {
					t.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * Third Constructor make Thread which prints random numbers from 1 to
		 * 5, as many time as we want
		 * 
		 * @param numOfPrinting
		 *            - How many time random numbers will be printed
		 */
		@SuppressWarnings("static-access")
		public MyThread(int numOfPrinting) {
			Thread t = new Thread();
			t.start();

			try {
				t.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Random rand = new Random();
			while (numOfPrinting > 0) {
				int randNum = rand.nextInt(6);

				if (randNum > 0) {
					System.out.println(randNum);
					numOfPrinting--;
				}
				try {
					t.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {

		}

	}

}
