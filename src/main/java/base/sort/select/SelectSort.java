package base.sort.select;

import java.util.Arrays;

/**
 * @author zhangke
 * @version 1.0
 * @className SelectSort
 * @description 选择排序
 * @date 3/6/22 2:42 PM
 **/
public class SelectSort {

	/**
	 * 选择排序：
	 * 比如在一个长度为N的无序数组中，在第一趟遍历N个数据，
	 * 找出其中最小的数值与第一个元素交换，第二趟遍历剩下的N-1个数据，
	 * 找出其中最小的数值与第二个元素交换......第N-1趟遍历剩下的2个数据，
	 * 找出其中最小的数值与第N-1个元素交换，至此选择排序完成。
	 **/
	public static void selectSort(int arr[]) {
		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {
			//记录第一个数，
			int temp = arr[i];
			//记录第一个数的下标
			int minIndex = i;
			//minIndex是 i-1个数的最小值
			for (int j = i + 1; j < length - 1; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[j];
					minIndex = j;
				}
			}
			//如果当前值不是最小值，交换i+minIndex
			if (i != minIndex) {
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}
}