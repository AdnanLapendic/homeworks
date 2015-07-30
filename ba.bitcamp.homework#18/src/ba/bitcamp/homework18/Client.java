package ba.bitcamp.homework18;

import ba.bitcamp.homework18.Computer.MACaddress;

/**
 * Class represents one client or one computer. 
 * @author LAPA
 *
 */
public class Client implements Connectable {
	private Computer computer;
	private Network network;
	private String name;

	/**
	 * Client constructor
	 * @param name Client name
	 * @param address MAC address
	 */
	public Client(String name, MACaddress address) {
		this.name = name;
	}

	@Override
	public void connect(Computer c) {
		if (computer == null && network == null) {
			computer = c;
		} else {
			throw new NullPointerException("Computer can't connect.");
		}
	}

	@Override
	public void connect(Network n) {
		if (computer == null && network == null) {
			network = n;
		} else {
			throw new NullPointerException("Computer can't connect");
		}
	}

	@Override
	public void disconnect() {
		network = null;
		computer = null;
	}

	public Computer getComputer() {
		return computer;
	}

	public Network getNetwork() {
		return network;
	}

	@Override
	public String toString() {
		return "Client [computer=" + computer + ", network=" + network
				+ ", name=" + name + "]";
	}

}

