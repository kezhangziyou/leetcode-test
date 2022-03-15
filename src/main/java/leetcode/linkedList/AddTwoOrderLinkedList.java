package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className MergeTwoOrderLinkedList
 * @description 两个链表相加，高位在开头
 * @date 3/4/22 4:46 PM
 **/
public class AddTwoOrderLinkedList {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		singleLinkedList1.add(7);
		singleLinkedList1.add(2);
		singleLinkedList1.add(4);
		singleLinkedList1.add(3);
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		singleLinkedList2.add(5);
		singleLinkedList2.add(6);
		singleLinkedList2.add(4);
		addTwoOrderLinkedList(singleLinkedList1.firstNode,singleLinkedList2.firstNode).print();
	}

	/**
	 * 最高位是链表的开始，需要利用栈来操作
	 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
	 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

	 * @param node1 7-2-4-3
	 * @param node2 5-6-4
	 * @return 7-8-0-7
	 */
	public  static ListNode addTwoOrderLinkedList(ListNode node1 , ListNode node2 ){
		if(node1==null && node2==null){
			return  null;
		}
		if(node1==null){
			return  node2;
		}
		if(node2==null){
			return  node1;
		}

		//利用栈反向相加
		//Stack<Integer> s1 = new Stack<>();
		//Stack<Integer> s2 = new Stack<>();
		Deque<Integer> s1 = new LinkedList<Integer>();
		Deque<Integer> s2 = new LinkedList<Integer>();

		ListNode cur1=node1;
		while (cur1!=null){
			s1.push(cur1.val);
			cur1=cur1.next;
		}
		ListNode cur2=node2;
		while (cur2!=null){
			s2.push(cur2.val);
			cur2=cur2.next;
		}
		ListNode newHead=null;
		int add=0;
		while (!s1.isEmpty()||!s2.isEmpty()||add!=0){
			int a=s1.isEmpty() ? 0 :s1.pop();
			int b=s2.isEmpty() ? 0 :s2.pop();
			int sum=a+b+add;
			add=sum/10;
			sum=sum%10;
			//链表方向移动
			ListNode cur = new ListNode(sum);
			cur.next=newHead;
			newHead=cur;
		}
		return newHead;
	}

}