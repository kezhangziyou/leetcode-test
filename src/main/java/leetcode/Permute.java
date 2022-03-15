package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className Permute
 * @description
 * @date 3/8/22 6:47 PM
 **/
public class Permute {
	public static void main(String[] args) {
		int[] nums={1,2,3};
		String str="abc";
		//System.out.println(permute(nums));
		System.out.println(permute1(str.toCharArray()));

	}

	public static List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		// 使用一个动态数组保存所有可能的全排列
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		boolean[] used = new boolean[len];
		Deque<Integer> path = new ArrayDeque<>(len);

		dfs(nums, len, 0, path, used, res);
		return res;
	}

	private static void dfs(int[] nums, int len, int depth,
					 Deque<Integer> path, boolean[] used,
					 List<List<Integer>> res) {
		if (depth == len) {
			//这里要做一个拷贝，否则回溯会破坏内容
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				path.addLast(nums[i]);
				used[i] = true;
				dfs(nums, len, depth + 1, path, used, res);
				//状态重置，和删除使用的元素
				used[i] = false;
				path.removeLast();
			}
		}
	}


	public static List<String> permute1(char[] nums) {
		int len = nums.length;
		// 使用一个动态数组保存所有可能的全排列
		List<String> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		boolean[] used = new boolean[len];
		StringBuffer stringBuffer = new StringBuffer();
		//Deque<Character> path = new ArrayDeque<>(len);

		dfs1(nums, len, 0, stringBuffer, used, res);
		return res;
	}

	private static void dfs1(char[] nums, int len, int depth,
							 StringBuffer stringBuffer , boolean[] used,
							List<String> res) {
		if (depth == len) {
			//这里要做一个拷贝，否则回溯会破坏内容
			res.add(stringBuffer.toString());
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				stringBuffer.append(nums[i]);
				used[i] = true;
				dfs1(nums, len, depth + 1, stringBuffer, used, res);
				//状态重置，和删除使用的元素
				used[i] = false;
				stringBuffer.deleteCharAt(stringBuffer.length()-1);
			}
		}
	}





}