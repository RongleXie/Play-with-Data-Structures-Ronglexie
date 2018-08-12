package queue;

/**
 * 链表
 * 包含头指针、尾指针
 *
 * @author ronglexie
 * @version 2018/8/12
 */
public class LinkedList<E> {

	/** 头节点、尾节点*/
	private Node head,tail;
	/** 链表大小*/
	private int size;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 在链表尾部添加元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/12
	 */
	public void addLast(E e){
		if(tail == null){
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size ++;
	}

	/**
	 * 在链表头部移除元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/12
	 */
	public E removeFirst(){
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot remove from an empty linkedlist");
		}
		Node delNode = head;
		head = delNode.next;
		delNode.next = null;
		size --;
		return delNode.e;
	}

	/**
	 * 获取链表头部的元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/12
	 */
	public E getFirst(){
		return head.e;
	}


	private class Node{

		private E e;
		private Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this.e = e;
		}

		public Node() {
			this(null,null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}
}
