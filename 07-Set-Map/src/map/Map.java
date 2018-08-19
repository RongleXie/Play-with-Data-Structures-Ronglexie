package map;

/**
 * 映射
 *
 * @author ronglexie
 * @version 2018/8/19
 */
public interface Map<K,V> {

	/**
	 * 添加元素
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	void add(K key,V value);

	/**
	 * 删除元素
	 *
	 * @param key
	 * @return V
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	V remove(K key);

	/**
	 * 查看是否包含某个key
	 *
	 * @param key
	 * @return boolean
	 * @author ronglexie
	 * @valueersion 2018/8/19
	 */
	boolean contains(K key);

	/**
	 * 获取某个key对应的value
	 *
	 * @param key
	 * @return V
	 * @author ronglexie
	 * @valueersion 2018/8/19
	 */
	V get(K key);

	/**
	 * 更新某个key对应的value
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	void set(K key ,V value);

	/**
	 * 获取大小
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	int getSize();

	/**
	 * 查看是否为空
	 *
	 * @param
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/8/19
	 */
	boolean isEmpty();
}
