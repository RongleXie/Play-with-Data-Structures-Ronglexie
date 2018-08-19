package map;

import set.FileOperation;

import java.util.ArrayList;

/**
 * @author ronglexie
 * @version 2018/8/19
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\map\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		LinkedListMap<String,Integer> wordsMap = new LinkedListMap();
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

		words = new ArrayList<>();
		BinarySearchTreeMap<String,Integer> binarySearchTreeMap = new BinarySearchTreeMap();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\map\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			if(binarySearchTreeMap.contains(word)){
				binarySearchTreeMap.set(word,binarySearchTreeMap.get(word)+1);
			}else {
				binarySearchTreeMap.add(word,1);
			}
		}
		System.out.println("Total different words: " + binarySearchTreeMap.getSize());
		System.out.println("Frequency of PRIDE "+binarySearchTreeMap.get("pride"));
		System.out.println("Frequency of is "+binarySearchTreeMap.get("is"));
	}
}
