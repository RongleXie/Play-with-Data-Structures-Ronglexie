package map;

/**
 * 利用红黑树实现映射
 *
 * @author ronglexie
 * @version 2018/9/2
 */
public class RedBlackTreeMap<K extends Comparable<K>,V> implements Map<K,V>{

	private RedBlackTree<K,V> redBlackTree;

	public RedBlackTreeMap() {
		redBlackTree = new RedBlackTree<>();
	}

	@Override
	public void add(K key, V value) {
		redBlackTree.add(key, value);
	}

	@Override
	public V remove(K key) {
		return redBlackTree.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return redBlackTree.contains(key);
	}

	@Override
	public V get(K key) {
		return redBlackTree.get(key);
	}

	@Override
	public void set(K key, V value) {
		redBlackTree.set(key, value);
	}

	@Override
	public int getSize() {
		return redBlackTree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return redBlackTree.isEmpty();
	}
}
