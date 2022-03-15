package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description 删除节点,根据节点的个数删除
 * @date 3/4/22 8:35 PM
 **/
public class DeleteNode {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		System.out.println(deleteListNodeV1(singleLinkedList.firstNode,1));
		System.out.println(deleteListNodeV1(singleLinkedList.firstNode,1));

	}

	/**
	 * 根据节点的个数删除
	 * @param firstNode
	 * @param k 节点的个数
	 * @return
	 */
	public  static ListNode  deleteListNodeV1(ListNode firstNode ,int k){
		//如果链表为空
		if (firstNode == null ) {
			return null;
		}
		if(1==k){
			return firstNode.next;
		}
		//两个节点，一个当前节点的前节点
		ListNode preNode =firstNode;
		//一个当前节点
		ListNode current =preNode.next;
		int i=2;
		while(current!=null){
			//如果当前节点等于要删除的节点
			if(i==k){
				//一个当前节点的前节点指向当前节点的下一个节点
				preNode.next=current.next;
				return  firstNode;
			}
			//不等于，往后移动
			preNode=preNode.next;
			current=current.next;
			i++;

		}
		return null;

	}

	/**
	 * 根据节点的个数删除
	 * @param head
	 * @param data
	 * @return
	 */
	public  static ListNode  deleteListNodeV2(ListNode head ,int data){
		if(null ==head ){
			return head;
		}
		if(head.val ==data){
			return head.next;
		}
		if(null==head.next && data==head.val){
			return null;
		}
		ListNode cur =head;
		ListNode next =null;
		while (cur.next !=null){
			next=cur.next;
			if(next.val== data){
				cur.next=next.next;
			} else {
				cur=cur.next;
			}
		}

		return head;

	}

}