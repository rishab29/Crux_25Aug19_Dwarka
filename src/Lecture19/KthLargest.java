package Lecture19;

import java.util.Arrays;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 3, 2, 11, 43, 12, 5, 13, 50 };
		//System.out.println(Sol1(arr,4));
		//System.out.println(Sol2(arr,4));
		System.out.println(Sol3(arr,4));
	}
	
	//It works in nlogn time
	public static int Sol1(Integer[] arr,int k) {
		Arrays.sort(arr);
		return arr[k];
	}
	 //It is working in n+klogn but can go in nlogn
	public static int Sol2(Integer[] arr,int k) {
		Heap<Integer> heap = new Heap<>(false, arr);
		for(int i=1;i<=k-1;i++) {
			heap.remove();
		}
		return heap.getHP();
	}
	
	public static int Sol3(Integer[] arr,int k) {
		int i=0;
		Integer[] arr2=new Integer[k];
		for(i=0;i<k;i++) {
			arr2[i]=arr[i];
		}
		
		Heap<Integer> heap = new Heap<>(true, arr2);
		for(;i<arr.length;i++) {
			if(arr[i]>heap.getHP()) {
				heap.remove();
				heap.add(arr[i]);
			}
		}

		
		return heap.getHP();
		
		
		
		
	}
	
	

}
