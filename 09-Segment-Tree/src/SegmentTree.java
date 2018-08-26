/**
 * 线段树
 *
 * @author ronglexie
 * @version 2018/8/25
 */
public class SegmentTree<E> {

	/**普通数据*/
	private E[] data;
	/**树结构数据*/
	private E[] tree;
	/**融合器*/
	private Merger<E> merger;

	public SegmentTree(E[] arr,Merger<E> merger){
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		tree = (E[]) new Object[4*arr.length];
		buildSegmentTree(0, 0, data.length - 1);
	}

	/**
	 * 在treeIndex的位置创建表示区间[l...r]的线段树
	 *
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/25
	 */
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if(l == r){
			tree[treeIndex] = data[l];
			return;
		}

		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		int middle = l + (r - l) / 2;
		buildSegmentTree(leftTreeIndex,l,middle);
		buildSegmentTree(rightTreeIndex,middle + 1,r);
		//融合两个元素
		tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
	}

	public int getSize(){
		return data.length;
	}

	public E get(int index){
		if(index < 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		return data[index];
	}

	/**
	 * 查找用数组实现的完全二叉树中该索引下节点的左孩子节点的索引
	 *
	 * @param index
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	public int leftChild(int index){
		return (index * 2) + 1;
	}

	/**
	 * 查找用数组实现的完全二叉树中该索引下节点的右孩子节点的索引
	 *
	 * @param index
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	public int rightChild(int index){
		return (index * 2) + 2;
	}

	/**
	 * 查询区间[start...end]的值
	 *
	 * @param start
	 * @param end
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/25
	 */
	public E query(int start, int end){
		if(start < 0 || start > data.length ||
				end < 0 || end > data.length ||
						start > end){
			throw new IllegalArgumentException("Index is illegal.");
		}
		return query(0, 0, data.length-1, start, end);
	}

	/**
	 * 查询在以treeIndex为根的线段树区间为[l...r]的范围中，区间[start...end]的值
	 *
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @param start
	 * @param end
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/25
	 */
	private E query(int treeIndex, int l, int r, int start, int end){
		if(l == start && r == end){
			return tree[treeIndex];
		}
		int middle = l + (r - l) / 2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		if(start >= middle + 1){
			return query(rightTreeIndex,middle+1,r,start,end);
		}else if(end <= middle){
			return query(leftTreeIndex,l,middle,start,end);
		}

		E leftResult = query(leftTreeIndex, l, middle, start, middle);
		E rightResult = query(rightTreeIndex, middle + 1, r, middle + 1, end);
		return merger.merge(leftResult,rightResult);
	}

	/**
	 * 更新index位置的元素为e
	 *
	 * @param index
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/26
	 */
	public void set(int index, E e){
		if(index < 0 || index >= data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		set(0,0,data.length - 1,index,e);
	}

	/**
	 * 更新在以treeIndex为根的线段树区间为[l...r]的范围中位置为index的值
	 *
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @param index
	 * @param e
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/26
	 */
	private void set(int treeIndex, int l, int r, int index, E e){
		if(l == r){
			tree[treeIndex] = e;
			return;
		}
		int middle = l + (r - l) / 2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if(index >= middle + 1){
			set(rightTreeIndex,middle+1,r,index,e);
		}else if(index <= middle){
			set(leftTreeIndex,l,middle,index,e);
		}
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SegmentTree: [");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null){
				result.append(tree[i]);
			}else {
				result.append("null");
			}
			if (i != tree.length - 1) {
				result.append(",");
			}else {
				result.append("]");
			}
		}
		return result.toString();
	}
}
