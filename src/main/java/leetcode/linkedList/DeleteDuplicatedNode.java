package leetcode.linkedList;


import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description 删除重复的节点
 * @date 3/4/22 8:35 PM
 **/
public class DeleteDuplicatedNode {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(1);
		singleLinkedList.add(1);
		singleLinkedList.add(1);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		System.out.println(deleteDuplicatedListNode(singleLinkedList.firstNode));
		System.out.println(deleteDuplicatedListNodeV2(singleLinkedList.firstNode));

	}

	/**
	 * 重复的节点不连续
	 * 删除链表所有的重复节点,重复的元素在链表中出现的位置不一定是连续的，
	 * 当前外循环的节点为 cur，内循环从 cur 开始遍历，若碰到与 cur 节点的值相同的，则删除重复节点
	 *
	 * @param firstNode
	 * @return
	 */
	public  static ListNode deleteDuplicatedListNode(ListNode firstNode){
		if(null ==firstNode){
			return  null;
		}
		if(null ==firstNode.next){
			return 	firstNode;
		}
		//当前节点
		ListNode curNode = firstNode;
		//下一个节点
		ListNode nextNode =null;
		while (curNode != null) {
			nextNode=curNode;
			//因为重复的节点不连续，所有要遍历后面所有的节点
			while (nextNode.next != null) {
				if(nextNode.val==nextNode.next.val){
					nextNode.next=nextNode.next.next;
				} else {
					nextNode = nextNode.next;
				}
			}
			curNode = curNode.next;
		}
		return  firstNode;
	}


	/**
	 * 重复的节点连续
	 * 删除链表所有的重复节点,重复的元素在链表中出现的位置是连续的
	 * @param firstNode 0-0-0-0-1-1
	 * @return
	 */
	public  static ListNode  deleteDuplicatedListNodeV2(ListNode firstNode){
		if(null ==firstNode){
			return  null;
		}
		if(null ==firstNode.next){
			return 	firstNode;
		}
		//下一个节点
		ListNode curNode = firstNode;
		while (curNode.next != null) {
			//如果下一个节点和当前节点的值相同
				if(curNode.val==curNode.next.val){
					curNode.next=curNode.next.next;
				} else {
					//不相同就移动
					curNode = curNode.next;
				}
		}
		return  firstNode;
	}

}