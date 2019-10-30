package Lecture17;

public class DPDemos {

	public static long start;
	public static long end;

	public static void startAlgo() {
		start = System.currentTimeMillis();
	}

	public static long endAlgo() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 18;
		int[][] strg = new int[n + 1][n + 1];

//		startAlgo();
//		System.out.println(fib(n));
//		System.out.println("Fib normal took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(fibRS(n, strg));
//		System.out.println("FibRS took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(fibIS(n));
//		System.out.println("FibIS took time " + endAlgo());
//		
//		
//		startAlgo();
//		System.out.println(cbp(n, 0));
//		System.out.println("Cbp normal took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(cbpRS(n, 0, strg));
//		System.out.println("CbpRS took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(cbpIS(n, 0));
//		System.out.println("CbpIS normal took time " + endAlgo());
//		

//		startAlgo();
//		System.out.println(countMazePath(n, n, 0, 0));
//		System.out.println("Cmp normal took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(cmpRS(n, n, 0, 0, strg));
//		System.out.println("CbpRS took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(cmpIS(n, n, 0, 0));
//		System.out.println("CmpIS took time " + endAlgo());

		String s1 = "abbgkcnncsskcs", s2 = "agbgcjncjsncjs";
//		startAlgo();
//		System.out.println(lcs(s1, s2));
//		System.out.println("lcs normal took time" + endAlgo());
//
//		startAlgo();
//		System.out.println(lcsI(s1, s2));
//		System.out.println("lcsI took time" + endAlgo());

//		startAlgo();
//		System.out.println(editDistance(s1, s2));
//		System.out.println("ed normal took time " + endAlgo());
//
//		startAlgo();
//		System.out.println(edI(s1, s2));
//		System.out.println("edI took time " + endAlgo());

		int[] arr = { 40,60,20 };
		System.out.println(mixtures(arr, 0, arr.length - 1));

	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);
		int fibn = fnm1 + fnm2;
		return fibn;
	}

	public static int fibRS(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fnm1 = fibRS(n - 1, strg);
		int fnm2 = fibRS(n - 2, strg);
		int fibn = fnm1 + fnm2;

		strg[n] = fibn;
		return fibn;
	}

	public static int fibIS(int n) {
		int[] strg = new int[n + 1];

		// seed
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbp(end, curr + dice);
		}

		return count;
	}

	public static int cbpRS(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbpRS(end, curr + dice, strg);
		}
		strg[curr] = count;

		return count;
	}

	public static int cbpIS(int end, int curr) {
		int[] strg = new int[end + 1];
		// seed

		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			int sum = 0;
			for (int dice = 1; dice <= 6 && dice + i < strg.length; dice++) {
				sum = sum + strg[dice + i];
			}

			strg[i] = sum;
		}

		return strg[curr];
	}

	public static int countMazePath(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int mycount = 0;
		int hcount = countMazePath(er, ec, cr, cc + 1);
		int vcount = countMazePath(er, ec, cr + 1, cc);
		mycount = hcount + vcount;
		return mycount;
	}

	public static int cmpRS(int er, int ec, int cr, int cc, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int mycount = 0;
		int hcount = cmpRS(er, ec, cr, cc + 1, strg);
		int vcount = cmpRS(er, ec, cr + 1, cc, strg);
		mycount = hcount + vcount;
		strg[cr][cc] = mycount;
		return mycount;
	}

	public static int cmpIS(int er, int ec, int cr, int cc) {
		int[][] strg = new int[er + 1][ec + 1];

		// seed
		strg[er][ec] = 1;

		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er || j == ec) {
					strg[i][j] = 1;
				} else {
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
				}
			}
		}

		return strg[cr][cc];

	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			ans = 1 + lcs(ros1, ros2);
		} else {
			int f1 = lcs(s1, ros2);
			int f2 = lcs(ros1, s2);
			ans = Math.max(f1, f2);
		}

		return ans;
	}

	public static int lcsI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		// seed
		strg[s1.length()][s2.length()] = 0;

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() || j == s2.length()) {
					strg[i][j] = 0;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j]);
				}
			}
		}

		return strg[0][0];
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}

		if (s2.length() == 0) {
			return s1.length();
		}

		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (s1.charAt(0) == s2.charAt(0)) {
			ans = editDistance(ros1, ros2);
		} else {
			int f1 = 1 + editDistance(ros1, ros2);// replace
			int f2 = 1 + editDistance(ros1, s2);// addition
			int f3 = 1 + editDistance(s1, ros2);// removal
			ans = Math.min(f1, Math.min(f2, f3));
		}

		return ans;
	}

	public static int edI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		strg[s1.length()][s2.length()] = 0;
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					strg[i][j] = s2.length() - j;
					continue;
				}
				if (j == s2.length()) {
					strg[i][j] = s1.length() - i;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					strg[i][j] = 1 + Math.min(strg[i][j + 1], Math.min(strg[i + 1][j], strg[i + 1][j + 1]));
				}

			}
		}

		return strg[0][0];
	}

	public static int mixtures(int[] arr, int si, int ei) {
		if (ei - si == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = si; i <= ei - 1; i++) {
			int smoke1 = mixtures(arr, si, i);
			int smoke2 = mixtures(arr, i + 1, ei);
			int smoke3 = resColor(arr, si, i) * resColor(arr, i + 1, ei);
			int myans = smoke1 + smoke2 + smoke3;
			if (myans < ans) {
				ans = myans;
			}

		}

		return ans;
	}

	public static int resColor(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum = sum + arr[i];
		}

		return sum % 100;
	}

}
