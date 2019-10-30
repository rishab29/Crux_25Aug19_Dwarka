package Lecture13and14;

public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.size() == 0) {
			this.tail = node;
		}

		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}

		return temp;
	}

	public void addAt(int index, int data) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(index - 1);
			Node node = new Node(data, nm1.next);
			nm1.next = node;
			this.size++;
		}

	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		return this.getNodeAt(index).data;
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		int rv = this.head.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return rv;
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		int rv = this.tail.data;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node nm1 = this.getNodeAt(this.size - 2);
			nm1.next = null;
			this.tail = nm1;
		}

		this.size--;
		return rv;
	}

	public int removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			return this.removeFirst();
		} else if (index == this.size - 1) {
			return this.removeLast();
		} else {
			Node rv = this.getNodeAt(index);
			Node nm1 = this.getNodeAt(index - 1);
			nm1.next = nm1.next.next;
			this.size--;
			return rv.data;
		}

	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}

		System.out.println("END");
	}

	public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;

		while (left <= right) {
			Node l = this.getNodeAt(left);
			Node r = this.getNodeAt(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tprev = prev;
			Node tcurr = curr;
			prev = curr;
			curr = curr.next;
			tcurr.next = tprev;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		this.reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	private void reversePR(Node node) {
		if (node == this.tail) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}

	public void reverseDR() {
		HeapMover hm = new HeapMover(this.head);
		this.reverseDR(hm, this.head, 0);

	}

	private void reverseDR(HeapMover hm, Node right, int level) {

		if (right == null) {
			return;
		}
		reverseDR(hm, right.next, level + 1);
		if (level >= this.size() / 2) {
			int temp = hm.node.data;
			hm.node.data = right.data;
			right.data = temp;
			hm.node = hm.node.next;
		}
	}

	public class HeapMover {
		Node node;

		public HeapMover(Node node) {
			// TODO Auto-generated constructor stub
			this.node = node;
		}
	}

	public int mid() {
		return this.getmidNode().data;
	}

	private Node getmidNode() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public int KthNodeFromEnd(int k) {

		Node slow = this.head;
		Node fast = this.head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public void createCycle() throws Exception {
		Node temp = this.getNodeAt(3);
		this.tail.next = temp;
	}

	public boolean detectCycle() {
		Node slow = this.head;
		Node fast = this.head;

		while (slow != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public void kReverse(int k) throws Exception {
		LinkedList curr = new LinkedList(), prev = null;
		while (!this.isEmpty()) {
			if (this.size < k) {
				for (int i = 0; i < k && !this.isEmpty(); i++) {
					curr.addLast(this.removeFirst());
				}
			} else {
				for (int i = 0; i < k && !this.isEmpty(); i++) {
					curr.addFirst(this.removeFirst());
				}
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = prev.size + curr.size;
			}

			curr = new LinkedList();
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

}
