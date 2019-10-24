package problem2;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhangke
 * @version 1.0
 * @className test2
 * @description
 * @date 2019/10/24 3:04 PM
 **/
public class test2 {
	public static  void main(String [] args){
		ListNode result1 = new ListNode(2);
		ListNode result2 = new ListNode(4);
		ListNode result3 = new ListNode(3);
		result1.next=result2;
		result1.next.next=result3;
		ListNode result4 = new ListNode(5);
		ListNode result5 = new ListNode(6);
		ListNode result6 = new ListNode(4);
		result4.next=result5;
		result4.next.next=result6;
		Solution solution = new Solution();
		ListNode result=solution.addTwoNumbers2(result1, result4);
		ListNode curr=result;
		while (curr!=null) {
			System.out.println(curr.val);
			curr=curr.next;
		}

	}

}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//新建一个起始节点
		ListNode result = new ListNode(0);
		ListNode p = l1, q = l2, current = result;
		//进位
		int carry = 0;
		while (p!= null|| q!= null) {
			//位数想加
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int  sum = x+y+carry;
			//取进位
			carry=sum/10;
			current.next=new ListNode(sum%10);
			current=current.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null)
			{
				q = q.next;
			}

		}
		//如果最后还有进位,则新建一个
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return  result.next;

	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		//进位
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null)
			{
				q = q.next;
			}
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;


	}
}