package Lecture2;

public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;

		// prep for 1st row
		int row = 1;
		int nst = 1;
		int value = 1;
		while (row <= n) {
			int cst = 1;
			while (cst <= nst) {
				System.out.print(value);
				cst++;
				value++;
			}

			// prep for next row
			nst++;
			row++;
			System.out.println();
		}
	}

}
