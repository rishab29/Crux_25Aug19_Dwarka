package Lecture4;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		// System.out.println(arr);

		arr = new int[5];
		System.out.println(arr);
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		arr[0] = 10;
		arr[1] = 20;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int[] d=xyz(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		
	}
	
	public static int[] xyz(int[] arr) {
		System.out.println(arr);
		arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr.length-i;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		return arr;
		
	}

}
