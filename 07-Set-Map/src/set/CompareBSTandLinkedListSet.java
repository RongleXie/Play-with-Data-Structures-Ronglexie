package set;

import java.util.ArrayList;

/**
 * 比较BinarySearchTreeSet与LinkedListSet
 *
 * @author ronglexie
 * @version 2018/8/19
 */
public class CompareBSTandLinkedListSet {

	public static void main(String[] args) {
		BinarySearchTreeSet<String> binarySearchTree = new BinarySearchTreeSet<>();

		double binarySearchTreeTime = testSet(binarySearchTree);

		System.out.println("BinarySearchTreeSet :" + binarySearchTreeTime + "s");

		LinkedListSet<String> linkedListSet = new LinkedListSet<>();

		double linkedListSetTime = testSet(linkedListSet);

		System.out.println("LinkedListSet :" + linkedListSetTime + "s");
	}

	private static double testSet(Set<String> set){
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\set\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			set.add(word);
		}
		System.out.println("Total different words: " + set.getSize());
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e9;
	}
}
