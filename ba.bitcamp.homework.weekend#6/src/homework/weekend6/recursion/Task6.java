package homework.weekend6.recursion;

public class Task6 {
	public static void fillArray(int[][] matrix, int x, int y, int value) {
		if (matrix[y].length == x) {
			x = 0;
			y++;
		}

		if (matrix.length == y) {
			return;
		}

		matrix[y][x] = value;

		fillArray(matrix, x + 1, y, value + 1);
	}

	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][5];

		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
