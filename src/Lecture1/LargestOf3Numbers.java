package Lecture1;

public class LargestOf3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10;
		int c = 5;

//		if (a > b) {
//			if (a > c) {
//				System.out.println("A is Largest");
//			} else {
//				System.out.println("C is Largest");
//			}
//		} else if (b > c) {
//			System.out.println("B is Largest");
//		} else {
//			System.out.println("C is Largest");
//		}

		if (a >= b && a >= c) {
			System.out.println("A is Largest");
		} else {
			if (b >= c && b >= a) {
				System.out.println("B is Largest");
			} else {
				System.out.println("C is Largest");
			}
		}

	}

}
