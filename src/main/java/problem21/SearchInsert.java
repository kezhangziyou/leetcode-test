package problem21;

/**
 * @author zhangke
 * @version 1.0
 * @className SearchInsert FROM LEETCOE
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @date 3/2/22 4:03 PM
 **/
public class SearchInsert {
	public static void main(String[] args) {
		int[] arr={1,3,5,6};
		int target=4;
		System.out.println(searchInsert(arr, target));

	}
	public static int searchInsert(int[] nums, int target) {
		int length=nums.length;
		int mid =length/2;
		if(nums[mid]==target){
			return mid;
		}

		return binSearch(nums, 0, nums.length - 1, target);
	}

	// 二分查找递归实现,如果找不到，找到插入的位置
	public static int binSearch(int srcArray[], int start, int end, int key) {
		int mid = (end - start) / 2 + start;
		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return srcArray[start]>key ? start :start+1;
		} else if (key > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, key);
		}
		return -1;
	}
}