import java.util.TreeMap;

/**
 * 哈希表
 *
 * @author ronglexie
 * @version 2018/9/6
 */
public class HashTable<K, V> {

	/** 最大容忍度，及上界*/
	public static final int upperTol = 10;
	/** 最小容忍度，及下界*/
	public static final int lowerTol = 2;
	/** 初始化容量*/
	public static final int initCapacity = 7;

	private TreeMap<K, V>[] hashTable;
	private int M;
	private int size;

	public HashTable(int M){
		this.M = M;
		size = 0;
		hashTable = new TreeMap[M];
		for (int i = 0; i < M; i++) {
			hashTable[i] = new TreeMap<>();
		}
	}

	public HashTable(){
		this(initCapacity);
	}

	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	private int hash(K key){
		return key.hashCode() & 0x7fffffff % M;
	}

	/**
	 * 向哈希表中添加元素
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/6
	 */
	public void add(K key, V value){
		TreeMap<K, V> treeMap = hashTable[hash(key)];
		if (treeMap.containsKey(key)){
			treeMap.put(key,value);
		}else {
			treeMap.put(key,value);
			size ++;

			//扩容
			if(size >= upperTol * M){
				resize(2*M);
			}
		}
	}

	/**
	 * 从哈希表中移除元素
	 *
	 * @param key
	 * @return V
	 * @author ronglexie
	 * @version 2018/9/6
	 */
	public V remove(K key){
		TreeMap<K, V> treeMap = hashTable[hash(key)];
		V result = null;
		if(treeMap.containsKey(key)){
			result = treeMap.remove(key);
			size --;

			//缩容
			if(size < lowerTol * M && M / 2 > initCapacity){
				resize(M/2);
			}
		}
		return result;
	}

	/**
	 * 修改哈希表中的元素
	 *
	 * @param key
	 * @param value
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/6
	 */
	public void set(K key, V value){
		TreeMap<K, V> treeMap = hashTable[hash(key)];
		V result = null;
		if(!treeMap.containsKey(key)){
			throw new IllegalArgumentException(key + "doesn't exists!");
		}
		treeMap.put(key, value);
	}

	/**
	 * 查询哈希表中是否包含某个元素
	 *
	 * @param key
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/6
	 */
	public boolean contains(K key){
		return hashTable[hash(key)].containsKey(key);
	}

	/**
	 * 从哈希表中获取一个元素
	 *
	 * @param key
	 * @return V
	 * @author ronglexie
	 * @version 2018/9/6
	 */
	public V get(K key){
		return hashTable[hash(key)].get(key);
	}

	/**
	 * 修改容量
	 *
	 * @param newCapacity
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/7
	 */
	private void resize(int newCapacity) {
		TreeMap<K, V>[] newHashTable = new TreeMap[newCapacity];
		for (int i = 0; i < newCapacity; i++) {
			newHashTable[i] = new TreeMap<>();
		}

		int oldM = this.M;
		this.M = newCapacity;
		for (int i = 0; i < oldM; i++) {
			TreeMap<K, V> treeMap = hashTable[i];
			for (K key : treeMap.keySet()) {
				newHashTable[hash(key)].put(key, treeMap.get(key));
			}
		}
		this.hashTable = newHashTable;
	}
}
