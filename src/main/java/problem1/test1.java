package problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangke
 * @version 1.0
 * @className test
 * @description
 * @date 2019/10/23 2:20 PM
 **/
public class test1 {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 2, 11, 15};
		int target = 4;
		Solution solution = new Solution();
		for (int item : solution.twoSum2(nums, target)) {
			System.out.println(item);
		}
	}
}


class Solution {
	/**
	 *最原始的方法,双重for循环,我的
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			result[0] = i;
			for (int j = 0; j < nums.length; j++) {
				if (j != i) {
					sum += nums[i]+nums[j];
					if (target == sum) {
						result[1] = j;
						return result;
					} else {
						sum=0;
					}
				}
			}
		}
		return result;
	}

	public int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> hashmap =new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hashmap.put(nums[i],i);
		}
		for (int i = 0; i < nums.length; i++) {
			int other =target-nums[i];
			if(hashmap.containsKey(other)&&hashmap.get(other)!=i){
				return  new int[]{i,hashmap.get(other) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}