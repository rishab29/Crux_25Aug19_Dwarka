package Lecture19;

import java.util.ArrayList;

public class MergeKsortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		ArrayList<Integer> list1 = new ArrayList<>();
		lists.add(list1);
		lists.get(0).add(10);
		lists.get(0).add(20);
		lists.get(0).add(30);
		lists.get(0).add(40);
		lists.get(0).add(50);

		ArrayList<Integer> list2 = new ArrayList<>();
		lists.add(list2);
		lists.get(1).add(5);
		lists.get(1).add(7);
		lists.get(1).add(14);
		lists.get(1).add(35);
		lists.get(1).add(57);

		ArrayList<Integer> list3 = new ArrayList<>();
		lists.add(list3);
		lists.get(2).add(23);
		lists.get(2).add(45);
		lists.get(2).add(49);

		System.out.println(MergeksortedLists(lists));
	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listno;
		int indexno;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.data - o.data;
		}

	}

	public static ArrayList<Integer> MergeksortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();
		Heap<Pair> heap = new Heap<>(true);

		for (int i = 0; i < lists.size(); i++) {
			Pair pta = new Pair();
			pta.data = lists.get(i).get(0);
			pta.indexno = 0;
			pta.listno = i;

			heap.add(pta);
		}

		while (!heap.isEmpty()) {
			Pair rp = heap.remove();

			ans.add(rp.data);
			rp.indexno++;
			if (rp.indexno < lists.get(rp.listno).size()) {
				rp.data = lists.get(rp.listno).get(rp.indexno);
				heap.add(rp);
			}
		}

		return ans;
	}

}
