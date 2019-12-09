package Lecture23;

import java.util.LinkedList;

public class SegmentTrees {

	private class Node {
		int si;
		int ei;
		int data;
		Node left;
		Node right;
	}

	Node root;

	public SegmentTrees(int[] arr) {
		// TODO Auto-generated constructor stub
		this.root = this.constructTree(arr, 0, arr.length - 1);
	}

	private Node constructTree(int[] arr, int si, int ei) {
		if (si == ei) {
			Node node = new Node();
			node.si = si;
			node.ei = si;
			node.data = arr[si];
			node.left = null;
			node.right = null;
			return node;
		}
		Node node = new Node();
		node.si = si;
		node.ei = ei;
		int mid = (si + ei) / 2;
		node.left = this.constructTree(arr, si, mid);
		node.right = this.constructTree(arr, mid + 1, ei);
		node.data = node.left.data + node.right.data;
		return node;

	}

	public void display() {
		LinkedList<Node> pqueue = new LinkedList<>();
		LinkedList<Node> squeue = new LinkedList<>();

		pqueue.add(this.root);
		while (!pqueue.isEmpty()) {
			Node rv = pqueue.remove();
			System.out.print("[" + rv.si + "-" + rv.ei + "]=" + rv.data + ", ");
			if (rv.left != null) {
				squeue.add(rv.left);
			}

			if (rv.right != null) {
				squeue.add(rv.right);
			}

			if (pqueue.isEmpty()) {
				pqueue = squeue;
				squeue = new LinkedList<>();
				System.out.println("END");
			}
		}
	}

	public int query(int qsi, int qei) {
		return this.query(this.root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		} else if (node.ei < qsi || node.si > qei) {
			return 0;
		} else {
			int left = this.query(node.left, qsi, qei);
			int right = this.query(node.right, qsi, qei);
			return left + right;
		}
	}

	public void update(int index, int data) {
		this.root.data = this.update(this.root, index, data);
	}

	private int update(Node node, int index, int data) {
		if (index >= node.si && index <= node.ei) {
			if (index == node.si && index == node.ei) {
				node.data = data;
			} else {
				int leftdata = this.update(node.left, index, data);
				int rightdata = this.update(node.right, index, data);
				node.data = leftdata + rightdata;
			}
		}

		return node.data;
	}

}
