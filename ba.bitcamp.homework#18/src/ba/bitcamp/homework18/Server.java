package ba.bitcamp.homework18;

import ba.bitcamp.homework18.Computer.MACaddress;

/**
 * This class represent server. It has Server constructor, final int
 * MAX_NUM_OF_COMPUTERS which is max number of computers that can connect to
 * server. It also has numOfComputers,name and address..and standard methods
 * toString and equals.
 * 
 * @author adnan.lapendic
 *
 */
public class Server {
	public static final int MAX_NUM_OF_COMPUTERS = 10;
	private int numOfComputers;
	private String name;
	MACaddress address;

	/**
	 * Server constructor
	 * @param name Server name
	 * @param address MAC address
	 * @param numOfComputers Number of currently connected computers
	 */
	public Server(String name, MACaddress address, int numOfComputers) {
		this.name = name;
		this.address = address;
		this.numOfComputers = numOfComputers;
	}

	public int getNumOfComputers() {
		return numOfComputers;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (numOfComputers != other.numOfComputers)
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
		return "Server [maxNumOfComputers=" + numOfComputers + ", name=" + name
				+ ", address=" + address + "]";
	}

}