package problem24;

/**
 * @author zhangke
 * @version 1.0
 * @className Multiply from leetcode
 * @description
 * @date 3/2/22 5:36 PM
 **/
public class Multiply {
	public static void main(String[] args) {

		String str1="1234";
		String str2="567";
		System.out.println(multiplyV1(str1,str2));

	}

	/**
	 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
	 *
	 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiplyV1(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String ans = "0";
		//从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加
		//被乘数为 num1、乘数为 num2
		int m = num1.length(), n = num2.length();
		for (int i = n - 1; i >= 0; i--) {
			StringBuffer curr = new StringBuffer();
			int add = 0;
			//判断补0的个数
			for (int j = n - 1; j > i; j--) {
				curr.append(0);
			}
			int y = num2.charAt(i) - '0';
			for (int j = m - 1; j >= 0; j--) {
				int x = num1.charAt(j) - '0';
				int product = x * y + add;
				curr.append(product % 10);
				add = product / 10;
			}
			if (add != 0) {
				curr.append(add % 10);
			}
			ans = addStrings(ans, curr.reverse().toString());
		}
		return ans;
	}

	public static String addStrings(String num1, String num2) {
		int i = num1.length() - 1, j = num2.length() - 1, add = 0;
		StringBuffer ans = new StringBuffer();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		ans.reverse();
		return ans.toString();
	}

	public static String multiplyV2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int m = num1.length(), n = num2.length();
		int[] ansArr = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			int x = num1.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				int y = num2.charAt(j) - '0';
				ansArr[i + j + 1] += x * y;
			}
		}
		for (int i = m + n - 1; i > 0; i--) {
			ansArr[i - 1] += ansArr[i] / 10;
			ansArr[i] %= 10;
		}
		int index = ansArr[0] == 0 ? 1 : 0;
		StringBuffer ans = new StringBuffer();
		while (index < m + n) {
			ans.append(ansArr[index]);
			index++;
		}
		return ans.toString();
	}
}