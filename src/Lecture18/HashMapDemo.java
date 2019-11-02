package Lecture18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("India", 300);
		map.put("Aus", 200);
		map.put("China", 350);
		map.put("Pak", 50);
		map.put("UK", 220);
		map.put("USA", 150);
		System.out.println(map);

		map.put("India", 325);
		System.out.println(map);

		System.out.println(map.get("India"));
		System.out.println(map.get("China"));
		System.out.println(map.get("Nepal"));

		System.out.println(map.remove("Pak"));
		System.out.println(map);
		System.out.println("**********************");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}

		System.out.println("**********************");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}

		System.out.println("**********************");
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
			;
		}

		System.out.println(map.containsKey("India"));
		String str = "aaaabbsbddaaaabbbbbbbbbb";

		System.out.println(maxFreq(str));
		int[] one = { 3, 2, 1, 4, 5 };
		int[] two = { 4, 3, 5, 2, 6 };
		System.out.println(getUniqueElements(one, two));

	}

	public static char maxFreq(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (map.containsKey(cc)) {
				int ov = map.get(cc);
				int nv = ov + 1;
				map.put(cc, nv);
			} else {
				map.put(cc, 1);
			}
		}

		// Map is ready
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		int maxfreq = Integer.MIN_VALUE;
		char maxchar = '\0';

		for (Map.Entry<Character, Integer> entry : entries) {
			if (entry.getValue() > maxfreq) {
				maxfreq = entry.getValue();
				maxchar = entry.getKey();
			}
		}

		return maxchar;
	}

	public static ArrayList<Integer> getUniqueElements(int[] one, int[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			map.put(one[i], false);
		}

		for (int i = 0; i < two.length; i++) {
			if (map.containsKey(two[i])) {
				list.add(two[i]);
			}
		}

		return list;
	}

}
