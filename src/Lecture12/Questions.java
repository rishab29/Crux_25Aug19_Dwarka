package Lecture12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Lecture11.DynamicQueue;

public class Questions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] prices = { 30, 35, 33, 45, 42, 41 };
		int[] ans = StockSpan(prices);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		int[] arr = { 30, 40, 10, 5, 7, 8 };
		nextGreater(arr);

		String str = "{([a+b]+(c+d))}";
		System.out.println(isBalanced(str));

		int[] arr2 = { 8, -1, 3, -4, 2, 7 };

		int k = 2;
		firstNegative(arr2, k);
	}

	public static int[] StockSpan(int[] prices) {
		int[] spans = new int[prices.length];
		spans[0] = 1;

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				spans[i] = i + 1;
			} else {
				spans[i] = i - stack.peek();
			}
			stack.push(i);

		}
		return spans;
	}

	public static void nextGreater(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				int rv = stack.pop();
				System.out.println(rv + "=>" + arr[i]);
			}

			stack.push(arr[i]);

		}

		while (!stack.isEmpty()) {
			int popped = stack.pop();
			System.out.println(popped + "=>" + -1);
		}
	}

	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (str.charAt(i) == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
				} else if (str.charAt(i) == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				} else if (str.charAt(i) == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
				}

			} else {
				// do nothing
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void firstNegative(int[] arr, int k) throws Exception {
		DynamicQueue queue = new DynamicQueue();
		int i;

		for (i = 0; i < k; i++) {
			if (arr[i] < 0) {
				queue.enqueue(i);
			}

		}

		for (; i < arr.length; i++) {
			if (!queue.isEmpty()) {
				System.out.println(arr[queue.front()]);
			} else {
				System.out.println("0");
			}

			while (!queue.isEmpty() && queue.front() <= i - k) {
				queue.dequeue();
			}
			if (arr[i] < 0) {
				queue.enqueue(i);
			}
		}

		if (!queue.isEmpty()) {
			System.out.println(arr[queue.front()]);
		} else {
			System.out.println("0");
		}
	}

}
