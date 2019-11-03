package Lecture19;

import Lecture18.Generic_Demo.Student;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      Heap<Integer> heap=new Heap<>();
//      heap.add(35);
//      heap.add(30);
//      heap.add(25);
//      heap.add(20);
//      heap.add(15);
//      heap.add(10);
//      heap.add(5);
//      heap.add(8); 
//      heap.add(12);
//      heap.display();
//      heap.add(45);
//      System.out.println("*******************");
//      heap.display();
//      
//      System.out.println(heap.remove());
//      heap.display();
		
		Heap<Student> heap=new Heap<>();
		heap.add(new Student("A", 300, 7));
		heap.add(new Student("B", 500, 5));
		heap.add(new Student("C", 800, 2));
		heap.add(new Student("D", 600, 4));
		heap.add(new Student("E", 900, 1));
		heap.add(new Student("F", 200, 8));
		heap.add(new Student("G", 700, 3));
		heap.add(new Student("H", 400, 6));
		heap.add(new Student("I", 100, 9));
		
		heap.display();
         
	}
	
	
	public static class Student implements Comparable<Student> {
		int rank;
		String name;
		int marks;

		public Student(String name, int marks,int rank) {
			// TODO Auto-generated constructor stub
			this.rank = rank;
			this.name = name;
			this.marks=marks;
		}

		public String toString() {
			return "{name=" + this.name + ",Marks=" + this.marks + ", rank="+this.rank+"}";
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.rank-o.rank;
		}

		
	}

}
