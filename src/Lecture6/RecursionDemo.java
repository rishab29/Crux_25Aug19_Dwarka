package Lecture6;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PD(5);
		// PI(5);
		// PDI(5);

//		PDISkip(5);
//		System.out.println(fact(5));
//		System.out.println(power(2, 5));
//		System.out.println(fib(5));

//		int[] arr = { 9, 11, 14, 17, 116, 150 };
//		System.out.println(isSorted(arr, 0));
		int[] arr = { 1, 3, 3, 8, 3, 4 };
		System.out.println(firstIndex(arr, 0, 13));

		int[] ans = allIndices(arr, 0, 3, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static void PD(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PD(n - 1);
	}

	public static void PI(int n) {
		if (n == 0) {
			return;
		}
		PI(n - 1);
		System.out.println(n);

	}

	public static void PDI(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static void PDISkip(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.println(n);
		}
		PDISkip(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}

	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		int fnm1 = fact(n - 1);
		int fn = n * fnm1;
		return fn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pnm1 = power(x, n - 1);
		int pn = x * pnm1;
		return pn;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		return fibn;
	}

	public static boolean isSorted(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}
		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean restans = isSorted(arr, si + 1);
			return restans;
		}
	}

	public static int firstIndex(int[] arr, int si, int data) {
		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == data) {
			return si;
		} else {
			int restans = firstIndex(arr, si + 1, data);
			return restans;
		}
	}

	public static int lastIndex(int[] arr, int si, int data) {
		if (si == arr.length) {
			return -1;
		}
		int index = lastIndex(arr, si + 1, data);
		if (index != -1) {
			return index;
		} else {
			if (arr[si] == data) {
				return si;
			} else {
				return -1;
			}
		}
	}

	public static int[] allIndices(int[] arr, int si, int data, int count) {
		if (si == arr.length) {
			int[] br = new int[count];
			return br;
		}
		int[] indices = null;
		if (arr[si] == data) {
			indices = allIndices(arr, si + 1, data, count + 1);
		} else {
			indices = allIndices(arr, si + 1, data, count);
		}

		// stack is falling
		if (arr[si] == data) {
			indices[count] = si;
		}

		return indices;
	}

}
