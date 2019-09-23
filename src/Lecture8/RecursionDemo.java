package Lecture8;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countMazePath(2, 2, 0, 0));
		System.out.println(getMazePath(2, 2, 0, 0));
		printMazePath(2, 2, 0, 0, "");

		System.out.println(countMazePathWD(2, 2, 0, 0));
		System.out.println(getMazePathWD(2, 2, 0, 0));
		printMazePathWD(2, 2, 0, 0, "");

		int[][] arr = { { 0, 0, 9, 0 }, { 9, 0, 0, 0 }, { 0, 9, 0, 0 }, { 0, 9, 0, 0 } };
		printMazePathWithhurdle(arr, 3, 3, 0, 0);

		boolean[][] board = new boolean[7][7];
		System.out.println(countNQueens(board, 0));
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

	public static ArrayList<String> getMazePath(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> hresult = getMazePath(er, ec, cr, cc + 1);
		ArrayList<String> vresult = getMazePath(er, ec, cr + 1, cc);
		for (int i = 0; i < hresult.size(); i++) {
			myresult.add("H" + hresult.get(i));
		}
		for (int i = 0; i < vresult.size(); i++) {
			myresult.add("V" + vresult.get(i));
		}

		return myresult;
	}

	public static void printMazePath(int er, int ec, int cr, int cc, String res) {
		if (cr == er && cc == ec) {
			System.out.println(res);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}
		printMazePath(er, ec, cr, cc + 1, res + "H");
		printMazePath(er, ec, cr + 1, cc, res + "V");
	}

	public static int countMazePathWD(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int mycount = 0;
		int hcount = countMazePathWD(er, ec, cr, cc + 1);
		int vcount = countMazePathWD(er, ec, cr + 1, cc);
		int dcount = countMazePathWD(er, ec, cr + 1, cc + 1);
		mycount = hcount + vcount + dcount;
		return mycount;
	}

	public static ArrayList<String> getMazePathWD(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> hresult = getMazePathWD(er, ec, cr, cc + 1);
		ArrayList<String> vresult = getMazePathWD(er, ec, cr + 1, cc);
		ArrayList<String> dresult = getMazePathWD(er, ec, cr + 1, cc + 1);
		for (int i = 0; i < hresult.size(); i++) {
			myresult.add("H" + hresult.get(i));
		}
		for (int i = 0; i < vresult.size(); i++) {
			myresult.add("V" + vresult.get(i));
		}
		for (int i = 0; i < dresult.size(); i++) {
			myresult.add("D" + dresult.get(i));
		}

		return myresult;
	}

	public static void printMazePathWD(int er, int ec, int cr, int cc, String res) {
		if (cr == er && cc == ec) {
			System.out.println(res);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}
		printMazePathWD(er, ec, cr, cc + 1, res + "H");
		printMazePathWD(er, ec, cr + 1, cc, res + "V");
		printMazePathWD(er, ec, cr + 1, cc + 1, res + "D");
	}

	public static void printMazePathWithhurdle(int[][] arr, int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			arr[cr][cc] = 1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("****************************");
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		if (arr[cr][cc] == 9) {
			return;
		}
		arr[cr][cc] = 1;
		printMazePathWithhurdle(arr, er, ec, cr, cc + 1);
		printMazePathWithhurdle(arr, er, ec, cr + 1, cc);
		arr[cr][cc] = 0;

	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

}
