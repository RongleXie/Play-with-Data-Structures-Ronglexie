/**
 * 数组
 *
 * @author
 * @version 2018/8/4
 */
public class Array<E> {

	private E[] data;
	private int size;

	public Array(int capacity){
		data = (E[])new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);
	}

	public int getSize(){
		return size;
	}

	public int getCapacity(){
		return data.length;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 向数组头部插入一个元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public void addFirst(E e){
		add(0,e);
	}

	/**
	 * 向数组尾部插入一个元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public void addLast(E e){
		add(size,e);
	}

	/**
	 * 向数组指定位置插入一个元素
	 *
	 * @param index
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public void add(int index, E e){

		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
		}

		if(size == data.length){
//			throw new IllegalArgumentException("Add failed. Array is full.");
			//数组动态扩容两倍
			resize(2*data.length);
		}

		for (int i= size-1; i >= index; i--){
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}

	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 获取指定位置的元素
	 *
	 * @param index
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is Illegal.");
		}
		return data[index];
	}

	/**
	 * 获取第一个元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E getFirst() {
		return data[0];
	}

	/**
	 * 获取最后一个元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E getLast() {
		return get(size - 1);
	}

	/**
	 * 修改指定位置的元素
	 *
	 * @param index
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public void set(int index, E e){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed. index is Illegal.");
		}
		data[index] = e;
	}

	/**
	 * 查看数组中是否包含某个元素
	 *
	 * @param e
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public boolean contains(E e){
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找元素在数组中的位置
	 *
	 * @param e
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public int indexOf(E e){
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 移除数组中的一个元素
	 *
	 * @param index
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E remove(int index){
		if (index < 0 || index >= size){
			throw new IllegalArgumentException("Remove failed. index is Illegal.");
		}

		E result = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		//修改对象引用，垃圾回收机制回收
		data[size] = null;

		//动态缩小数组一半容量
		if(size == data.length/4 && data.length/2 != 0){
			resize(data.length/2);
		}
		return result;
	}

	/**
	 * 移除数组中的第一个元素
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E removeFirst(){
		return remove(0);
	}

	/**
	 * 移除数组中的最后一个元素
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public E removeLast(){
		return remove(size - 1);
	}

	/**
	 * 移除数组中的某个元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	public void removeElement(E e){
		int index = indexOf(e);
		if(index != -1){
			remove(index);
		}
	}

	/**
	 * 将索引为i和j的两个元素互相交换
	 *
	 * @param i
	 * @param j
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	public void swap(int i, int j){
		if (i < 0 || i >= size || j < 0 || j >= size){
			throw new IllegalArgumentException("Swap failed. index is Illegal.");
		}
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/**
	 * 自定义toString方法
	 *
	 * @param
	 * @return java.lang.String
	 * @author ronglexie
	 * @version 2018/8/4
	 */
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
		result.append("[");
		for (int i = 0; i < size; i++){
			result.append(data[i]);
			if(i != size - 1){
				result.append(", ");
			}
		}
		result.append("]");
		return result.toString();
	}

}
