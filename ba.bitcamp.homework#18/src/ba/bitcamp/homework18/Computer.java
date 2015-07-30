package ba.bitcamp.homework18;

import java.util.Arrays;

/**
 * This is abstract class computer. Class has standard toString and equals
 * methods, two constructors, and getters. This class has innerClass MACaddress.
 * 
 * 
 * @author adnan.lapendic
 *
 */
public abstract class Computer {

	private String name;
	private MACaddress address;

	public String getName() {
		return name;
	}

	/**
	 * Empty constructor for Computer
	 */
	public Computer() {
		this.name = "computer";
		this.address = new MACaddress(new char[] { '5', 'F', '3', 'A', 'A',
				'7', '2', '3', '6', 't', 'A', '8' });
	}

	public MACaddress getAddress() {
		return address;
	}

	/**
	 * Constructor for computer.
	 * 
	 * @param name
	 *            Computers name
	 * @param address
	 *            MAC address
	 */
	public Computer(String name, MACaddress address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * This is inner class inside Computer class. It has array of chars,
	 * constructor, toString and equals methods.
	 * 
	 * @author adnan.lapendic
	 *
	 */
	public class MACaddress {
		private char[] name; // 0123456789ab

		public char[] getName() {
			return name;
		}

		/**
		 * Constructor for MAC address
		 * @param name Array of chars
		 */
		public MACaddress(char[] name) {
			this.name = name;
		}

		@Override
		public String toString() {
			String s = "";
			for (int i = 0; i < name.length; i++) {
				if (i % 2 == 0 && i != 0 && i != name.length - 1) {
					s += ":";
				}
				s += name[i];
			}
			return s;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MACaddress other = (MACaddress) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(name, other.name))
				return false;
			return true;
		}

		private Computer getOuterType() {
			return Computer.this;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", address=" + address + "]";
	}
}