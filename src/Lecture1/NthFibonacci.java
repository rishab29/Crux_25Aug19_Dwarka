package Lecture1;

public class NthFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;

		int fn = 0, sn = 1;
		int counter = 0;
		while (counter < n) {
			int next = fn + sn;
			fn = sn;
			sn = next;
			counter++;
		}
		System.out.println(fn);
	}

}
