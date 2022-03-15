package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;


/**
 * @author zhangke
 * @version 1.0
 * @className GetFirstCommonListNode
 * @description 判断两个单链表相交的第一个交点
 * @date 3/4/22 8:35 PM
 **/
public class GetFirstCommonNode {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next=node2;
		node2.next=node3;
		node3.next=node6;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		System.out.println(getFirstCommonListNode(node1,node4));


	}

	/**
	 * 方法一：先算出哪个长，哪个短，让短的先走，然后一起走，比较
	 * @param head1
	 * @param head2
	 * @return
	 */
	public  static ListNode  getFirstCommonListNode(ListNode head1,ListNode head2 ){
		if (head1 == null || head2 == null) {
			return null;
		}
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		//两个链表长度的差值
		int lengthDif = 0;

		ListNode longHead;
		ListNode shortHead;

		//找出较长的那个链表
		if (length1 > length2) {
			longHead = head1;
			shortHead = head2;
			lengthDif = length1 - length2;
		} else {
			longHead = head2;
			shortHead = head1;
			lengthDif = length2 - length1;
		}
		//将较长的那个链表的指针向前走length个距离
		for (int i = 0; i < lengthDif; i++) {
			longHead = longHead.next;
		}
		//将两个链表的指针同时向前移动
		while (longHead != null && shortHead != null) {
			//第一个相同的结点就是相交的第一个结点
			if (longHead == shortHead) {
				return longHead;
			}
			longHead = longHead.next;
			shortHead = shortHead.next;
		}
		return null;

	}

	//方法：获取单链表的长度
	public static int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		ListNode current = head;
		while (current != null) {

			length++;
			current = current.next;
		}
		return length;
	}

	/**
	 * 双指针
	 * 使用双指针的方法，可以将空间复杂度降至 O(1)O(1)。
	 *
	 * 只有当链表 headA 和headB 都不为空时，两个链表才可能相交。因此首先判断链表 headA 和 headB 是否为空，如果其中至少有一个链表为空，则两个链表一定不相交，返回 null。
	 * 当链表 headA 和 headB 都不为空时，创建两个指针 pA 和 pB，初始时分别指向两个链表的头节点 headA 和 headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
	 *
	 * 每步操作需要同时更新指针 pA 和 pB。
	 * 如果指针 pA 不为空，则将指针 pA 移到下一个节点；
	 * 如果指针 pB 不为空，则将指针 pB 移到下一个节点。
	 * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；
	 * 如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
	 * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
	 * @param headA
	 * @param headB
	 * @return
	 */
	public  static ListNode  getFirstCommonListNodeV2(ListNode headA,ListNode headB ){
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;

	}


}