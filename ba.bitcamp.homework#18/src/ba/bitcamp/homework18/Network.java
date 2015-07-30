package ba.bitcamp.homework18;

import java.util.Arrays;

/**
 * Abstract class Network has two attributes name and computer(Array of
 * Computer), constructor and two abstract methods.
 * 
 * @author adnan.lapendic
 *
 */
abstract class Network {
	protected String name;
	protected Computer[] computers;

	/**
	 * Constructor for Network
	 */
	public Network() {
		name = "BIT Camp network";
		computers = new Computer[0];
	}
	
	
	abstract public void addComputer();

	abstract public void removeComputer();


	@Override
	public String toString() {
		return "Network [name=" + name + ", computers="
				+ Arrays.toString(computers) + "]";
	}
	
	
}