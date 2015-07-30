package part2.task1to4.queues;

import java.util.Arrays;
import java.util.Random;

/**
 * QueueArray class contains array of Doubles. It has all methods needed for
 * working with array as Queue...add(), peek(), poll()...
 * 
 * @author Adnan.Lapendic
 *
 */
public class QueueArray {
	private Double[] array;

	/**
	 * Constructor
	 */
	public QueueArray() {
		this.array = new Double[0];
	}

	/**
	 * This method add one element at the end of array
	 * 
	 * @param value
	 * @return - returns value of add element
	 */
	public Double add(Double value) {
		Double[] temp = new Double[array.length + 1];
		temp = Arrays.copyOf(array, temp.length);
		temp[temp.length - 1] = value;
		array = temp;
		return value;

	}

	/**
	 * Delete first element from array
	 * 
	 * @return array without first element
	 */
	public Double poll() {
		if (array.length == 0) {
			return null;
		}
		Double[] tempArray;
		Double first = array[0];
		tempArray = Arrays.copyOfRange(array, 1, array.length);
		array = tempArray;
		return first;
	}

	/**
	 * This method reveal first element in array
	 */
	public Double peek() {
		if (array.length == 0) {
			return null;
		}
		return array[0];
	}

	/**
	 * Show us the first element in array
	 */
	public Double element() {
		return array[0];
	}

	/**
	 * This method search for free space in array to add Double, if there is no
	 * free space method will expand array by one place
	 * 
	 * @param element
	 *            Element to add in array
	 * @return Value of addedyy
	 */
	public Double offer(Double element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(null)) {
				array[i] = element;
			} else {
				Double[] temp = new Double[array.length + 1];
				temp = Arrays.copyOf(array, temp.length);
				temp[temp.length - 1] = element;
				array = temp;
			}

		}
		return element;

	}

	/**
	 * This method delete first element in array
	 * 
	 * @return Value of deleted element
	 */
	public Double remove() {
		Double[] tempArray;
		Double first = array[0];
		tempArray = Arrays.copyOfRange(array, 1, array.length);
		array = tempArray;
		return first;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Random rand = new Random();
		QueueArray array = new QueueArray();

		// System.out.println(array.add(1.1));
		// System.out.println(array.add(2.2));
		// System.out.println(array.add(3.3));
		// System.out.println(array.add(4.4));
		// System.out.println(array.poll());
		// System.out.println(array.poll());
		// System.out.println(array.peek());

		for (int i = 0; i < 100000; i++) {
			array.add(rand.nextDouble());
		}
		System.out.println("Time: " + (System.currentTimeMillis() - start));
	}

}
