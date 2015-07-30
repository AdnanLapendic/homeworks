package part1.task1to4.stacklist;

import java.util.Arrays;
import java.util.Random;

/**
 * Class StackListArray contains an array of strings. It has methods that are
 * made to use array as stack...push, pop, peek, isEmpty...
 * 
 * @author Adnan.Lapendic
 *
 */
public class StackListArray {
	private String[] array;

	/**
	 * Constructor
	 */
	public StackListArray() {
		this.array = new String[0];
	}

	/**
	 * This method tells us is an array empty or note.
	 * 
	 * @param array
	 *            - Array
	 * @return - true or false
	 */
	public boolean isEmpty(String[] array) {
		return array.length == 0;

	}

	/**
	 * This method return an array of Strings
	 */
	public String[] getArray() {
		return array;

	}

	/**
	 * This method first expands an array by one place and put String on that
	 * last place.
	 * 
	 * @param string
	 *            - String
	 * @return - String that had been added in array
	 */
	public String push(String string) {
		String[] temp = new String[array.length + 1];
		temp = Arrays.copyOf(array, temp.length);
		temp[temp.length - 1] = string;
		array = temp;
		return string;

	}

	/**
	 * Method decrease length of an array by one place, and delete the last
	 * element
	 * 
	 * @return - An array of strings without last element
	 */
	public String pop() {
		String[] temp = new String[array.length - 1];
		temp = Arrays.copyOf(array, temp.length);
		array = temp;
		return array[array.length - 1];

	}

	/**
	 * This method just show us the last element in array.
	 * 
	 * @return - The last element
	 */
	public String peek() {
		return array[array.length - 1];

	}

	/**
	 * Method that tells on which index in stack is selected string
	 * 
	 * @param string
	 *            - String that we want to check
	 * @return - Index of string in stack, or -1 if there is no string
	 */
	public int search(String string) {
		for (int i = array.length - 1; i > 0; i--) {
			if (array[i].equals(string)) {
				return array.length - i;
			}
		}
		return -1;
	}

	/**
	 * toString
	 */
	public String toString() {
		return Arrays.toString(array);

	}

	public static void main(String[] args) {
		StackListArray stack = new StackListArray();
		// System.out.println(stack.isEmpty(stack.getArray()));
		// stack.push("String");
		// System.out.println(stack.isEmpty(stack.getArray()));
		// stack.push("String2");
		// stack.push("String3");
		// stack.pop();
		// System.out.println(stack.toString());
		// System.out.println(stack.peek());
		// System.out.println(Arrays.toString(stack.getArray()));

		Random rand = new Random();
		long start = System.currentTimeMillis();
		// adding random numbers to array
		for (int i = 0; i < 100000; i++) {
			stack.push(rand.nextInt(100) + "");
		}
		// System.out.println(stack.search(String.valueOf(10)));

		// deleting all numbers from array
		// for (int i = 1; i < 10000; i++) {
		// stack.pop();
		// }
		System.out.println("Time in milliseconds needed to add 100000 random numbers in Linked lis : "
				+ (System.currentTimeMillis() - start));
		// System.out.println(stack);

	}

}
