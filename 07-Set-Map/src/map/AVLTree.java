package map;

import set.FileOperation;

import java.util.ArrayList;

/**
 * AVL平衡二叉树
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class AVLTree<K extends Comparable<K>,V> {

	private Node root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	/**
	 * 获取某个节点的高度
	 *
	 * @param node
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private int getHeight(Node node){
		if(node == null){
			return 0;
		}
		return node.height;
	}

	/**
	 * 获取某个节点的平衡因子
	 *
	 * @param node
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private int getBalanceFactor(Node node){
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	/**
	 * 查看AVL平衡二叉树是否是二分搜索树
	 *
	 * @param
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private boolean isBinarySearchTree(){
		ArrayList<K> keys = new ArrayList<>();
		inOrder(root,keys);
		for (int i = 1; i < keys.size(); i++) {
			if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 查看AVL平衡二叉树是否是平衡二叉树
	 *
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private boolean isBalanced(){
		return isBalanced(root);
	}

	/**
	 * 递归查看以node为根节点的AVL平衡二叉树是否是平衡二叉树
	 *
	 * @param node
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private boolean isBalanced(Node node){
		if (node == null) {
			return true;
		}
		int balanceFactor = getBalanceFactor(node);
		if(Math.abs(balanceFactor) > 1){
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}

	// 对节点y进行向右旋转操作，返回旋转后新的根节点x
	//        y                              x
	//       / \                           /   \
	//      x   T4     向右旋转 (y)        z     y
	//     / \       - - - - - - - ->    / \   / \
	//    z   T3                       T1  T2 T3 T4
	//   / \
	// T1   T2
	/**
	 * 右旋转操作
	 * @param y
	 * @return AVLTree<K,V>.Node
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private Node rightRotate(Node y){
		Node x = y.left;
		Node T3 = x.right;

		//右旋转操作
		x.right = y;
		y.left = T3;

		//更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		return x;
	}

	// 对节点y进行向左旋转操作，返回旋转后新的根节点x
	//    y                             x
	//  /  \                          /   \
	// T1   x      向左旋转 (y)       y     z
	//     / \   - - - - - - - ->   / \   / \
	//   T2  z                     T1 T2 T3 T4
	//      / \
	//     T3 T4
	/**
	 * 左旋转操作
	 *
	 * @param y
	 * @return AVLTree<K,V>.Node
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private Node leftRotate(Node y){
		Node x = y.right;
		Node T2 = x.left;

		//左旋转操作
		x.left = y;
		y.right = T2;

		//更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		return x;
	}

	/**
	 * 中序遍历以node为根节点的AVL平衡二叉树
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private void inOrder(Node node, ArrayList<K> keys){
		if(node == null){
			return;
		}
		inOrder(node.left,keys);
		keys.add(node.key);
		inOrder(node.right,keys);
	}

	/**
	 * 向AVL平衡二叉树中插入元素
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	public void add(K key, V value) {
		root = add(root,key,value);
	}

	/**
	 * 向node为根元素的AVL平衡二叉树中插入元素
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

		/**========== 维护平衡 Start ==========*/
		//更新Height
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		//计算平衡因子
		int balanceFactor = getBalanceFactor(node);
		//LL左孩子节点的左侧产生不平衡
		if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
			//右旋转操作
			return rightRotate(node);
		}
		//RR右孩子节点的右侧产生不平衡
		if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
			//左旋转操作
			return leftRotate(node);
		}
		//LR左孩子节点的右侧产生不平衡
		if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
			node.left = leftRotate(node.left);
			//右旋转操作
			return rightRotate(node);
		}
		//RL右孩子节点的左侧产生不平衡
		if(balanceFactor <-1 && getBalanceFactor(node.right) > 0){
			node.right = rightRotate(node.right);
			//右旋转操作
			return leftRotate(node);
		}
		/**========== 维护平衡 End ==========*/
		return node;
	}

	/**
	 * 查找AVL平衡二叉树的最小值
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
	 * 查找以node为根节点AVL平衡二叉树的最小节点
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
	 * 查找AVL平衡二叉树的最大值
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
	 * 查找以node为根节点AVL平衡二叉树的最大节点
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
	 * 删除AVL平衡二叉树的最大值
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
	 * 删除以node为根的AVL平衡二叉树的最大节点
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
	 * 删除AVL平衡二叉树的最小值
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
	 * 删除以node为根的AVL平衡二叉树的最小节点
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

	public V remove(K key) {
		Node node = getNode(root,key);
		if(node != null){
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	/**
	 * 删除以node为根的AVL平衡二叉树中的指定元素
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

		Node resultNode;

		if(key.compareTo(node.key) < 0){
			node.left = remove(node.left, key);
			resultNode = node;
		}else if(key.compareTo(node.key) > 0){
			node.right = remove(node.right, key);
			resultNode = node;
		}else /*if(key.compareTo(node.key) == 0)*/{
			// 删除右子树为空的情况
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
				resultNode = leftNode;
			}
			// 删除左子树为空的情况
			else if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				resultNode = rightNode;
			}
			// 删除左子树、右子树均不为空的情况
			else {
				// 1、删除后用后继节点替代该位置(后继节点即待删除节点右子树中的最小节点)
				// 获得后继节点
				Node successor = minimum(node.right);
				// 删除后继节点，并让待删除节点的右子树成为后继节点的右子树
				successor.right = remove(node.right,successor.key);
				// 让待删除节点的左子树成为后继节点的左子树
				successor.left = node.left;
				// 将待删除节点的左、右子节点置为空
				node.left = node.right = null;
				resultNode = successor;
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

		/**========== 维护平衡 Start ==========*/
		if(resultNode == null){
			return null;
		}

		//更新Height
		resultNode.height = 1 + Math.max(getHeight(resultNode.left), getHeight(resultNode.right));
		//计算平衡因子
		int balanceFactor = getBalanceFactor(resultNode);
		//LL左孩子节点的左侧产生不平衡
		if(balanceFactor > 1 && getBalanceFactor(resultNode.left) >= 0){
			//右旋转操作
			return rightRotate(resultNode);
		}
		//RR右孩子节点的右侧产生不平衡
		if (balanceFactor < -1 && getBalanceFactor(resultNode.right) <= 0){
			//左旋转操作
			return leftRotate(resultNode);
		}
		//LR左孩子节点的右侧产生不平衡
		if(balanceFactor > 1 && getBalanceFactor(resultNode.left) < 0){
			resultNode.left = leftRotate(resultNode.left);
			//右旋转操作
			return rightRotate(resultNode);
		}
		//RL右孩子节点的左侧产生不平衡
		if(balanceFactor <-1 && getBalanceFactor(resultNode.right) > 0){
			resultNode.right = rightRotate(resultNode.right);
			//右旋转操作
			return leftRotate(resultNode);
		}
		/**========== 维护平衡 End ==========*/
		return resultNode;
	}

	public boolean contains(K key) {
		return getNode(root,key) != null;
	}

	public V get(K key) {
		Node node = getNode(root, key);
		return node != null ? node.value : null;
	}

	public void set(K key, V value) {
		Node node = getNode(root, key);
		if(node == null){
			throw new IllegalArgumentException("Set failed. key is not exists!");
		}
		node.value = value;
	}

	public int getSize() {
		return size;
	}

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
		public int height;

		public Node(K key, V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			height = 1;
		}
	}

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
		System.out.println("Frequency of of "+wordsMap.get("of"));
		System.out.println("isBinarySearchTree:"+wordsMap.isBinarySearchTree());
		System.out.println("isBalanced:"+wordsMap.isBalanced());
		for (String word : words) {
			wordsMap.remove(word);
			if(!wordsMap.isBinarySearchTree() || !wordsMap.isBalanced()){
				throw new RuntimeException("Error");
			}
		}
	}
}
