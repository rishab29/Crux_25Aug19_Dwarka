package Lecture7;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(moveAllXAtEnd("abxxdfxxgxxpqrx"));
		System.out.println(getSS("abc"));
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
	
	public static ArrayList<String> getPermutations(String str){
		
	}
	
	public static ArrayList<String> getKeypadCodes(String str){
		
	}
	
	public String codes(char c) {
		if(c=='1') {
			return "abc";
		}else if(c=='2') {
			return "def";
		}else if(c=='3') {
			return "ghi";
		}else if(c=='4') {
			return "jkl";
		}else if(c=='5') {
			return "mno";
		}else if(c=='6') {
			return "pqr";
		}else if(c=='7') {
			return "stu";
		}else if(c=='8') {
			return "vwx";
		}else if(c=='9') {
			return "yz";
		}
	}
	
	public static ArrayList<String> getBoardPath(int end,int curr){
		
	}

}
