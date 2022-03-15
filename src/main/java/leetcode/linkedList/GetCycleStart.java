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
public class GetCycleStart {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next=node2;
		node2.next=node1;
		//node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node3;
		System.out.println(getCycleStartV1(node1).val);
		//System.out.println(getCycleStartV2(node1).data);


	}

	/**
	 * 获取环的起始点。
	 * 到环的长度length之后，需要用到两个指针变量first和second，先让second指针走length步；
	 * 然后让first指针和second指针同时各走一步，当两个指针相遇时，相遇时的结点就是环的起始点。
	 * @param firstListNode
	 * @return
	 */
	public  static ListNode getCycleStartV1(ListNode firstListNode) {
		if (firstListNode == null ) {
			return null;
		}
		//找到链表的第一个相遇点
		ListNode first =firstListNode;
		ListNode second =firstListNode;
		//firstMeetListNode为第一次相遇时候的起点
		ListNode firstMeetListNode =null;
		while(second!=null&&second.next!=null){
			first=first.next;
			second=second.next.next;
			if(first==second){
				firstMeetListNode = second;
				break;
			}
		}

		if(second==null){
			return null;
		}


		//获取环的长度length
		ListNode current = firstMeetListNode;
		int length = 0;
		while (current != null) {
			current = current.next;
			length++;
			//当current结点走到原点的时候
			if (current == firstMeetListNode) {
				break;
			}
		}


		ListNode p1 = firstListNode;
		ListNode p2 = firstListNode;
		//先让second指针走length步
		for (int i = 0; i < length; i++) {
			p2 = p2.next;
		}
		//如果p1==p2
		if(firstMeetListNode==p2){
			return firstMeetListNode;
		}
		//然后让first指针和second指针同时各走一步
		while (p1 != null && second != null) {
			p1 = p1.next;
			p2 = p2.next;
			//如果两个指针相遇了，说明这个结点就是环的起始点
			if (p1 == p2) {
				return p1;
			}
		}
		return null;
	}

	/**
	 * 获取环的起始点。
	 * 链表共有 a+ba+b 个节点，其中 链表头部到链表入口 有 aa 个节点（不计链表入口节点）， 链表环 有 bb 个节点
	 * @param firstListNode
	 * @return
	 */
	public  static ListNode getCycleStartV2(ListNode firstListNode) {
		if (firstListNode == null ) {
			return null;
		}
		//找到第一个起始点，此时fast 和 slow分别走了走了f和s，相遇时，f=2s，且 f=s+nb，推出 s=nb
		ListNode fast = firstListNode, slow = firstListNode;
		while (true) {
			if (fast == null || fast.next == null) {
				return null;}
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow){
				break;
			}
		}
		//此时让 f=0，s=nb,下一次相遇时，肯定在环口，f=a，s=a+nb，
		fast = firstListNode;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

}