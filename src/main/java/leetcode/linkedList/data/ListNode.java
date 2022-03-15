package leetcode.linkedList.data;

/**
 * @author zhangke
 * @version 1.0
 * @className ListNode
 * @description
 * @date 3/4/22 4:04 PM
 **/
public class ListNode {
	//注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
	/**
	 * //数据域
	 */
	public int val;
	/**
	 * 指针域
	 */
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val; this.next = next; }

	/**
	 * 打印链表
	 * @return
	 */
	public void print() {
		System.out.println(val);
		if (next == null) {
		}
		ListNode current = next;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

}