package part2.task1to4.queues;

import java.util.Random;

/**
 * This class contains a list of Nodes. Class has all methods needed for work.
 * Main characteristic of this class is that all its methods are made like in
 * Queue...pool(), peak(), add()..
 * 
 * @author Adnan.Lapendic
 *
 */
public class QueueList {
	private Node start;
	private Node finish;

	public QueueList() {
		start = null;
		finish = null;
	}

	/**
	 * Add new element at the end of array
	 * 
	 * @param value
	 *            - Node value
	 * @return true
	 */
	public boolean add(Double value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			finish = n;
			start.next = n;
		} else {
			finish.next = n;
			finish = n;
		}
		return true;
	}

	/**
	 * Remove first element from list.
	 */
	public Double poll() {
		try {
			Double tmp = start.value;
			start = start.next;
			return tmp;
		} catch (NullPointerException ex) {
			return null;
		}
	}

	/**
	 * With this method we can see first element in list
	 * 
	 * @return Value of the first element
	 */
	public Double peek() {
		if (start == null) {
			return null;
		}

		return start.value;
	}

	/**
	 * With this method we can see last element in list
	 * 
	 * @return Value of the last element
	 */
	public Double peekLast() {
		if (finish == null) {
			return null;
		}

		return finish.value;
	}

	/**
	 * toString method
	 */
	public String toString() {
		if (start == null) {
			return "List is empty!";
		} else {
			return start.toString();
		}
	}

	/**
	 * Private class Node is used to create nodes in list. It has Double value,
	 * Node prev and Node next.
	 * 
	 * @author Adnan.Lapendic
	 *
	 */
	private class Node {
		Double value;
		Node next;

		/**
		 * Constructor for Node
		 * 
		 * @param value
		 *            - Double value of Node
		 */
		public Node(Double value) {
			this.value = value;

		}

		/**
		 * toString method
		 */
		public String toString() {
			if (next == null) {
				return String.valueOf(value);
			} else {
				return String.valueOf(value) + "|" + next.toString();
			}
		}

	}

	public static void main(String[] args) {

		QueueList qList = new QueueList();
		Random rand = new Random();
		long start = System.currentTimeMillis();

		// System.out.println(qList.peek());
		// System.out.println(qList.add(1.1));
		// System.out.println(qList.add(2.2));
		// System.out.println(qList.add(3.3));
		// System.out.println(qList.peek());
		// System.out.println(qList.peekLast());
		// System.out.println(qList.poll());
		// System.out.println(qList.poll());
		// System.out.println(qList);

		for (int i = 0; i < 100000; i++) {
			qList.add(rand.nextDouble());
		}

		System.out.println("Time:" + (System.currentTimeMillis() - start));

	}
}
