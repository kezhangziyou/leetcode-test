package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

import java.util.Stack;

/**
 * @author zhangke
 * @version 1.0
 * @className ReverseLinkedList
 * @description 链表反转
 * @date 3/4/22 5:37 PM
 **/
public class ReverseLinkedList {
	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		//reverseLinkedListV1(singleLinkedList.firstListNode).print();
		System.out.println(reverseLinkedListV2(singleLinkedList.firstNode));
		;
	}

	/**
	 * 链表的反转
	 * @param firstNode
	 * @return
	 */
	public  static ListNode reverseLinkedListV1(ListNode firstNode ){
		//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
		if (firstNode == null || firstNode.next == null) {
			return firstNode;
		}
		//当前链表的头结点给当前节点
		ListNode currentNode = firstNode;
		//定义当前结点的下一个结点
		ListNode nextNode  = null;
		//反转后新链表的表头
		ListNode reverseFistNode = null;
		while (currentNode != null) {
			//暂时保存住当前结点的下一个结点，因为下一次要用
			nextNode  = currentNode.next;
			//将current的下一个结点指向新链表的头结点，新链表的最后一个节点的指引为空
			currentNode.next = reverseFistNode;
			//把当前节点给新链表的头结点，反向移动
			reverseFistNode = currentNode;
			// 操作结束后，current节点后移
			currentNode = nextNode ;
		}
		return reverseFistNode;
	}

	/**
	 * 利用栈
	 * @param firstNode
	 * @return
	 */
	public  static int[] reverseLinkedListV2(ListNode firstNode ){
		if (firstNode == null ) {
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点

		ListNode currentNode = firstNode;
		int length =0;
		while (currentNode != null) {
			stack.push(currentNode.val);
			// 操作结束后，current节点后移
			length++;
			currentNode = currentNode.next ;
		}
		int[] ints = new int[length];
		int j=0;
		while(!stack.isEmpty()){
			ints[j]=stack.pop();
			j++;
		}
		return ints;
	}

}