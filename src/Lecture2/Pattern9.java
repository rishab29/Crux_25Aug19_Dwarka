package Lecture2;

public class Pattern9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int nsp = n;
		int row = 1;
		int value = 10;
		while (row <= n) {
			int csp = 1;
			while (csp <= n - row) {
				System.out.print("  ");
				csp++;
			}

			int col = 1;
			while (col <= row) {
				if (col == row) {
					System.out.print("0 ");
				} else {
					System.out.print(value + " ");
					value++;
				}
				col++;
			}

			value = value - 1;
			col = 1;
			while (col < row) {
				System.out.print(value + " ");
				value--;
				col++;
			}

			System.out.println();
			row++;

		}
	}

}
