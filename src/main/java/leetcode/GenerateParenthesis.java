package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className GenerateParenthesis FROM LEETCOE
 * @description 括号生成
 * @date 3/2/22 4:55 PM
 **/
public class GenerateParenthesis {
	public static void main(String[] args) {
		int n=3;
		System.out.println(generateParenthesisV2(n));

	}

	/**
	 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
	 * 输入：n = 3
	 * 输出：["((()))","(()())","(())()","()(())","()()()"]
	 * 输入：n = 2
	 * 输出：["()","()","()","()"]
	 * 输入：n = 1
	 * 输出：["()"]
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<>();
		return list;
	}

	/**
	 * 深度优先遍历
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesisV2(int n) {

		List<String> res = new ArrayList<>();
		// 特判
		if (n == 0) {
			return res;
		}

		// 执行深度优先遍历，搜索可能的结果
		dfs("", n, n, res);
		return res;

	}
	/**
	 * 不符合条件的括号是左边
	 * @param curStr 当前递归得到的结果
	 * @param left   左括号还有几个可以使用
	 * @param right  右括号还有几个可以使用
	 * @param res    结果集
	 */
	private static void dfs(String curStr, int left, int right, List<String> res) {
		// 因为每一次尝试，都使用新的字符串变量，所以无需回溯
		// 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
		if (left == 0 && right == 0) {
			res.add(curStr);
			return;
		}

		// 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
		if (left > right) {
			return;
		}

		if (left > 0) {
			dfs(curStr + "(", left - 1, right, res);
		}

		if (right > 0) {
			dfs(curStr + ")", left, right - 1, res);
		}
	}

}