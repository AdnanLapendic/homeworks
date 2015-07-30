package ba.bitcamp.homework21;

/**
 * This class was made to test and practice work with Linked list. In this class
 * you can find all methods needed for working with linked lists, and maybe a
 * few more.
 * 
 * @author Adnan.Lapendic
 *
 */
public class LinkedListDouble {

	private Node start;
	private int length = 1;

	public LinkedListDouble() {
		this.start = null;
	}

	/**
	 * This method adds one number at the end of list
	 * 
	 * @param number
	 *            - Number to add in list
	 */
	public void add(double number) {
		Node node = new Node(number);
		if (start == null) {
			start = node;
		} else {
			Node temp = getLast();
			temp.setNext(node);

		}
	}

	/**
	 * This method tells us which element is in the end of list.
	 * 
	 * @return - Last node in the list
	 */
	public Node getLast() {
		Node temp = start;
		while (temp.getNext() != null) {

			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Method that tell us which node comes before selected node. If we select
	 * fourth node, this method will return third node.
	 * 
	 * @param node
	 *            - Selected node
	 * 
	 * @return - Node on first place before selected node
	 */
	public Node getPrevious(Node node) {
		if (node == start) {
			return null;
		}
		Node temp = start;
		while (temp.getNext() != node) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * This method just tells us the length of list
	 * 
	 * @return - int number which represent list length.
	 */
	public int size() {
		Node temp = start;
		while (temp.getNext() != null) {
			length += 1;
			temp = temp.getNext();
		}
		return length;
	}

	/**
	 * Method remove node on selected index.
	 * 
	 * @param index
	 *            - index of element which will be removed
	 */
	public void removeOnIndex(int index) {
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		Node previous = getPrevious(temp);
		previous.setNext(temp.getNext());

	}

	/**
	 * This method just tells us value of one node on selected index.
	 * 
	 * @param index
	 *            - index of node
	 * @return - number which represent value of node
	 */
	public double get(int index) {
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	/**
	 * Method for finding middle element in list. If list don't have middle
	 * element, method will use first element on the left from the middle
	 * 
	 * @return - Middle element in list
	 */
	public Node getMiddle() {
		int size = size() / 2;
		Node temp = start;

		if (size % 2 == 0) {
			for (int i = 1; i < size / 2; i++) {

				temp = temp.getNext();
			}
			return temp;

		} else {
			for (int i = 0; i < ((size) / 2); i++) {
				temp = temp.getNext();
			}
			return temp;
		}
	}

	/**
	 * This method tell us which element is first in list
	 * @return - First node in list
	 */
	public Node getFirst() {

		return start;
	}

	/**
	 * Method for deleting first element from list
	 */
	public void deleteFirst() {
		start = start.getNext();
	}

	/**
	 * Method for deleting last element from the list
	 */
	public void deleteLast() {
		Node temp = getPrevious(getLast());
		temp.setNext(null);
	}

	/**
	 * This method add new node on selected index in list.
	 * @param value - Value of new node
	 * @param index - Place in list where will be made new node
	 */
	public void add(double value, int index) {
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		Node tempPrevious = getPrevious(temp);
		Node newNode = new Node(value);
		tempPrevious.setNext(newNode);
		newNode.setNext(temp);
	}

	/**
	 * toString method
	 */
	public String toString() {
		if (start == null) {
			return "The list is empty!";
		} else {
			return start.toString();
		}
	}

	/**
	 * Main method used to test all implemented methods in this class
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();
		list.add(1.1);
		list.add(2.2);
		list.add(3.3);
		list.add(4.4);
		list.add(5.5);
		list.add(6.6);
		list.add(7.7);
		list.add(8.8);
		list.add(9.9);
		System.out.println(list);
		System.out.println("Size of list is:" + list.size());
		list.removeOnIndex(2);
		System.out.println(list);
		// System.out.println(list.get(2));
		Node middleNode = list.getMiddle();
		System.out.println("The middle element is: " + middleNode.getValue());
		Node firstNode = list.getFirst();
		System.out.println("First element is: " + firstNode.getValue());
		System.out.println("The last element is: " + list.getLast());
		list.deleteFirst();
		System.out.println(list);
		list.deleteLast();
		System.out.println(list);
		list.add(0.0, 4);
		System.out.println(list);

	}
}
