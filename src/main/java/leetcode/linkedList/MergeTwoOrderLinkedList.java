package leetcode.linkedList;


import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className MergeTwoOrderLinkedList
 * @description 合并两个有序链表
 * @date 3/4/22 4:46 PM
 **/
public class MergeTwoOrderLinkedList {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		singleLinkedList1.add(1);
		singleLinkedList1.add(3);
		singleLinkedList1.add(4);
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		singleLinkedList2.add(1);
		singleLinkedList2.add(2);
		singleLinkedList2.add(3);
		singleLinkedList2.add(4);
		singleLinkedList2.add(5);
		ListNode firstNode1 = singleLinkedList1.firstNode;
		ListNode firstNode2 = singleLinkedList2.firstNode;
		mergeTwoOrderLinkedList(firstNode1,firstNode2).print();
	}



	/**
	 *  直接添加
	 * @param node1
	 * @param node2
	 * @return
	 */
	public  static ListNode  mergeTwoOrderLinkedList(ListNode node1 ,ListNode node2 ){
		if(node1==null && node2==null){
			return  null;
		}
		if(node1==null){
			return  node2;
		}
		if(node2==null){
			return  node1;
		}

		ListNode headNode =null;
		ListNode currentNode =null;

		ListNode head1 =node1;
		ListNode head2 =node2;


		if(head1.val <head2.val){
			headNode=head1;
			currentNode=head1;
			head1=head1.next;
		} else {
			headNode=head2;
			currentNode=head2;
			head2=head2.next;
		}


		while (head1!=null && head2!=null){
			if(head1.val<=head2.val){
				currentNode.next=head1;
				currentNode= currentNode.next;
				head1=head1.next;
			} else {
				currentNode.next=head2;
				currentNode= currentNode.next;
				head2=head2.next;
			}
		}
		//合并剩余的元素,两个指针已移动，不用再次遍历寻找位置
		//说明链表2遍历完了，是空的
		if (head1 != null) { 
			currentNode.next = head1;
		}
		//说明链表1遍历完了，是空的
		if (head2 != null) {
			currentNode.next = head2;
		}
		return headNode;
	}



}