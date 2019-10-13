package Lecture12;


public class Client {
    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();

        minStack.push(3);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(2);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(5);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(6);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(4);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(1);
        System.out.println(minStack.getMinimum());
        minStack.display();
        minStack.push(8);
        System.out.println(minStack.getMinimum());
        minStack.display();


//        while (!minStack.isEmpty()) {
//            int x = minStack.pop();
//            System.out.println(x);
//            minStack.display();
//        }
    }
}
