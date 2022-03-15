package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className FindMiddleNode
 * @description 查找中间节点
 * @date 3/4/22 4:19 PM
 **/
public class FindMiddleNode {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		ListNode firstNode = singleLinkedList.firstNode;
		System.out.println(findMiddleListNode(firstNode));
	}


	/**
	 * 两个指针，一个走两步，一个走一步,块指针走到尾部，慢指针就是中间节点了
	 * @param headNode
	 * @return
	 */
	public  static int  findMiddleListNode(ListNode headNode){
		if(headNode==null){
			return  -1;
		}

		ListNode firstNode =headNode;
		ListNode secondNode =headNode;

		while (firstNode!=null && secondNode.next!=null){
			firstNode=firstNode.next;
			secondNode=secondNode.next.next;
		}

		//上方代码中，当n为偶数时，得到的中间结点是第n/2 + 1个结点。比如链表有6个节点时，得到的是第4个节点。
		return firstNode.val;
	}

}