package set;

import java.util.ArrayList;

/**
 * @author ronglexie
 * @version 2018/8/19
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		BinarySearchTreeSet binarySearchTreeSet = new BinarySearchTreeSet();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\set\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			binarySearchTreeSet.add(word);
		}
		System.out.println("Total different words: " + binarySearchTreeSet.getSize());

		words = new ArrayList<>();
		LinkedListSet linkedListSet = new LinkedListSet();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\set\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			linkedListSet.add(word);
		}
		System.out.println("Total different words: " + linkedListSet.getSize());
	}
}
