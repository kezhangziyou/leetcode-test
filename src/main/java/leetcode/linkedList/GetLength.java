package leetcode.linkedList;


import leetcode.linkedList.data.ListNode;

/**
 * @author zhangke
 * @version 1.0
 * @className GetLength
 * @description SingleLinkedList
 * @date 3/4/22 4:11 PM
 **/
public class GetLength {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node3;
		System.out.println(getLength(node1));
	}

	/**
	 * 获取单链表的长度
	 * @param firstNode
	 * @return
	 */
	public static int getLength(ListNode firstNode) {
		if (firstNode == null) {
			return 0;
		}
		int length = 0;
		ListNode current = firstNode;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

}