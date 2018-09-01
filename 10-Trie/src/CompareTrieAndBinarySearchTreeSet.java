import java.util.ArrayList;
/**
 * 比较Trie与BinarySearchTreeSet
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class CompareTrieAndBinarySearchTreeSet {

	public static void main(String[] args) {

		Trie trie = new Trie();
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\10-Trie\\src\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			trie.add(word);
		}
		for (String word : words) {
			trie.contains(word);
		}
		System.out.println("Total different words: " + trie.getSize());
		long endTime = System.nanoTime();
		System.out.println("Trie :" + (endTime - startTime) / 1e9 + "s");

		BinarySearchTreeSet<String> binarySearchTree = new BinarySearchTreeSet<>();

		double binarySearchTreeTime = testSet(binarySearchTree);

		System.out.println("BinarySearchTreeSet :" + binarySearchTreeTime + "s");
	}

	private static double testSet(Set<String> set){
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\10-Trie\\src\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			set.add(word);
		}
		for (String word : words) {
			set.contains(word);
		}
		System.out.println("Total different words: " + set.getSize());
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e9;
	}
}
