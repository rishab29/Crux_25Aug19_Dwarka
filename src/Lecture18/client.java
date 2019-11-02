package Lecture18;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> map = new HashTable<>(5);
		map.put("India", 300);
		map.put("Aus", 200);
		map.put("China", 350);
		map.put("Pak", 50);
		map.put("UK", 220);
		map.put("USA", 150);
		
		map.display();
	
	}
}
