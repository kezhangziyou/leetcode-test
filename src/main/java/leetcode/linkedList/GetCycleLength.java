package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description 有环链表中，获取环的长度。
 * @date 3/4/22 8:35 PM
 **/
public class GetCycleLength {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
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
		System.out.println(getCycleLength(node1));


	}


	/**
	 * 有环链表中，获取环的长度。
	 * @param firstNode
	 * @return
	 */
	public static int getCycleLength(ListNode firstNode) {
		if (firstNode == null ) {
			return 0;
		}
		ListNode first =firstNode;
		ListNode second =firstNode;
		//firstMeetListNode为第一次相遇时候的起点
		ListNode firstMeetListNode =null;
		while(second!=null&&second.next!=null){
			first=first.next;
			second=second.next.next;
			if(first==second){
				firstMeetListNode = first;
				break;
			}
		}
		//下次相遇一定在环上
		ListNode current = firstMeetListNode;
		int length = 0;
		while (current != null) {
			current = current.next;
			length++;
			//当current结点走到原点的时候
			if (current == firstMeetListNode) {
				return length;
			}
		}
		return length;
	}
}