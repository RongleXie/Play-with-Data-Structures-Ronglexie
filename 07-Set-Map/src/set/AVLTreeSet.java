package set;

/**
 * 利用AVL平衡二叉树实现集合
 * 不包含重复元素
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class AVLTreeSet<E extends Comparable<E>> implements Set<E> {

	AVLTree<E,Object> avlTree;

	public AVLTreeSet() {
		avlTree = new AVLTree<>();
	}

	@Override
	public void add(E e) {
		avlTree.add(e, null);
	}

	@Override
	public void remove(E e) {
		avlTree.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return avlTree.contains(e);
	}

	@Override
	public int getSize() {
		return avlTree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avlTree.isEmpty();
	}
}
