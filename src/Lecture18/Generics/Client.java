package Lecture18.Generics;

public class Client {

	public static void main(String[] args) {
		RawPair pair1 = new RawPair();

		// set - awesome
		pair1.one = 1;
		pair1.two = "SM";

		// get
		//Integer data = pair1.one;// Problem 1 => no get without typecast
		Integer data = (Integer) pair1.one;
		System.out.println(data);

//		Integer twoData = (Integer) pair1.two;
//		System.out.println(twoData);
		//
		Pair<Integer> pair2 = new Pair<>();
		pair2.one = 1;
		//pair2.one = "SM"; //-- very cool
		pair2.two = 2;

		Integer one = pair2.one;
		System.out.println(one);
//
		Pair2d<Integer, String> pair3 = new Pair2d<>();

		pair3.one = 1;
		pair3.two = "SM";
//
		Pair2d<Pair2d<Integer, String>, Pair2d<String, Integer>> deep = new Pair2d<>();

		deep.one = new Pair2d<>();
		deep.one.one = 1;
		deep.one.two = "SM";

		deep.two = new Pair2d<>();
		deep.two.one = "MS";
		deep.two.two = 2;

	}

}
