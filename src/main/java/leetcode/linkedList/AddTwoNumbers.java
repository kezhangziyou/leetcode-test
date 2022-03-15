package leetcode.linkedList;


import leetcode.linkedList.data.ListNode;

/**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class AddTwoNumbers {
	public static  void main(String [] args){
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node4.next=node5;
		node5.next=node6;
		ListNode result=addTwoNumbers(node1, node4);
		ListNode curr=result;
		while (curr!=null) {
			System.out.println(curr.val);
			curr=curr.next;
		}

	}

	/**
	 * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1和 l2的表头开始相加。
	 * 由于每位数字都应当处于 0…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。例如，5+7=12。
	 * 在这种情况下，我们会将当前位的数值设置为2，并将进位carry=1带入下一次迭代。
	 * 进位 carry必定是 0或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为9+9+1=19。

	 * 测试用例	说明
	 * l1=[0,1]l1=[0,1]，l2=[0,1,2]l2=[0,1,2]	当一个列表比另一个列表长时
	 * l1=[]l1=[]，l2=[0,1]l2=[0,1]	当一个列表为空时，即出现空列表
	 * l1=[9,9]l1=[9,9]，l2=[1]l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//将当前结点初始化为返回列表的哑结点。
		ListNode dummyHead = new ListNode(0);
		//将 p和 q分别初始化为列表 l1 和 l2 的头部。
		ListNode p = l1, q = l2, curr = dummyHead;
		//进位, 将进位 carry初始化为 0。
		int carry = 0;
		//遍历列表 l1 和 l2直至到达它们的尾端。
		while (p != null || q != null) {
			//将 x设为结点 p的值。如果 p已经到达 l1的末尾，则将其值设置为 0。
			//将 y设为结点 q的值。如果 q已经到达 l2的末尾，则将其值设置为 0。
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			//设定sum=x+y+carry。
			int sum = carry + x + y;
			//更新进位的值，carry=sum/10。
			carry = sum / 10;
			//创建一个数值为sum%10的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。

			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			//同时，将 p和 q前进到下一个结点。
			if (p != null) {
				p = p.next;
			}
			if (q != null)
			{
				q = q.next;
			}
		}
		//* 检查carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 1的新结点。
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		//返回哑结点的下一个结点。
		return dummyHead.next;
	}
}