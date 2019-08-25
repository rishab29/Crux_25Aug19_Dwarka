package Lecture1;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rev = 0;
		int num = 543;
		while (num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		System.out.println(rev);
	}

}
