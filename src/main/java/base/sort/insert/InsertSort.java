package base.sort.insert;

import java.util.Arrays;

/**
 * @author zhangke
 * @version 1.0
 * @className SelectSort
 * @description 插入排序
 * @date 3/6/22 2:42 PM
 **/
public class InsertSort {

	/**
	 * 当插入第i(i≥1)个对象时,前面的V\[0\],V\[1\],...,V\[i−1\]已经排好序。
	 * 这时,用V\[i\]的排序码与V\[i−1\],V\[i−2\],...,V\[0\]的排序码顺序进行比较,
	 * 找到插入位置即将V\[i\]插入,原来位置上的对象向后顺移。
	 * @param arr
	 */
	public static void insertSort(int arr[]) {
		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {
			//准备要去插入序列的数
			int insertVal = arr[i];
			//要插入的前一个数
			int index=i-1;
			//要插入的数和前一个数比较，如果要插入的数，比前一个数小
			while (index>=0&&insertVal<arr[index]) {
				//将arr[index]向后移动
				arr[index+1]=arr[index];
				//让index向前移动
				index--;
			}
			//将insertVal插入适当位置
			arr[index+1]=insertVal;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}
}