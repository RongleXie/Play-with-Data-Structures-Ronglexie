/**
 * @author ronglexie
 * @version 2018/8/12
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode(int[] array) {
		if (array == null) {
			this.next = null;
		}
		this.val = array[0];
		ListNode cur = this;
		for (int i = 1; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		ListNode cur = this;
		result.append(this.val + "->");
		while (cur.next != null){
			result.append(cur.next.val + "->");
			cur = cur.next;
		}
		result.append("NULL");
		return result.toString();
	}
}
