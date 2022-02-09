package base.sort.bubble;

import java.util.Arrays;

/**
 * @author zhangke
 * @version 1.0
 * @description 最一般的排序算法
 * @date 17:24 2022/2/9
 **/
public class BubbleSort {

	public static void sort(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int tmp = 0;
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
