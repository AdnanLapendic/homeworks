package ba.bitcamp.homework18;

/**
 * Public class BusNetwork represents one network using methods we can add or
 * remove computers.
 * 
 * @author LAPA
 *
 */
public class BusNetwork extends Network implements Functionable {

	/**
	 * Constructor for BusNetwork
	 * 
	 * @param name
	 */
	public BusNetwork(String name) {

	}

	@Override
	public boolean isFunctioning() {
		int counter = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] == null) {
				counter++;
			}
		}

		if (counter >= 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void removeComputer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComputer() {
		// TODO Auto-generated method stub

	}

}
