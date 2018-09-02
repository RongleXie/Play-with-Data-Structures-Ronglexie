package map;

import set.FileOperation;

import java.util.ArrayList;

/**
 * 比较BinarySearchTreeMap、LinkedListMap、AVLTreeMap和RedBlackMap
 *
 * @author ronglexie
 * @version 2018/8/19
 */
public class CompareBSTAndLinkedListMapAndAVLTreeMapAndRedBlackMap {

	public static void main(String[] args) {

		BinarySearchTreeMap<String, Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();

		double binarySearchTreeMapTime = testMap(binarySearchTreeMap);

		System.out.println("BinarySearchTreeMap :" + binarySearchTreeMapTime + "s");

		LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();

		double LinkedListMapTime = testMap(linkedListMap);

		System.out.println("LinkedListMap :" + LinkedListMapTime + "s");

		AVLTreeMap<String,Integer> avlTreeMap = new AVLTreeMap<>();

		double avlTreeMapTime = testMap(avlTreeMap);

		System.out.println("AVLTreeMap :" + avlTreeMapTime + "s");

		RedBlackTreeMap<String,Integer> redBlackTreeMap = new RedBlackTreeMap<>();

		double redBlackTreeMapTime = testMap(redBlackTreeMap);

		System.out.println("RedBlackTreeMap :" + redBlackTreeMapTime + "s");
	}

	private static double testMap(Map<String,Integer> map){
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Data-Structures-Ronglexie\\07-Set-Map\\src\\map\\pride-and-prejudice.txt",words);
		System.out.println("Total words: " + words.size());
		for (String word : words) {
			if(map.contains(word)){
				map.set(word,map.get(word)+1);
			}else {
				map.add(word,1);
			}
		}
		System.out.println("Total different words: " + map.getSize());
		System.out.println("Frequency of PRIDE "+map.get("pride"));
		System.out.println("Frequency of THE "+map.get("the"));
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e9;
	}
}
