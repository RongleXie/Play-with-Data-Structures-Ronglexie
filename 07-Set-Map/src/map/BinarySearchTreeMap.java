package map;

/**
 * 利用二分搜索树实现映射
 *
 * @author ronglexie
 * @version 2018/8/19
 */
public class BinarySearchTreeMap<K extends Comparable<K>,V> implements Map<K,V> {

	private Node root;
	private int size;

	public BinarySearchTreeMap() {
		root = null;
		size = 0;
	}

	@Override
	public void add(K key, V value) {
		root = add(root,key,value);
	}

	/**
	 * 向node为根元素的二分搜索树中插入元素
	 * 递归算法
	 *
	 * @param node
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	private Node add(Node node, K key, V value){
		//递归终止条件，返回结果为null
		if(node == null){
			size ++;
			return new Node(key,value);
		}

		if(key.compareTo(node.key) < 0){
			node.left = add(node.left,key,value);
		}else if(key.compareTo(node.key) > 0){
			node.right = add(node.right,key,value);
		}else {
			node.value = value;
		}
		return node;
	}

	/**
	 * 查找二分搜索树的最小值
	 *
	 * @param
	 * @return V
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public V minimum(){
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		return minimum(root).value;
	}

	/**
	 * 查找以node为根节点二分搜索树的最小节点
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node minimum(Node node) {
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		if(node.left == null){
			return node;
		}
		return minimum(node.left);
	}

	/**
	 * 查找二分搜索树的最大值
	 *
	 * @param
	 * @return V
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public V maximize(){
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		return maximize(root).value;
	}

	/**
	 * 查找以node为根节点二分搜索树的最大节点
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node maximize(Node node) {
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		if(node.right == null){
			return node;
		}
		return minimum(node.right);
	}

	/**
	 * 删除二分搜索树的最大值
	 *
	 * @param
	 * @return V
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public V removeMax(){
		V maximize = maximize();
		removeMax(root);
		return maximize;
	}

	/**
	 * 删除以node为根的二分搜索树的最大节点
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node removeMax(Node node){
		if(node.right == null){
			Node leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		node.right = removeMin(node.right);
		return node;
	}

	/**
	 * 删除二分搜索树的最小值
	 *
	 * @param
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public V removeMin(){
		V minimum = minimum();
		removeMin(root);
		return minimum;
	}

	/**
	 * 删除以node为根的二分搜索树的最小节点
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node removeMin(Node node){
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	@Override
	public V remove(K key) {
		Node node = getNode(root,key);
		if(node != null){
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	/**
	 * 删除以node为根的二分搜索树中的指定元素
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @param key
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node remove(Node node, K key) {
		if(node == null){
			return null;
		}
		if(key.compareTo(node.key) < 0){
			node.left = remove(node.left,key);
			return node;
		}else if(key.compareTo(node.key) > 0){
			node.right = remove(node.right,key);
			return node;
		}else /*if(key.compareTo(node.key) == 0)*/{
			// 删除右子树为空的情况
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			// 删除左子树为空的情况
			else if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			// 删除左子树、右子树均不为空的情况
			else {
				// 1、删除后用后继节点替代该位置(后继节点即待删除节点右子树中的最小节点)
				// 获得后继节点
				Node successor = minimum(node.right);
				// 删除后继节点，并让待删除节点的右子树成为后继节点的右子树
				successor.right = removeMin(node);
				// 让待删除节点的左子树成为后继节点的左子树
				successor.left = node.left;
				// 将待删除节点的左、右子节点置为空
				node.left = node.right = null;
				return successor;
				/**
				 // 2、删除后用前驱节点替代该位置(前驱节点即待删除节点左子树中的最大节点)
				 // 获得前驱节点
				 Node predecessor = maximize(node.left);
				 // 删除前驱节点，并让待删除节点的左子树成为前驱节点的左子树
				 predecessor.left = removeMax(node);
				 // 让待删除节点的右子树成为前驱节点的右子树
				 predecessor.right = node.right;
				 // 将待删除节点的左、右子节点置为空
				 node.left = node.right = null;
				 return predecessor;
				 */
			}
		}
	}

	@Override
	public boolean contains(K key) {
		return getNode(root,key) != null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return node != null ? node.value : null;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if(node == null){
			throw new IllegalArgumentException("Set failed. key is not exists!");
		}
		node.value = value;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 根据key获取Node
	 *
	 * @param node
	 * @param key
	 * @return map.LinkedListMap<K,V>.Node
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	public Node getNode(Node node,K key){
		if(node == null){
			return null;
		}

		if(key.compareTo(node.key) == 0){
			return node;
		}else if(key.compareTo(node.key) < 0){
			return getNode(node.left,key);
		}else{
			return getNode(node.right,key);
		}
	}


	/**
	 * 节点类
	 *
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private class Node{
		public K key;
		public V value;
		public Node left,right;

		public Node(K key, V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
}
