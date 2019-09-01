package Lecture3;

public class FunctionsDemo {
	static int a = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part1
		// hellofun();

		// Part2
//		hellofun();
//		hellofun();

		// Part3
//		hellofun();
//		hellogun();

		// Part4

//		int p = 1000;
//		int r = 10;
//		int t = 1;
//		// System.out.println(si(p, r, t));
//
//		int ans = si(p, r, t);
//		System.out.println(ans);
//		

		// Part5

//		int a=10;
//		if(a>10) {
//			int b=20;
//			System.out.println(b);
//		}else {
//			int c=30;
//			System.out.println(c);
//			System.out.println(a);
//		}
//		
//		System.out.println(a);
//		System.out.println(c);
//		
//		int i=0;
//		for(i=0;i<5;i++) {
//			System.out.println(i);
//		}
//		
//		
//		System.out.println(i);

		// System.out.println(a);

		// Part6

		int a = 10;
		int b = 20;
		System.out.println(a + "," + b);
		swap(a, b);
		System.out.println(a + "," + b);

	}

	public static void hellofun() {
		hellogun();
		System.out.println("HelloFun");
	}

	public static void hellogun() {
		System.out.println("HelloGun");
	}

	public static int si(int myp, int myr, int myt) {

		int si = (myp * myr * myt) / 100;
		return si;
		// System.out.println(si);

	}

	public static void swap(int a, int b) {
		System.out.println(a + "," + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a + "," + b);
	}

}
