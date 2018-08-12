package queue;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int count = 100000;

		ArrayQueue<Integer> queue = new ArrayQueue<>();

		double arrayQueueTime = testQueue(queue, count);

		System.out.println("ArrayQueue: "+arrayQueueTime + " s");
		LoopQueue<Integer> loopQueue = new LoopQueue<>();

		double loopQueueTime = testQueue(loopQueue, count);
		System.out.println("LoopQueue: "+loopQueueTime + " s");

		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		double linkedListQueueTime = testQueue(linkedListQueue, count);
		System.out.println("LinkedListQueue: "+linkedListQueueTime + " s");
	}

	private static double testQueue(Queue<Integer> queue,int count){
		long startTime = System.nanoTime();

		Random random = new Random();
		for (int i = 0; i < count; i++) {
			int nextInt = random.nextInt(Integer.MAX_VALUE);
			queue.enqueue(nextInt);
		}
		for (int i = 0; i < count; i++) {
			queue.dequeue();
		}
		long endTime = System.nanoTime();
		return (endTime - startTime)/1000000000.0;
	}
}
