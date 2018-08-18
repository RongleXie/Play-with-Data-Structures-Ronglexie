/**
 * @author ronglexie
 * @version 2018/8/18
 */
public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		int[] nums = new int[]{5,4,2,3,6};

		for (int i = 0; i < nums.length; i++) {
			binarySearchTree.add(nums[i]);
		}
		System.out.println(binarySearchTree.toString());

		binarySearchTree.preOrder();
		System.out.println();
		binarySearchTree.inOrder();
		System.out.println();
		binarySearchTree.postOrder();
		System.out.println();

		binarySearchTree.preOrderNR();
		binarySearchTree.levelOrder();

		binarySearchTree.remove(5);
		System.out.println(binarySearchTree.toString());
		binarySearchTree.removeMin();
		System.out.println(binarySearchTree.toString());
		binarySearchTree.removeMax();
		System.out.println(binarySearchTree.toString());
	}
}
