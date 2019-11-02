package Lecture18;

import Lecture18.Generic_Demo.Student;

public class HashTable<K, V> {
	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}
		
		public String toString() {
			return "{" + this.key + "-" + this.value + "}";
		}
	}

	public static final int DEFAULT_CAPACITY = 10;
	private LinkedList<HTPair>[] bucketArray;
	private int size;

	public HashTable() {
		this(DEFAULT_CAPACITY);
	}

	public HashTable(int capacity) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = this.hashFunction(key);
		HTPair pta=new HTPair(key, value);
		LinkedList<HTPair> bucket=this.bucketArray[bi];
		if(bucket==null) {
			bucket=new LinkedList<>();
			bucket.addLast(pta);
			this.size++;
			this.bucketArray[bi]=bucket;
		}else {
			int findAt=bucket.find(pta);
			if(findAt==-1) {
				bucket.addLast(pta);
				this.size++;
			}else {
				HTPair pair=bucket.getAt(findAt);
				pair.value=value;
			}
			
		}
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}
	
	public void display() {
		for(LinkedList<HTPair> bucket:this.bucketArray) {
			if(bucket!=null&&!bucket.isEmpty()) {
				bucket.display();
			}else {
				System.out.println("NULL");
			}
			System.out.println("*******************************");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
}
