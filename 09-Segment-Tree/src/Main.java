/**
 * @author ronglexie
 * @version 2018/8/25
 */
public class Main {
	public static void main(String[] args) {
		SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(new Integer[]{1,2,3,4,5,5,13}, (a,b) -> a + b);
		System.out.println(segmentTree.toString());
		System.out.println(segmentTree.query(2, 4));
		System.out.println(segmentTree.query(0, 4));
		System.out.println(segmentTree.query(1, 4));
		System.out.println(segmentTree.query(3, 4));
		segmentTree.set(0,20);
		System.out.println(segmentTree.toString());
	}
}
