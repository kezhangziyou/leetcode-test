package base.data.structure.heap;

/**
 * @author zhangke
 * @version 1.0
 * @className MinHeap
 * @description
 * @date 3/6/22 11:44 AM
 **/
public class MinHeap {
	public void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		buildMinHeap(array);
		for (int i = array.length - 1; i >= 1; i--) {
			swap(array, 0, i);
			MinHeap(array, i, 0);
		}
	}

	private  void buildMinHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {//i走一次才是4.
		// 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
		// *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
			MinHeap(array, array.length, i);
		}
	}
	//  从i节点开始调整,heapSize为节点总数 ，只是用来确定边界，从0开始计算 i节点的子节点为 2*i+1, 2*i+2
	private  void MinHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		// 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
		int smallest = index;
		// 存在左结点，且左结点的值大于根结点的值  ，heapSize为数组的长度
		if (left < heapSize && array[left] < array[index]) {
			smallest = left;
		}
		// 存在右结点，且右结点的值大于以上比较的较大值
		if (right < heapSize && array[right] < array[smallest]) {
			smallest = right;
		}
		// 左右结点的值都大于根节点，直接return，不做任何操作
		if (index != smallest) {
			// 交换根节点和左右结点中最大的那个值，把根节点的值替换下去
			swap(array, index, smallest);
			// 由于替换后左右子树会被影响，所以要对受影响的子树largest=index再进行heapify
			MinHeap(array, heapSize, smallest);
		}
	}

	private void swap(int[] arrays, int i, int j) {
		int temp;
		temp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = temp;
	}

	/**
	 * 每次插入都是将新数据放在数组最后。可以发现从这个新数据的父结点到根结点必然为一个有序的数列，现在的任务是将这个新数据插入到这个有序数据中。
	 * @param a
	 * @param i
	 */
	//  新加入i结点,  其父结点为(i - 1) / 2
	void MinHeapFixup(int a[], int i) {
		int j, temp;
		temp = a[i];
		j = (i - 1) / 2;      //父结点
		while (j >= 0 && i != 0)  {
			if (a[j] <= temp){
				break;
			}
			a[i] = a[j];     //把较大的子结点往下移动,替换它的子结点
			i = j;
			j = (i - 1) / 2;
		}
		a[i] = temp;
	}
}