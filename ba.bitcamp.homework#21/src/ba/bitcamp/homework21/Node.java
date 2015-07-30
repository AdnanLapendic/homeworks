package ba.bitcamp.homework21;

/**
 * This class is used to create node which will be added to Linked list. Class
 * has constructor, getters, setters and toString method.
 * 
 * @author Adnan.Lapendic
 *
 */
public class Node {
	private Node next;
	private double value;

	/**
	 * Constructor for node.
	 * @param number - the value of node
	 */
	public Node(double number) {
		this.next = null;
		this.value = number;
	}

	/**
	 * Gets next node in list
	 * @return - next node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * Sets next node in list
	 * @param next - Next node in list
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Gets value of one node in double
	 * @return - value of node
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets value of one node
	 * @param value - Value of node
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * toString method
	 */
	public String toString() {
		if (next == null) {
			return value + "";
		} else {
			return value + ", " + next.toString();
		}
	}
}
