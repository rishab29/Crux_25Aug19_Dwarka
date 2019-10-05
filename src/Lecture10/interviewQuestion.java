package Lecture10;

public class interviewQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] arr = { 3, 4, 2, 7, 6 };

		int xormissing = 0;
		for (int i = 1; i <= n; i++) {
			xormissing = xormissing ^ i;
		}

		for (int i = 0; i < arr.length; i++) {
			xormissing = xormissing ^ arr[i];
		}
		System.out.println("Missing numbers xor " + xormissing);

		int lastsetbit = (xormissing & ~(xormissing - 1));
		System.out.println("Last set bit " + lastsetbit);

		int grp1 = 0, grp2 = 0;

		for (int i = 1; i <= n; i++) {
			if ((i & lastsetbit) == 0) {
				grp1 = grp1 ^ i;
			} else {
				grp2 = grp2 ^ i;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & lastsetbit) == 0) {
				grp1 = grp1 ^ arr[i];
			} else {
				grp2 = grp2 ^ arr[i];
			}
		}

		System.out.println("First Missing number is " + grp1);
		System.out.println("Second Missing number is " + grp2);

	}

}
