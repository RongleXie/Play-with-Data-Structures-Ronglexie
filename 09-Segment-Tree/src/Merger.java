/**
 * 融合器
 *
 * @author ronglexie
 * @version 2018/8/25
 */
public interface Merger<E> {
	/**
	 * 融合两个元素
	 *
	 * @param a
	 * @param b
	 * @return E
	 * @author ronglexie
	 * @version 2018/8/25
	 */
	E merge(E a, E b);
}
