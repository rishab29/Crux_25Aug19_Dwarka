package Lecture10;

public class QUAClient {
	public static void main(String[] args) throws Exception {
		QueueUsingArrays queue = new QueueUsingArrays(5);
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
			displayQueueInfo(queue);
		}
         queue.dequeue();
         queue.dequeue();
         displayQueueInfo(queue);
         queue.enqueue(60);
         queue.enqueue(70);
         displayQueueInfo(queue);
		

		while (!queue.isEmpty()) {
			displayQueueInfo(queue);
			queue.dequeue();
		}

	}

	public static void displayQueueInfo(QueueUsingArrays queue) throws Exception {
		System.out.println("************************");
		queue.display();
		System.out.println("Size:" + queue.size());
		System.out.println("Front:" + queue.front());
		System.out.println("************************");
	}

}
