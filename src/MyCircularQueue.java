/**
 * @author ronglexie
 * @version 2018/8/14
 */
public class MyCircularQueue {

	private int[] array;
	private int front,tail;
	int size;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		array = new int[k];
		front = 0;
		tail = 0;
		size = 0;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if((tail + 1) % array.length == front){
			return false;
		}
		array [tail] = value;
		tail = (tail+1) % array.length;
		size ++;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(size == 0){
			return false;
		}
		front = (front+1) % array.length;
		size --;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if(isEmpty()){
			return 0;
		}
		return array[front];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if(isEmpty()){
			return 0;
		}
		if(tail == 0){
			return array[size];
		}
		return array[tail-1];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return front == tail;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (tail + 1) % array.length == front;
	}


	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1));
		System.out.println(myCircularQueue.enQueue(2));
		System.out.println(myCircularQueue.enQueue(3));
		System.out.println(myCircularQueue.enQueue(4));
		System.out.println(myCircularQueue.Rear());
		System.out.println(myCircularQueue.isFull());
		System.out.println(myCircularQueue.deQueue());
		System.out.println(myCircularQueue.enQueue(4));
		System.out.println(myCircularQueue.Rear());
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */