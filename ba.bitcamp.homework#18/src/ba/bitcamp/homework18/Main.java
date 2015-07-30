package ba.bitcamp.homework18;
/**
 * Main class for testing classes and methods
 * @author LAPA
 *
 */
public class Main {

	public static void main(String[] args) {
		Computer c = new Computer() {
		};
		Network n = new Network() {

			@Override
			public void addComputer() {
				// TODO Auto-generated method stub

			}

			@Override
			public void removeComputer() {
				// TODO Auto-generated method stub

			}

		};

		// System.out.println(c.getAddress());

		char[] gg = new char[] { '5', 'F', '3', 'A', 'A', '7', '2', '3', '6',
				't', 'A', '8' };

		Computer.MACaddress cm = c.new MACaddress(gg);

		Client cl = new Client("Name", cm);
		System.out.println(cl);
		// cl.connect(c);
		cl.connect(n);
		System.out.println(cl);
		cl.disconnect();
		System.out.println(cl);
		cl.connect(c);
		System.out.println(cl);
	}

}