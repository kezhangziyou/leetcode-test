package leetcode.linkedList.data;


/**
 * @author zhangke
 * @version 1.0
 * @className SingleLinkedList
 * @description 单链表
 * @date 3/4/22 4:11 PM
 **/
public class SingleLinkedList {
	/**
	 * 链表的成员变量
	 * 每个链表都有一个头结点头结点
	 */
	public ListNode firstNode;
	/**
	 * 当前节点
	 */
	public ListNode currentNode;

	/**
	 * 像单链表中添加数据
	 * @param data
	 */
	public void add(int data) {
		//判断链表为空的时候
		//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
		if (firstNode == null) {
			ListNode newListNode = new ListNode(data);
			firstNode = newListNode;
			//将生成的节点个当前节点
			currentNode = newListNode;
		} else {
			//创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			ListNode newListNode = new ListNode(data);
			//前一个节点的引用指向当前生成的节点
			currentNode.next = newListNode;
			//把链表的当前索引向后移动一位，此步操作完成之后，currentListNode结点指向新添加的那个结点
			currentNode = currentNode.next;
		}
	}



	/**
	 * 打印链表
	 * @return
	 */
	public void print() {
		if (firstNode == null) {

		}
		ListNode current = firstNode;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

}