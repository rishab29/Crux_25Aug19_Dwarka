package Lecture18;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> map = new HashTable<>(4);
		map.put("India", 300);
		map.put("Aus", 200);
		map.display();
		map.put("China", 350);
		map.display();
//		map.put("Pak", 50);
//		map.display();
//		map.put("UK", 220);
//		map.display();
//		map.put("USA", 150);
//		map.display();
//		map.put("India",325);
//		map.display();
//		
//		System.out.println(map.get("India"));
//		System.out.println(map.get("USA"));
//		System.out.println(map.get("Nepal"));
//		
//		System.out.println(map.remove("Pak"));
//		map.display();
	
	}
}
