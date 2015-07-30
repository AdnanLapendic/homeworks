package Task3;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Class is used to practice working with iterator. In this class Task is solved
 * in two ways...with for loop and Iterator.
 * 
 * @author Adnan Lapendic
 *
 */
public class ListOfNumbers {

	/*
	 * This task is done first with for loops and then with List iterator.
	 */
	public static void main(String[] args) {
		int sum = 0;
		int counter = 0;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> list3 = new LinkedList<>();

		/*
		 * Adding elements in list. Summ of every two elements makes a third one
		 * in list.
		 */
		for (int i = 0; i < 10; i++) {
			int value = i + 2;
			counter++;
			sum += value;
			list.add(value);
			if (counter == 2) {
				list.add(sum);
				counter = 0;
				sum = 0;
			}
		}
		System.out.println("List after adding third elements: " + list);

		/*
		 * This is second case when we make third element by like a sum of first
		 * two elements
		 */

		for (int i = 0; i < 10; i++) {
			int value = i + 2;
			counter++;
			sum += value;
			if (counter == 2) {
				list2.add(sum);
				counter = 0;
				sum = 0;
			}
		}
		System.out.println("List after removing every first and second: " + list2);

		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		list3.add(8);
		list3.add(9);
		list3.add(10);
		list3.add(11);
		System.out.println("List3 original : " + list3);

		ListIterator<Integer> it = list3.listIterator();
		while (it.hasNext()) {
			int tmp = it.next();
			if (it.hasNext()) {
				it.remove();
				tmp += it.next();
				it.set(tmp);
			}
		}
		System.out.println("List3 after iterator: " + list3);

	}
}
