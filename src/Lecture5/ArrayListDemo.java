package Lecture5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.toString();
		System.out.println(list);
		System.out.println(list.size());

		list.add(10);
		System.out.println(list);
		System.out.println(list.size());

		list.add(20);
		System.out.println(list);
		System.out.println(list.size());

		list.add(30);
		System.out.println(list);
		System.out.println(list.size());

		list.add(40);
		System.out.println(list);
		System.out.println(list.size());

		System.out.println(list.get(0));

		System.out.println(list.get(3));
		System.out.println(list.remove(2));

		System.out.println(list);

		System.out.println(list.set(2, 100));
		System.out.println(list);

		list.add(1, 25);
		System.out.println(list);

		int[] arr = { 50, 40, 30, 20, 10, 5 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}

		Collections.sort(list);
		System.out.println(list);

	}

}
