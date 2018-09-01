/**
 * 并查集
 * 第二个版本，Quick Union,数组实现
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class UnionFind2 implements UnionFind{

	private int[] parent;//存储当前位置元素的根节点

	public UnionFind2(int size) {
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	/**
	 * 查找元素p所对应的根节点
	 *
	 * @param p
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	private int find(int p){
		if(p < 0 || p > parent.length){
			throw new IllegalArgumentException("p is out of bound.");
		}
		while (p != parent[p]){
			p = parent[p];
		}
		return p;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot){
			return;
		}
		parent[pRoot] = qRoot;
	}
}
