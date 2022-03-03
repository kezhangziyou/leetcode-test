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
	 * @param srcArray 有序数组
	 * @param key 查找元素
	 * @return key的数组下标，没找到返回-1
	 */
	public static void main(String[] args) {
		int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
		System.out.println(binSearchv2(srcArray, 0, srcArray.length - 1, 80));
	}

	// 二分查找递归实现
	public static int binSearch(int srcArray[], int start, int end, int key) {
		int mid = (end - start) / 2 + start;
		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return -1;
		} else if (key > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, key);
		}
		return -1;
	}

	// 二分查找递归实现,如果找不到，找到插入的位置
	public static int binSearchv2(int srcArray[], int start, int end, int key) {
		int mid = (end - start) / 2 + start;
		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return srcArray[start]>key ? start :start+1;
		} else if (key > srcArray[mid]) {
			return binSearchv2(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearchv2(srcArray, start, mid - 1, key);
		}
		return -1;
	}

	// 二分查找普通循环实现
	public static int binSearch(int srcArray[], int key) {
		int mid = srcArray.length / 2;
		if (key == srcArray[mid]) {
			return mid;
		}

		int start = 0;
		int end = srcArray.length - 1;
		while (start <= end) {
			mid = (end - start) / 2 + start;
			if (key < srcArray[mid]) {
				end = mid - 1;
			} else if (key > srcArray[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}