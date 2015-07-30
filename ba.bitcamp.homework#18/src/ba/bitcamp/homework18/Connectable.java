package ba.bitcamp.homework18;

/**
 * Interface Connectable has three methods connect(Computer), connect (Network) and disconnect;
 * @author adnan.lapendic
 *
 */
public interface Connectable {
	/**
	 * Connect computer on network using link 
	 * @param c
	 */
	public void connect(Computer c);
	/**
	 * Connect on a web page using link
	 * @param n
	 */
	public void connect(Network n);
	
	public void disconnect();
	
	
}