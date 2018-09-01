/**
 * 并查集
 * 第六个版本，路径压缩优化,数组实现
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public class UnionFind6 implements UnionFind{

	private int[] parent;//存储当前位置元素的根节点
	private int[] rank;//表示以当前元素为根节点的高度

	public UnionFind6(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 1;
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
		//递归路径压缩
		if (p != parent[p]){
			parent[p] = find(parent[p]);
		}
		return parent[p];
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
		//根据以当前元素为根节点的高度来合并
		//将以当前元素为根节点的高度低的合并到高的集合上面
		if(rank[pRoot] < rank[qRoot]){
			parent[pRoot] = qRoot;
		}else if(rank[pRoot] > rank[qRoot]) {
			parent[qRoot] = pRoot;
		}else {
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}
	}
}
