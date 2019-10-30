package Lecture15;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 50 true 25 true 12 false false true 87 true 46 false false false true 75 true
		// 64 false false true 39 false false
		BinaryTree tree = new BinaryTree();
		tree.display();

		System.out.println(tree.size2());
		System.out.println(tree.max());
		System.out.println(tree.min());
		System.out.println(tree.height());

		System.out.println(tree.find(7));
//		tree.mirror();
//		tree.display();

		System.out.println("pre:");
		tree.pre();
		System.out.println();

		System.out.println("in:");
		tree.in();
		System.out.println();

		System.out.println("post:");
		tree.post();
		System.out.println();

		tree.levelOrder();
		System.out.println(tree.isBst());
		System.out.println(tree.sumOfAllLeaf());
		 tree.rootToLeafPath();
		 
		 
		 System.out.println(tree.diameter());
		 
		 System.out.println(tree.DiaBtr());

	}

}
