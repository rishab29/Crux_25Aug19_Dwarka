package Lecture13;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();

//       list.addFirst(10);
//       list.display();
//       
//       list.addLast(50);
//       list.display();
//       
//       list.addFirst(5);
//       list.display();
//       
//       list.addAt(2, 20);
//       list.addAt(3, 30);
//       list.addAt(4, 40);
//       
//       list.display();
//       
//       System.out.println(list.getFirst());
//       System.out.println(list.getLast());
//       System.out.println(list.getAt(2));
//       
//       list.removeFirst();
//       list.display();
//       
//       list.removeLast();
//       list.display();
//
//       
//       list.removeAt(2);
//       list.display();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
//		list.addLast(60);
//		list.addLast(70);
//		list.addLast(80);

		list.display();
		list.reverseDR();
		list.display();
//		
//		System.out.println(list.mid());
//		System.out.println(list.KthNodeFromEnd(3));
//		
		// list.createCycle();
		// System.out.println(list.detectCycle());
//
//		list.kReverse(3);
//		list.display();

	}

}
