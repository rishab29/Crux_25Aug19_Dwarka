package Lecture7;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(moveAllXAtEnd("abxxdfxxgxxpqrx"));
		System.out.println(getSS("abc"));
		System.out.println(getPermutations("abc"));
		System.out.println(getKeypadCodes("12"));
		System.out.println(getBoardPath(10, 0));

		printSS("abc", "");
		System.out.println("*******************");
		printPermutations("abc", "");
	}

	public static String moveAllXAtEnd(String str) {
		if (str.length() == 0) {
			return "";
		}
		String ans = "";
		if (str.charAt(0) == 'x') {
			String restAns = moveAllXAtEnd(str.substring(1));
			ans = restAns + 'x';
		} else {
			String restAns = moveAllXAtEnd(str.substring(1));
			ans = str.charAt(0) + restAns;
		}

		return ans;
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getSS(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myResult.add(recResult.get(i));
			myResult.add(cc + recResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getPermutations(ros);
		for (int i = 0; i < recResult.size(); i++) {
			String recString = recResult.get(i);
			for (int j = 0; j <= recString.length(); j++) {
				String mystring = recString.substring(0, j) + cc + recString.substring(j);
				myResult.add(mystring);
			}
		}

		return myResult;
	}

	public static ArrayList<String> getKeypadCodes(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getKeypadCodes(ros);
		String mycodes = codes(cc);
		for (int i = 0; i < mycodes.length(); i++) {
			for (int j = 0; j < recResult.size(); j++) {
				myResult.add(mycodes.charAt(i) + recResult.get(j));
			}
		}
		return myResult;
	}

	public static String codes(char c) {
		if (c == '1') {
			return "abc";
		} else if (c == '2') {
			return "def";
		} else if (c == '3') {
			return "ghi";
		} else if (c == '4') {
			return "jkl";
		} else if (c == '5') {
			return "mno";
		} else if (c == '6') {
			return "pqr";
		} else if (c == '7') {
			return "stu";
		} else if (c == '8') {
			return "vwx";
		} else if (c == '9') {
			return "yz";
		} else {
			return "";
		}
	}

	public static ArrayList<String> getBoardPath(int end, int curr) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recresult = null;
		for (int dice = 1; dice <= 6; dice++) {
			recresult = getBoardPath(end, curr + dice);
			for (int j = 0; j < recresult.size(); j++) {
				myResult.add(dice + recresult.get(j));
			}
		}

		return myResult;
	}

	public static void printSS(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, res);
		printSS(ros, res + cc);
	}

	public static void printPermutations(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, res + cc);
		}
	}

}
