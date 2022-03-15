package base.data.structure.heap;

/**
 * @author zhangke
 * @version 1.0
 * @className MaxHeap
 * @description
 * @date 3/6/22 11:43 AM
 **/
public class MaxHeap {
	public static void main(String[] args) {

	}

	/**
	 * 最大堆排序
	 * @param array
	 */
	public void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		//构建最大堆
		buildMaxHeap(array);
		for (int i = array.length - 1; i >= 1; i--) {
			swap(array, 0, i);
			maxHeap(array, i, 0);
		}
	}

	private void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			// 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
			// *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
			maxHeap(array, array.length, i);
		}
	}

	/**
	 * 从i节点开始调整,heapSize为节点总数 从0开始计算i节点的子节点为 2*i+1, 2*i+2
	 *
	 * @param array
	 * @param heapSize
	 * @param index
	 */
	private void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		// 这是一个临时变量，表示 根结点、左结点、右结点中最小的值的结点的下标
		int largest = index;
		// 存在左结点，且左结点的值大于根结点的值  ，heapSize为数组的长度
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}
		// 存在右结点，且右结点的值大于以上比较的较大值
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}
		// 左右结点的值都大于根节点，直接return，不做任何操作
		if (index != largest) {
			// 交换根节点和左右结点中最大的那个值，把根节点的值替换下去
			swap(array, index, largest);
			// 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
			maxHeap(array, heapSize, largest);
		}
	}

	private void swap(int[] arrays, int i, int j) {
		int temp;
		temp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = temp;
	}
}