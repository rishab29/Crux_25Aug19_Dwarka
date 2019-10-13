package Lecture12;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumCircles {

	static class Circle implements Comparable<Circle> {
		long left_point;
		long right_point;
		
		Circle(long x, long y) {
			this.right_point = x;
			this.left_point = y;
		}

		@Override
		public int compareTo(Circle arg0) {
			// TODO Auto-generated method stub
			if(this.right_point > arg0.right_point) {
				return 1;
			} else {
				return -1;
			}
		}
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Circle arr[] = new Circle[n];
		for(int i=0;i<n;i++) {
			long x = scn.nextLong();
			long r = scn.nextLong();
			arr[i] = new Circle(x+r,x-r);
		}
		Arrays.sort(arr);
		int ans = 1, chosen = 0;
		for(int i=1;i<n;i++) {
			if(arr[i].left_point>=arr[chosen].right_point) {
				ans++;
				chosen = i;
			}
		}
		System.out.println(n-ans);
	}
	

}
