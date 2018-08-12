package queue;

/**
 * 利用链表实现队列
 *
 * @author ronglexie
 * @version 2018/8/12
 */
public class LinkedListQueue<E> implements Queue<E>{

	LinkedList<E> list;

	public LinkedListQueue() {
		list = new LinkedList<>();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}

	@Override
	public E getFront() {
		return list.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Queue: size = %d \n",list.getSize()));
		result.append("front [");
		result.append(list);
		result.append("] tail");
		return result.toString();
	}
}
