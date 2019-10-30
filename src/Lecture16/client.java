package Lecture16;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BST bst=new BST();
    bst.add(50);
    bst.add(25);
    bst.add(75);
    bst.add(12);
    bst.add(37);
    bst.add(62);
    bst.add(87);
    
    bst.display();
    
    
    System.out.println(bst.max());
    System.out.println(bst.min());
    
    bst.remove(50);
    bst.display();
    
	}

}
