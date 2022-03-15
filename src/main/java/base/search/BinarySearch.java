package base.search;

/**
 * @author zhangke
 * @version 1.0
 * @className BinarySearch
 * @description
 * @date 3/2/22 4:14 PM
 **/
public class BinarySearch {
	/**
	 * 二分查找算法
	 *
	 * @param arr 有序数组
	 * @param key 查找元素
	 * @return key的数组下标，没找到返回-1
	 */
	public static void main(String[] args) {
		int arr[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
		System.out.println(binSearchV2(arr, 0, arr.length - 1, 80));
	}

	/**
	 * 二分查找递归实现
	 * @param arr
	 * @param left
	 * @param right
	 * @param key
	 * @return
	 */
	public static int binSearch(int arr[], int left, int right, int key) {
		int mid = (right - left) / 2 + left;
		if (arr[mid] == key) {
			return mid;
		}
		if (key<arr[left]||key>arr[right]||left >= right) {
			return -1;
		} else if (key > arr[mid]) {
			//比关键字大则关键字在左区域
			return binSearch(arr, mid + 1, right, key);
		} else if (key < arr[mid]) {
			//比关键字小则关键字在右区域
			return binSearch(arr, left, mid - 1, key);
		}
		return -1;
	}

	/**
	 *  二分查找递归实现,如果找不到，找到插入的位置
	 * @param arr
	 * @param left
	 * @param right
	 * @param key
	 * @return
	 */
	public static int binSearchV2(int arr[], int left, int right, int key) {
		int mid = (right - left) / 2 + left;
		if (arr[mid] == key) {
			return mid;
		}
		if (left >= right) {
			return arr[left]>key ? left :left+1;
		} else if (key > arr[mid]) {
			return binSearchV2(arr, mid + 1, right, key);
		} else if (key < arr[mid]) {
			return binSearchV2(arr, left, mid - 1, key);
		}
		return -1;
	}

	/**
	 *  二分查找普通循环实现
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int binSearch(int arr[], int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid = arr.length / 2;
		if (key < arr[left] || key > arr[right] || left > right) {
			return -1;
		}

		if (key == arr[mid]) {
			return mid;
		}

		while (left <= right) {
			mid = (right - left) / 2 + left;
			if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 寻找左侧边界的二分搜索,[left, right]
	 * title:commonBinarySearch
	 *
	 * @param nums
	 * @param target
	 * @return 关键字位置
	 */
	public static int leftBound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		// 搜索区间为 [left, right]
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				// 搜索区间变为 [mid+1, right]
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 搜索区间变为 [left, mid-1]
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 收缩右侧边界
				right = mid - 1;
			}
		}
		// 检查出界情况,left == right + 1,如果当前数组的所有的元素都大于 target
		if (left >= nums.length || nums[left] != target) {
			return -1;
		}
		return left;
	}

}