package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description
 * @date 3/4/22 8:35 PM
 **/
public class HasCycle {

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
		System.out.println(hasCycle(node1)!= null);


	}

	/**
	 * 判断链表是否有环，如果有返回环的起始点
	 * @param firstListNode
	 * @return
	 */
	public  static ListNode  hasCycle(ListNode firstListNode ){
		//如果链表为空
		if (firstListNode == null ) {
			return null;
		}
		ListNode first =firstListNode;
		ListNode second =firstListNode;
		while(second!=null&&second.next!=null){
			first=first.next;
			second=second.next.next;
			if(first==second){
				return first;
			}
		}
		return null;

	}
}