package problem20;

/**
 * @author zhangke
 * @version 1.0
 * @className LengthOfLastWord
 * @description  最后一个单词的长度,FROM LEETCOE
 * @date 3/2/22 3:34 PM
 **/
public class LengthOfLastWord {
	public static void main(String[] args) {
	System.out.println(lengthOfLastWord("   fly me   to   the moon  "));

	}

	public static int lengthOfLastWord(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}
		int result = 0;
		int length = s.length();
		int i=length-1;
		//找到第一个不为空的字符串
		while (s.charAt(i) == ' '){
			i--;
		}
		while (i>=0&&s.charAt(i) != ' '){
			i--;
			result++;
		}
		return result;
	}
}