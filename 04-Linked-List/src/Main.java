/**
 * @author ronglexie
 * @version 2018/8/12
 */
public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList.toString());
		}
		linkedList.add(5,11111);
		System.out.println(linkedList.toString());

		linkedList.remove(5);
		System.out.println(linkedList.toString());
		linkedList.removeFirst();
		System.out.println(linkedList.toString());
		linkedList.removeLast();
		System.out.println(linkedList.toString());
		linkedList.remove(4);
		System.out.println(linkedList.toString());
		linkedList.addFirst(4);
		linkedList.addFirst(4);
		linkedList.addFirst(4);
		linkedList.removeAll(4);
		System.out.println(linkedList.toString());
	}
}
