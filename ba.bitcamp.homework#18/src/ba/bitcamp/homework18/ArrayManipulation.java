package ba.bitcamp.homework18;

/**
 * ArrayManipulation is class representing network. It has axtendArray() and
 * shtinkArray() methods
 * 
 * @author LAPA
 *
 */
public class ArrayManipulation {

	/**
	 * Methods that extend array of computers by one
	 * @param c
	 */
	public static void extendArray(Computer[] c) {
		Computer[] comp = new Computer[c.length + 1];
		for (int i = 0; i < comp.length; i++) {
			if (i == comp.length - 1) {
				comp[i] = null;
			}
			c = comp;
		}
	}

	/**
	 * Method that shrink array by one computer
	 * @param c computer
	 * @param index
	 */
	public static void shrinkArray(Computer[] c, int index) {
		Computer[] comp = new Computer[c.length - 1];
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			if (i == index) {
				j++;
			} else {
				comp[i] = c[j];
				j++;
			}
			c = comp;
		}
	}
}
