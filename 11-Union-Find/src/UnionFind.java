/**
 * 并查集
 *
 * @author ronglexie
 * @version 2018/9/1
 */
public interface UnionFind {

	/**
	 * 获取并查集的大小
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	int getSize();

	/**
	 * 查询两个元素是否相连
	 *
	 * @param p
	 * @param q
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	boolean isConnected(int p, int q);

	/**
	 * 将两个元素并在一起
	 *
	 * @param p
	 * @param q
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	void unionElements(int p, int q);
}
