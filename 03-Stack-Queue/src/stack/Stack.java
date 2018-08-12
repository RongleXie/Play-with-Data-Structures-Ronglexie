package stack;

/**
 * 栈
 * 
 * @author
 * @version 2018/8/4
 */
public interface Stack<E> {

	/**
	 * 获取栈的大小
	 * 
	 * @param  
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	int getSize();
	
	/**
	 * 判断栈是否为空
	 *
	 * @param
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	boolean isEmpty();

	/**
	 * 向栈中插入一个元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	void push(E e);

	/**
	 * 向栈中移除一个元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	E pop();

	/**
	 * 查看栈顶元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	E peek();
}
