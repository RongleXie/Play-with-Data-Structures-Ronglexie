package queue;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		ArrayQueue<Integer> queue = new ArrayQueue<>();

//		for (int i = 0; i < 10; i++) {
//			queue.enqueue(i);
//			System.out.println(queue.toString());
//
//			if (i % 3 == 2) {
//				queue.dequeue();
//				System.out.println(queue.toString());
//			}
//		}

		int count = 100000;
		double arrayQueueTime = testQueue(queue, count);

		System.out.println("ArrayQueue: "+arrayQueueTime + " s");
		LoopQueue<Integer> loopQueue = new LoopQueue<>();

		double loopQueueTime = testQueue(loopQueue, count);
		System.out.println("LoopQueue: "+loopQueueTime + " s");
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
