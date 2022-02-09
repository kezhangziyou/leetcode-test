package base.sort.bubble;

import java.util.Arrays;

/**
 * @author zhangke
 * @version 1.0
 * @description
 * 		第2版代码做了小小的改动， 利用布尔变量isSorted作为标
 * 		记。 如果在本轮排序中， 元素有交换， 则说明数列无序； 如果没有元素交换， 则说
 * 		明数列已然有序， 然后直接跳出大循环。
 *
 * @date 17:24 2022/2/9
 **/
public class BubbleSort1 {

	public static void sort(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			//有序标记， 每一轮的初始值都是true
			boolean isSorted = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				int tmp = 0;
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					//因为有元素进行交换， 所以不是有序的， 标记变为false
					isSorted = false;
				}
			}
			if(isSorted){
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
