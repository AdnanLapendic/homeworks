package part1.task1to4.stacklist;

import java.util.Random;

/**
 * In this class we had implemented all method needed for working with stack
 * lists...push, pop, getLastNode, getPreviousNode...an many more
 * 
 * @author Adnan.Lapendic
 *
 */
public class StackListString {

	private Node start;

	/**
	 * Constructor
	 */
	public StackListString() {
		start = null;

	}

	/**
	 * This method tell us if list is empty or not
	 * 
	 * @return - true or false
	 */
	public boolean isEmpty() {
		if (start == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method create new node at the end of list
	 * 
	 * @param string
	 *            - Value
	 * @return - Created node
	 */
	public String push(String string) {
		Node temp = start;
		if (start == null) {
			start = new Node(string);
		} else {
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
		}
		return string;
	}

	/**
	 * Delete last node that is added to the list
	 * 
	 * @return - Deleted node
	 */
	public String pop() {
		if (start == null) {
			return "Can't pop, string is empty!";
		} else {
			Node last = getLastNode();
			String value = last.getValue();
			Node prev = getPreviousNode(last);
			prev.next = null;

			return value;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {
		if (start == null) {
			return "Stack is empty!";
		} else {
			return start.toString();
		}
	}

	/**
	 * Method is used when we need last node in list
	 * 
	 * @return - Last node in list
	 */
	public Node getLastNode() {
		if (start == null) {
			return null;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			return temp;
		}
	}

	/**
	 * Method is used when we need previous node from selected one
	 * 
	 * @param nodeInList
	 *            - Selected node in list
	 * @return Previous node from nodeInList
	 */
	public Node getPreviousNode(Node nodeInList) {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.getNext() == nodeInList) {
				return temp;
			} else {
				temp = temp.next;
			}
		}
		return null;

	}

	/**
	 * This method is used when we want to get list size;
	 * 
	 * @return - List size
	 */
	public int length() {
		Node temp = start;
		int length = 0;
		while (temp.getNext() != null) {
			length++;
			temp = temp.getNext();
		}
		return length;
	}

	/**
	 * Method that tells on which index in stack is selected string
	 * 
	 * @param string
	 *            - String that we want to check
	 * @return - Index of string in stack, or -1 if there is no string
	 */
	public int search(String string) {
		Node temp = start;

		for (int i = length(); i > 0; i--) {
			temp = temp.getNext();
			if (temp.getValue().equals(string)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Inner class Node is used to create node in StackList. It has only two
	 * params - String value, and Node next. It has setter, getter and toStrring
	 * method.
	 * 
	 * @author Adnan.Lapendic
	 *
	 */
	public class Node {

		private String value;
		private Node next;

		/**
		 * Node constructor
		 */
		public Node(String string) {
			this.value = string;
			next = null;
		}

		/**
		 * Gets value of node
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Set value of the node
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * Get next node from the list
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Set next node in the list
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * toString method
		 */
		public String toString() {
			if (next == null) {
				return value;
			}
			return value + " " + next.toString();

		}
	}

	public static void main(String[] args) {
		StackListString stack = new StackListString();
		Random rand = new Random();
		// System.out.println(stack.isEmpty());
		long start = System.currentTimeMillis();
		// adding random elements to list
		for (int i = 0; i < 100000; i++) {
			stack.push(rand.nextInt(100) + "");
		}

		// System.out.println(stack.length());
		// System.out.println(stack.search(String.valueOf(10)));
		// System.out.println(stack);
		// System.out.println(stack);

		// deleting all elements from the list
		// for (int i = 1; i < 10000; i++) {
		// stack.pop();
		// }
		// System.out.println(stack.isEmpty());
		// System.out.println(stack);
		// System.out.println(stack.pop());
		// System.out.println(stack.isEmpty());
		// System.out.println(stack.pop());
		// System.out.println(stack.isEmpty());
		// System.out.println(stack);
		// System.out.println();

		System.out.println(System.currentTimeMillis() - start);

	}

}
