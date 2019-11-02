package Lecture18;

public class Generic_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList<String> l = new LinkedList<>();
//		l.addLast("A");
//		l.addLast("B");
//		l.addLast("C");
//		l.addLast("D");
//		l.addLast("E");
//
//		l.display();
//		System.out.println(l);

		LinkedList<Student> s = new LinkedList<>();
		s.addLast(new Student("A", 10));
		s.addLast(new Student("B", 20));
		s.addLast(new Student("C", 30));
		s.addLast(new Student("D", 40));
		s.addLast(new Student("E", 50));

		// s.display();
		//System.out.println(s);
		Student tf=new Student("C", 100);
		System.out.println(s.find(tf));
		System.out.println(s.find(new Student("C", 100)));
		
		

	}

	public static class Student {
		int rollno;
		String name;

		public Student(String name, int rollno) {
			// TODO Auto-generated constructor stub
			this.rollno = rollno;
			this.name = name;
		}

		public String toString() {
			return "{" + this.name + "-" + this.rollno + "}";
		}

		public boolean equals(Object other) {
			Student s2 = (Student) other;
			return this.name.equals(s2.name);
		}
	}

}
