package problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className GenerateParenthesis FROM LEETCOE
 * @description
 * @date 3/2/22 4:55 PM
 **/
public class GenerateParenthesis {
	public static void main(String[] args) {
		int n=3;
		System.out.println(generateParenthesis(n));

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
}