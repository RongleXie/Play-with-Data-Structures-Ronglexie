/**
 * 优先队列
 * 利用最大堆实现
 *
 * @author ronglexie
 * @version 2018/8/25
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private MaxHeap<E> maxHeap;

	public PriorityQueue() {
		maxHeap = new MaxHeap<>();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}
}
