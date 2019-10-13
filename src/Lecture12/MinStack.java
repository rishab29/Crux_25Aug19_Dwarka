package Lecture12;

import Lecture11.DynamicStack;

public class MinStack {
	DynamicStack stack;
	DynamicStack minstack;

	public MinStack() throws Exception {
		this.stack = new DynamicStack();
		this.minstack = new DynamicStack();
	}

	public int size() {
		return stack.size();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void push(int element) throws Exception {
		if (stack.size() == 0) {
			stack.push(element);
			minstack.push(element);
		} else {
			if (element <= minstack.top()) {
				minstack.push(element);
			}
			stack.push(element);
		}
	}

	public int pop() throws Exception {
		if (stack.top() == minstack.top()) {
			stack.pop();
			return minstack.pop();
		} else {
			return stack.pop();
		}
	}

	public int getMinimum() throws Exception {
		return minstack.top();
	}

	public int top() throws Exception {
		return stack.top();
	}

	public void display() {
		stack.display();
	}
}
