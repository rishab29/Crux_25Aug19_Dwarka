package Lecture2;

public class Pattern8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int row = 1;
		int nsp = n - 1;

		while (row <= n) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			int val = row;
			int cst = 1;
			while (cst <= row) {
				System.out.print(val);
				val++;
				cst++;
			}

			val = val - 2;
			cst = 1;
			while (cst < row) {
				System.out.print(val);
				val--;
				cst++;
			}

			row++;
			System.out.println();
			nsp--;
		}
	}

}
