import java.util.ArrayList;

/**
 * @author ronglexie
 * @version 2018/9/1
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\12-AVL-Tree\\src\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		AVLTree<String,Integer> wordsMap = new AVLTree();
		for (String word : words) {
			if(wordsMap.contains(word)){
				wordsMap.set(word,wordsMap.get(word)+1);
			}else {
				wordsMap.add(word,1);
			}
		}
		System.out.println("Total different words: " + wordsMap.getSize());
		System.out.println("Frequency of PRIDE "+wordsMap.get("pride"));
		System.out.println("Frequency of is "+wordsMap.get("is"));
	}
}
