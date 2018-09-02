import java.util.ArrayList;

/**
 * @author ronglexie
 * @version 2018/9/2
 */
public class Main{
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\13-Red-Black-Tree\\src\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		RedBlackTree<String,Integer> wordsMap = new RedBlackTree();
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
		System.out.println("Frequency of of "+wordsMap.get("of"));
	}
}
