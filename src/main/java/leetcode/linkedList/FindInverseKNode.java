package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className FindInverseKListNode
 * @description 查找倒数第 K 个节点
 * @date 3/4/22 4:19 PM
 **/
public class FindInverseKNode {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		ListNode firstNode = singleLinkedList.firstNode;
		System.out.println(findInverseKListNodeV1(firstNode,2));
		System.out.println(findInverseKListNodeV2(firstNode,2));
	}

	/**
	 * 版本 1：先算出链表额长度，在循环
	 * @param firstNode
	 * @param k
	 * @return
	 */
	public  static int  findInverseKListNodeV1(ListNode firstNode ,int k){
		if(firstNode==null){
			return  -1;
		}
		ListNode current =firstNode;
		int length= 0;
		while(current!=null){
			length++;
			current=current.next;

		}
		current =firstNode;
		for (int i = 0; i < length-k; i++) {
			current=current.next;
		}

		return current.val;
	}

	/**
	 * 版本 2:两个指针，即两个结点型的变量first和second，首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，
	 * 此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置
	 * @param headNode
	 * @param k
	 * @return
	 */
	public  static int  findInverseKListNodeV2(ListNode headNode ,int k){
		if(headNode==null){
			return  -1;
		}
		//首先让first和second都指向第一个结点
		ListNode firstNode =headNode;
		ListNode secondNode =headNode;
		//然后让second结点往后挪k-1个位置
		for (int i = 0; i <k ; i++) {
			secondNode=secondNode.next;
			//如果链表的长度小于看，返回 null
			if(secondNode==null){
				return  -1;
			}
		}
		//此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候
		while (firstNode!=null && firstNode!=null){
			firstNode=firstNode.next;
			secondNode=secondNode.next;
		}

		return firstNode.val;
	}

}