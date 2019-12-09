package Lecture23;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxXor {
	public static class Node {
		Node left;
		Node right;
		ArrayList<Integer> indices;

		Node() {
			this.indices = new ArrayList<>();
		}
	}
	
	public static void insert(int num,Node node,int indexnum) {
		 Node curr=node;
		 for(int i=31;i>=0;i--) {
			 int bit=(num>>i)&1;
			 if(bit==0) {
				 if(curr.left==null) {
					 curr.left=new Node();
				 }
				 curr.indices.add(indexnum);
				 curr=curr.left;
			 }else {
				 if(curr.right==null) {
					 curr.right=new Node();
				 }
				 curr.indices.add(indexnum);
				 curr=curr.right;
			 }
		 }
		 curr.indices.add(indexnum);
	}
	
	public static int maxxor(Node node,int l,int r,int num) {
		Node curr=node;
		int currxor=0;
		for(int i=31;i>=0;i--) {
			int bit=(num>>i)&1;
			if(bit==0) {
				if(curr.right!=null&&bsearch(curr.right.indices, l, r)) {
					currxor=currxor+(int)Math.pow(2, i);
					curr=curr.right;		
				}else {
					curr=curr.left;
				}
			}else {
				if(curr.left!=null&&bsearch(curr.left.indices, l, r)) {
					currxor=currxor+(int)Math.pow(2, i);
					curr=curr.left;		
				}else {
					curr=curr.right;
				}
			}
		}
		return currxor;
	}
	
	private static boolean bsearch(ArrayList<Integer> arr,int l,int r) {
		int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = arr.get(mid);
            if(val>=l && val<=r) {
                return true;
            } else if (val <l) {
                left = mid+1;
            } else if (val >r) {
                right =mid-1;
            }
        }
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int queries = s.nextInt();
		Node head=new Node();
		int indexnum=0;
		for (int i = 1; i <= queries; i++) {
			int qt = s.nextInt();
			if (qt == 0) {
				int num = s.nextInt();
				insert(num,head,indexnum);
				indexnum++;
			} else {
				int left = s.nextInt();
				int right = s.nextInt();
				int num = s.nextInt();
				System.out.println(maxxor(head, left-1, right-1,num));
			}
		}

	}
}
