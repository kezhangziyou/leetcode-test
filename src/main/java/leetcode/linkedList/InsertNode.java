package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description 在链表指定位置插入节点
 * @date 3/4/22 8:35 PM
 **/
public class InsertNode {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		System.out.println(insertListNode(singleLinkedList.firstNode,3));

	}

	/**
	 *
	 * @param firstNode
	 * @return
	 */
	public  static ListNode  insertListNode(ListNode firstNode,int k){
		if(null ==firstNode|| k<1){
			return  null;
		}
		if(1==k){
			ListNode newFirst =new ListNode(k);
			newFirst.next=firstNode;
			return  newFirst;
		} else {
			ListNode current=firstNode;
			int i=2;
			while (current!=null){
				//要插入节点的位置，当前节点的下一个节点
				ListNode insertListNode =current.next;
				if(k==i){
					ListNode node = new ListNode(k);
					current.next=node;
					node.next=insertListNode;
				}
				current=current.next;
				i++;
			}
		}

		return  firstNode;

	}
}