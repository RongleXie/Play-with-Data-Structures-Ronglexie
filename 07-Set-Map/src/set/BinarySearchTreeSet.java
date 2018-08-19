package set;

/**
 * 利用二分搜索树实现集合
 * 不包含重复元素
 *
 * @author ronglexie
 * @version 2018/8/18
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

	private BinarySearchTree<E> binarySearchTree;

	public BinarySearchTreeSet() {
		binarySearchTree = new BinarySearchTree<>();
	}

	@Override
	public void add(E e) {
		binarySearchTree.add(e);
	}

	@Override
	public void remove(E e) {
		binarySearchTree.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return binarySearchTree.contains(e);
	}

	@Override
	public int getSize() {
		return binarySearchTree.size();
	}

	@Override
	public boolean isEmpty() {
		return binarySearchTree.isEmpty();
	}
}
