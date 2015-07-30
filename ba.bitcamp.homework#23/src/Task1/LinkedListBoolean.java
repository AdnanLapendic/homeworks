package Task1;

/**
 * In this class we have linked list of booleans. Class has all methods needed
 * for adding, removing, printing and other interactions with list.
 * 
 * @author Adnan Lapendic
 *
 */
public class LinkedListBoolean {
	private Node start;

	/**
	 * Constructor
	 */
	public LinkedListBoolean() {
		this.start = null;
	}

	/**
	 * Add new Boolean at the end of list
	 * 
	 * @param b
	 *            - value
	 */
	public void add(Boolean b) {
		Node newNode = new Node(b);
		Node last = getLast();
		if (start == null) {
			start = new Node(b);
		} else {
			last.setNext(newNode);
		}
	}

	/**
	 * Remove first boolean with this value from beginning of list
	 * 
	 * @param b
	 *            - value
	 */
	public void remove(Boolean b) {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.value == b) {
				// if start value is what we want to remove
				// start don't have previous node
				if (start.value == b) {
					start = start.getNext();
					break;
				}
				Node previous = getPrevious(temp);
				previous.setNext(temp.getNext());
			}
			temp = temp.getNext();
		}
	}

	/**
	 * Remove element on selected index in list. If value on that index is not
	 * right method will remove first element from on the right with that value
	 * 
	 * @param index - Index of element
	 * @param b - value
	 */
	public void remove(int index, Boolean b) {
		Node temp = start;
		int counter = 0;
		// if index is 0
		if (index == 0) {
			start = start.getNext();
		} else {
			while (temp.getNext() != null) {
				// remove boolean on index if it has right value
				if (counter == index && temp.value == b) {
					Node previous = getPrevious(temp);
					previous.setNext(temp.getNext());
					// remove next boolean value if it was not
					// right on selected index
				} else if (counter > index && temp.value == b) {
					Node previous = getPrevious(temp);
					previous.setNext(temp.getNext());
				}
				counter++;
				temp = temp.getNext();
			}
		}
	}

	/**
	 * Boolean method which tells does list contains element with this value or not
	 * @param b - value
	 * @return - true or false
	 */
	public boolean contains(Boolean b) {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.value == b) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	/**
	 * Method that tells if list is alternating or not.
	 * @return true or false
	 */
	public boolean isAlternating() {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.value == true && temp.getNext().value == true
					|| temp.value == false && temp.getNext().value == false) {
				return false;
			}
			temp = temp.getNext();
		}
		return true;
	}

	/**
	 * Returns last element in list
	 */
	public Node getLast() {
		Node temp = start;
		if (start == null) {
			return start;
		}
		while (temp.getNext() != null) {

			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * This method finds previous element from selected
	 * @param currrentNode - Element from which we need previous element
	 * @return - previous element form sellected
	 */
	public Node getPrevious(Node currentNode) {
		Node temp = start;
		while (temp.getNext() != currentNode) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Returns size of list
	 */
	public int size() {
		Node temp = start;
		int size = 1;
		while (temp.getNext() != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
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
	 * Inner class Node is used to create nodes or links between elements
	 * @author Adnan Lapendic
	 *
	 */
	class Node {
		private Node next;
		private boolean value;

		/**
		 * Constructor for Node
		 * @param bool - value
		 */
		public Node(boolean bool) {
			this.next = null;
			this.value = bool;
		}

		/**
		 * Returns next node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Sets next node in list
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * Sets value of selected node
		 */
		public void setValue(boolean value) {
			this.value = value;
		}

		/**
		 * toString method
		 */
		public String toString() {
			if (next == null) {
				return String.valueOf(value);
			} else {
				return value + " " + next.toString();
			}
		}
	}

	/**
	 * This main is used to test all methods from this class
	 */
	public static void main(String[] args) {
		LinkedListBoolean list = new LinkedListBoolean();
		list.add(false);
		list.add(true);
		list.add(false);
		list.add(true);
		list.add(false);
		list.add(true);
		list.add(false);

		System.out.println("Printing list");
		System.out.println(list);

		System.out.println("Last element in list");
		System.out.println(list.getLast());

		System.out.println("Previous element");
		System.out.println(list.getPrevious(list.getLast()).value);

		// list.remove(true);
		System.out.println("List after remove() method");
		System.out.println(list);

		System.out.println("List size:" + list.size());
		// list.remove(4, true);
		System.out.println(list);

		System.out.println("Method contains:");
		System.out.println(list.contains(true));

		System.out.println("Is list alternating");
		System.out.println(list.isAlternating());

	}
	
}


