package Lecture22;

public class minStepsToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 30;
		int[] strg = new int[n + 1];
		System.out.println(minsteps(n));
		System.out.println(minstepsRS(n, strg));
		
		System.out.println(minStepsIS(n));
	}

	public static int minsteps(int num) {
		if (num == 1) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		if (num % 3 == 0) {
			int f1 = 1 + minsteps(num / 3);
			ans = Math.min(ans, f1);
		}

		if (num % 2 == 0) {
			int f2 = 1 + minsteps(num / 2);
			ans = Math.min(ans, f2);
		}

		int f3 = 1 + minsteps(num - 1);
		ans = Math.min(ans, f3);
		return ans;
	}

	public static int minstepsRS(int num, int[] strg) {

		if (num == 1) {
			return 0;
		}

		if (strg[num] != 0) {
			return strg[num];
		}
		int ans = Integer.MAX_VALUE;
		if (num % 3 == 0) {
			int f1 = 1 + minsteps(num / 3);
			ans = Math.min(ans, f1);
		}

		if (num % 2 == 0) {
			int f2 = 1 + minsteps(num / 2);
			ans = Math.min(ans, f2);
		}

		int f3 = 1 + minsteps(num - 1);
		ans = Math.min(ans, f3);
		strg[num] = ans;
		return ans;
	}

	public static int minStepsIS(int num) {
		int[] strg = new int[num + 1];

		// seed;
		strg[1] = 0;
		for (int i = 2; i <= num; i++) {
			int f1 = Integer.MAX_VALUE;
			int f2 = Integer.MAX_VALUE;
			int f3 = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				f1 = strg[i / 3];
			}

			if (i % 2 == 0) {
				f2 = strg[i / 2];

			}

			f3 = strg[i - 1];
			strg[i] = Math.min(f1, Math.min(f2, f3)) + 1;
		}
		return strg[num];
	}
}
