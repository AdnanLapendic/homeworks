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
public class Threads {
	static int counter = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());

		System.out.println("First thread.");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nSecond thread.");
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nThird thread");
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This inner static class is used to make Threads. Class implements
	 * Interface Runnable, and has method run() implemented. 
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	public static class MyThread implements Runnable {

		@Override
		public void run() {
			if (counter == 0) {
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				counter++;
			
			} else if (counter == 1) {
				for (int i = 0; i < 4; i++) {
					System.out.println("BitCamp");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				counter++;
			
			} else if (counter == 2) {

				Random rand = new Random();
				int numOfPrinting = 5;
				while (numOfPrinting > 0) {
					int randomNumber = rand.nextInt(6);

					if ((randomNumber) > 0) {
						System.out.println(randomNumber);
						numOfPrinting--;
						try {
							Thread.sleep(700);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
				}

			}

		}
	}
}