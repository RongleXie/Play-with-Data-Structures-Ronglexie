package stack;

/**
 * 利用动态数组实现栈
 *
 * @author
 * @version 2018/8/4
 */
public class ArrayStack<E> implements Stack<E> {

	Array<E> array;

	public ArrayStack(int capatity){
		array = new Array<>(capatity);
	}

	public ArrayStack(){
		array = new Array<>();
	}



	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity(){
		return array.getCapacity();
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Stack: size = %d , capacity = %d\n",array.getSize(),array.getCapacity()));
		result.append("[");
		for (int i = 0; i < array.getSize(); i++) {
			result.append(array.get(i));
			if(i != array.getSize() - 1){
				result.append(", ");
			}
		}
		result.append("] top");
		return result.toString();
	}
}
