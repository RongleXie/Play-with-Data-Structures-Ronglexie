/**
 * 并查集
 * 第三个版本，基于size大小的优化,数组实现
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class UnionFind3 implements UnionFind{

	private int[] parent;//存储当前位置元素的根节点
	private int[] quantity;//表示以当前元素为根节点的集合中元素个数

	public UnionFind3(int size) {
		parent = new int[size];
		quantity = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			quantity[i] = 1;
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

		//根据以当前元素为根节点的集合中元素个数的大小来合并
		//将以当前元素为根节点的集合中元素个数小的合并到大的集合上面
		if(quantity[pRoot] < quantity[qRoot]){
			parent[pRoot] = qRoot;
			quantity[qRoot] += quantity[pRoot];
		}else {
			parent[qRoot] = pRoot;
			quantity[pRoot] += quantity[qRoot];
		}
	}
}
