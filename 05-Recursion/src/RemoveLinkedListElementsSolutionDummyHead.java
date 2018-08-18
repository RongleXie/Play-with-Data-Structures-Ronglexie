/**
 * LeetCode 203
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * 删除链表中等于给定值 val 的所有节点
 *
 * 增加虚拟头节点处理方法
 *
 * @author ronglexie
 * @version 2018/8/12
 */

class RemoveLinkedListElementsSolutionDummyHead {
	public ListNode removeElements(ListNode head, int val) {

		/**定义虚拟节点*/
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode prev = dummyNode;

		while (prev.next != null){
			if(prev.next.val == val){
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			}else {
				prev = prev.next;
			}
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6};
		ListNode head = new ListNode(array);

		ListNode listNode = new RemoveLinkedListElementsSolutionDummyHead().removeElements(head, 3);

		System.out.println(listNode.toString());
	}
}

