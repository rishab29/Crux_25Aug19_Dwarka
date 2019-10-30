package Lecture15;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	int size;

	public BinaryTree() {
		Scanner s = new Scanner(System.in);
		this.root = this.takeInput(s, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int data = s.nextInt();
		Node node = new Node(data, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child for " + node.data);
		choice = s.nextBoolean();

		if (choice) {
			node.left = this.takeInput(s, node, true);
		}

		choice = false;
		System.out.println("Do you have right child for " + node.data);
		choice = s.nextBoolean();

		if (choice) {
			node.right = this.takeInput(s, node, false);
		}

		return node;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}

		System.out.print(node.data);
		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}

		System.out.println();

		if (node.left != null) {
			this.display(node.left);
		}

		if (node.right != null) {
			this.display(node.right);
		}

	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);
		int mysize = lsize + rsize + 1;
		return mysize;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = this.max(node.left);
		int rmax = this.max(node.right);
		int mymax = Math.max(node.data, Math.max(lmax, rmax));
		return mymax;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int lmin = this.min(node.left);
		int rmin = this.min(node.right);
		int mymin = Math.min(node.data, Math.min(lmin, rmin));
		return mymin;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lheight = this.height(node.left);
		int rheight = this.height(node.right);

		int myheight = Math.max(lheight, rheight) + 1;
		return myheight;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		} else if (this.find(node.left, data)) {
			return true;
		} else if (this.find(node.right, data)) {
			return true;
		} else {
			return false;
		}
	}

	public void mirror() {
		this.mirror(this.root);

	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		this.mirror(node.left);
		this.mirror(node.right);
	}

	public void pre() {
		this.pre(this.root);
	}

	private void pre(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		this.pre(node.left);
		this.pre(node.right);
	}

	public void in() {
		this.in(this.root);
	}

	private void in(Node node) {
		if (node == null) {
			return;
		}
		this.in(node.left);
		System.out.print(node.data + " ");
		this.in(node.right);
	}

	public void post() {
		this.post(this.root);
	}

	private void post(Node node) {
		if (node == null) {
			return;
		}
		this.post(node.left);
		this.post(node.right);
		System.out.print(node.data + " ");
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);

		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.print(rv.data + " ");
			if (rv.left != null) {
				queue.add(rv.left);
			}

			if (rv.right != null) {
				queue.add(rv.right);
			}
		}
	}

	public boolean isBst() {
		return this.isBst(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBst(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		} else if (!this.isBst(node.left, min, node.data)) {
			return false;
		} else if (!this.isBst(node.right, node.data, max)) {
			return false;
		} else {
			return true;
		}
	}

	public int sumOfAllLeaf() {
		return this.sumOfAllLeaf(this.root);
	}

	private int sumOfAllLeaf(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {

			return node.data;
		}

		int left = sumOfAllLeaf(node.left);
		int right = sumOfAllLeaf(node.right);
		int mysum = left + right;
		return mysum;
	}

	public void rootToLeafPath() {
		this.rootToLeafPath(this.root, "");
	}

	private void rootToLeafPath(Node node, String osf) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			osf = osf + node.data;
			System.out.println(osf);
			return;
		}

		rootToLeafPath(node.left, osf + node.data + "=>");
		rootToLeafPath(node.right, osf + node.data + "=>");
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		// diametert passes through root
		int f1 = this.height(node.left) + this.height(node.right) + 2;

		int f2 = this.diameter(node.left);

		int f3 = this.diameter(node.right);

		int myans = Math.max(f1, Math.max(f2, f3));
		return myans;
	}

	public int DiaBtr() {
		return this.diaBtr(this.root).diameter;
	}

	private Pair diaBtr(Node node) {

		if (node == null) {
			Pair bp = new Pair(-1, 0);
			return bp;
		}

		Pair lp = this.diaBtr(node.left);
		Pair rp = this.diaBtr(node.right);

		Pair mp = new Pair();
		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
		;

		return mp;
	}

	class Pair {
		int height;
		int diameter;

		public Pair() {
			// TODO Auto-generated constructor stub
		}

		Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

}
