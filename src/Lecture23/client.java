package Lecture23;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 8, 7, 6, -2, -8, 4, 9 };
		SegmentTrees tree = new SegmentTrees(arr);
		tree.display();
		
		System.out.println(tree.query(2, 6));
		tree.update(3,3);
		System.out.println(tree.query(2, 6));
	}

}
