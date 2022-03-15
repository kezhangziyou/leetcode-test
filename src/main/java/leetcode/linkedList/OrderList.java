package leetcode.linkedList;

import leetcode.linkedList.data.ListNode;
import leetcode.linkedList.data.SingleLinkedList;

/**
 * @author zhangke
 * @version 1.0
 * @className HasCycle
 * @description 对链表进行排序
 * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
 * @date 3/4/22 8:35 PM
 **/
public class OrderList {

	public static void main(String[] args) {

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(4);
		singleLinkedList.add(5);
		singleLinkedList.add(3);
		singleLinkedList.add(1);
		singleLinkedList.add(2);
		System.out.println(OrderListV1(singleLinkedList.firstNode));

	}

	/**
	 * 冒泡排序
	 * @param firstNode
	 * @return
	 */
	public  static ListNode OrderListV1(ListNode firstNode){
		//下一个节点
		ListNode nextNode = null;
		//缓存值
		int tmp = 0;
		//当前第一个节点i=1
		ListNode curNode = firstNode;
		while (curNode.next != null) {
			//当前下一个节点j=2，从当前节点开始找到以后最小的节点替换
			nextNode = curNode.next;
			while (nextNode != null) {
				//如果下一个节点小于当前节点的值，交换
				if (curNode.val > nextNode.val) {
					tmp = curNode.val;
					curNode.val = nextNode.val;
					nextNode.val = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return  firstNode;

	}

	/**
	 * 自顶向下归并排序:
	 * 对链表自顶向下归并排序的过程如下。
	 *
	 * 1.找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 22 步，
	 * 慢指针每次移动 1步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
	 * 2.对两个子链表分别排序。
	 * 3.将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
	 *
	 时间复杂度：O(n \log n)O(nlogn)，其中 nn 是链表的长度。
	 空间复杂度：O(\log n)O(logn)，其中 nn 是链表的长度。空间复杂度主要取决于递归调用的栈空间。


	 * @param head
	 * @return
	 */
	public ListNode sortListV2(ListNode head) {
		return sortListV2(head, null);
	}

	public ListNode sortListV2(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		ListNode list1 = sortListV2(head, mid);
		ListNode list2 = sortListV2(mid, tail);
		ListNode sorted = merge(list1, list2);
		return sorted;
	}

	/**
	 * 自底向上归并排序
	 * @param head
	 * @return
	 */
	public ListNode sortListV3(ListNode head) {
		if (head == null) {
			return head;
		}
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		ListNode dummyHead = new ListNode(0, head);
		for (int subLength = 1; subLength < length; subLength <<= 1) {
			ListNode prev = dummyHead, curr = dummyHead.next;
			while (curr != null) {
				ListNode head1 = curr;
				for (int i = 1; i < subLength && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode head2 = curr.next;
				curr.next = null;
				curr = head2;
				for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode next = null;
				if (curr != null) {
					next = curr.next;
					curr.next = null;
				}
				ListNode merged = merge(head1, head2);
				prev.next = merged;
				while (prev.next != null) {
					prev = prev.next;
				}
				curr = next;
			}
		}
		return dummyHead.next;
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}


}