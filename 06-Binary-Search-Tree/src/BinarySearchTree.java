import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 *
 * @author ronglexie
 * @version 2018/8/18
 */
public class BinarySearchTree<E extends Comparable<E>> {

	private Node root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public BinarySearchTree(Node e){
		root = e;
		size ++;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 向二分搜索树中添加元素
	 *
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void add(E e){
		root = add(root,e);
	}
	/**
	 * 向node为根元素的二分搜索树中插入元素
	 * 递归算法
	 *
	 * @param node
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	@Deprecated
	private void addDeprecated(Node node,E e){
		/** 递归终止条件：判断根节点、根a节点的左右节点是否为空*/
		if(e.equals(node.e)){
			return;
		}else if(e.compareTo(node.e) < 0 && node.left == null){
			node.left = new Node(e);
			size ++;
			return;
		}else if(e.compareTo(node.e) > 0 && node.right == null){
			node.right = new Node(e);
			size ++;
			return;
		}

		if(e.compareTo(node.e) < 0){
			addDeprecated(node.left,e);
		}else if(e.compareTo(node.e) > 0){
			addDeprecated(node.right,e);
		}
	}

	/**
	 * 向node为根元素的二分搜索树中插入元素
	 * 递归算法
	 *
	 * @param node
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node add(Node node, E e){
		//递归终止条件，返回结果为null
		if(node == null){
			size ++;
			return new Node(e);
		}

		if(e.compareTo(node.e) < 0){
			node.left = add(node.left,e);
		}else if(e.compareTo(node.e) > 0){
			node.right = add(node.right,e);
		}
		return node;
	}

	/**
	 * 判断二分搜索树是否包含某个元素
	 *
	 * @param e
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public boolean contains(E e){
		return contains(root,e);
	}

	/**
	 * 判断以node为根元素的二分搜索树是否包含某个元素
	 *
	 * @param node
	 * @param e
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private boolean contains(Node node,E e){
		if(node == null){
			return false;
		}
		if(e.compareTo(node.e) == 0){
			return true;
		}else if(e.compareTo(node.e) < 0){
			return contains(node.left,e);
		}else /*if(e.compareTo(node.e) < 0)*/{
			return contains(node.right,e);
		}
	}

	/**
	 * 前序遍历二分搜索树
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void preOrder(){
		preOrder(root);
	}

	/**
	 * 前序遍历以node为根节点的二分搜索树
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * 前序遍历二分搜索树
	 * 深度优先遍历，非递归实现，利用栈结构
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void preOrderNR(){
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()){
			Node cur = stack.pop();
			System.out.println(cur.e);
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
	}

	/**
	 * 中序遍历二分搜索树
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void inOrder(){
		inOrder(root);
	}

	/**
	 * 中序遍历以node为根节点的二分搜索树
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	/**
	 * 后序遍历二分搜索树
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void postOrder(){
		postOrder(root);
	}

	/**
	 * 后序遍历以node为根节点的二分搜索树
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	/**
	 * 层序遍历二分搜索树
	 * 广度优先遍历，利用队列结构
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void levelOrder(){
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()){
			Node cur = nodeQueue.poll();
			System.out.println(cur.e);
			if(cur.left != null){
				nodeQueue.add(cur.left);
			}
			if(cur.right != null){
				nodeQueue.add(cur.right);
			}
		}
	}

	/**
	 * 查找二分搜索树的最小值
	 *
	 * @param
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public E minimum(){
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		return minimum(root).e;
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
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public E maximize(){
		if(isEmpty()){
			throw new IllegalArgumentException("BinarySearchTree is empty !");
		}
		return maximize(root).e;
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
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public E removeMax(){
		E maximize = maximize();
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
	public E removeMin(){
		E minimum = minimum();
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

	/**
	 * 删除二分搜索树中的指定元素
	 *
	 * @param e
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	public void remove(E e){
		root = remove(root,e);
	}

	/**
	 * 删除以node为根的二分搜索树中的指定元素
	 * 深度优先遍历，递归实现
	 *
	 * @param node
	 * @param e
	 * @return BinarySearchTree<E>.Node
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private Node remove(Node node, E e) {
		if(node == null){
			return null;
		}
		if(e.compareTo(node.e) < 0){
			node.left = remove(node.left,e);
			return node;
		}else if(e.compareTo(node.e) > 0){
			node.right = remove(node.right,e);
			return node;
		}else /*if(e.compareTo(node.e) == 0)*/{
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
	public String toString() {
		StringBuilder result = new StringBuilder();
		generateBSTString(root,0,result);
		return result.toString();
	}

	/**
	 * 生成二分搜索树的字符
	 *
	 * @param node
	 * @param depth
	 * @param result
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private void generateBSTString(Node node, int depth, StringBuilder result) {
		if (node == null) {
			result.append(generateBSTString(depth)+"null\n");
			return;
		}
		result.append(generateBSTString(depth)+node.e+"\n");
		generateBSTString(node.left,depth+1,result);
		generateBSTString(node.right,depth+1,result);
	}

	/**
	 * 生成表示深度的字符
	 *
	 * @param depth
	 * @return java.lang.String
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private String generateBSTString(int depth) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			result.append("--");
		}
		return result.toString();
	}

	/**
	 * 节点类
	 *
	 * @author ronglexie
	 * @version 2018/8/18
	 */
	private class Node{
		public E e;
		public Node left,right;

		public Node(E e){
			this.e = e;
			left = null;
			right = null;
		}
	}
}
