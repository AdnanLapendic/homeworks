package Task2;

/**
 * This class was made to help us understand stack. In this case we are using
 * Integers in stack. It has methods push(), pop() and isIncreasnig().
 * 
 * @author Adnan Lapendic
 *
 */
public class UniqueStackInt {
	private Node start;

	/**
	 * Constructor
	 */
	public UniqueStackInt() {
		this.start = null;
	}

	/**
	 * Pushes an element in stack
	 * @param value - value of element
	 * @return - value of element that is added to stack
	 */
	public int push(int value) {

		Node newNode = new Node(value);
		newNode.setNext(start);
		start = newNode;
		return value;
	}

	/**
	 * Deleting first element from stack
	 * @return value of deleted element
	 */
	public int pop() {
		int value = start.getValue();
		start = start.getNext();

		return value;
	}

	/**
	 * This method tells us if stack/list is increasing or not
	 * @return true or  false
	 */
	public boolean isIncreasing() {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.value > temp.getNext().value) {
				return false;
			}
			temp = temp.getNext();
		}
		return true;
	}

	public Node getLast() {
		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniqueStackInt other = (UniqueStackInt) obj;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
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

	class Node {
		private Node next;
		private int value;

		public Node(int value) {
			this.next = null;
			this.value = value;

		}

		/**
		 * Return next element inn stack
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Set value of next element
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 *Return value of current element
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Set value of current element
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * equals method
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		private Object getOuterType() {
			
			return null;
		}

		/**
		 * to String method
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
	 * Main is used for testing
	 */
	public static void main(String[] args) {

		UniqueStackInt stack = new UniqueStackInt();
		for (int i = 0; i < 5; i++) {
			stack.push(i + 2);
		}

		stack.push(3);
		stack.push(4);
		// stack.pop();
		// stack.pop();
		System.out.println(stack);
		System.out.println(stack.isIncreasing());

	}

}

