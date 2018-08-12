package queue;

/**
 * 动态数组实现队列
 *
 * @author ronglexie
 * @version 2018/8/4
 */
public class ArrayQueue<E> implements Queue<E> {

	private Array<E> array;

	public ArrayQueue(int capacity){
		array = new Array<>(capacity);
	}

	public ArrayQueue(){
		array = new Array<>();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	public int getCapacity(){
		return array.getCapacity();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Queue: size = %d , capacity = %d",array.getSize(),array.getCapacity());
		result.append("front [");
		for (int i = 0; i < array.getSize(); i++) {
			result.append(array.get(i));
			if(i != array.getSize() - 1){
				result.append(", ");
			}
		}
		result.append("] tail");
		return result.toString();
	}
}
