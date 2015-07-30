package homework.weekend6.recursion;

/**
 * Class used to create recursion method getPow().
 * 
 * @author LAPA
 *
 */
public class Task5 {

	/**
	 * Method in recursion
	 * 
	 * @param a
	 *            Number
	 * @param b
	 *            How many times is first number multiplied
	 * @return
	 */
	public static double getPower(int a, int b) {
		if (b > 0) {
			if (b == 1) {
				return a;
			}
			if (b == 1 && a < 0 && b % 2 == 0) {
				return a = -1 * a;
			}
			return a * getPower(a, b - 1);

		} else {
			if (b == -1 && a < 0 && b % 2 == 0) {
				return 1 / getPower(a, b);
			}
			return a / getPower(a, -b + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));
	}
}