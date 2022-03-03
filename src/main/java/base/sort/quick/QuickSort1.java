package base.sort.quick;

/**
 * @description 
 * @author zhangke
 * @date 17:44 2022/2/9
 * @version 1.0
 **/
import java.util.Arrays;

public class QuickSort1 {

	public static void main(String[] args) {
		int[] arr = new int[] {4,4,6,5,3,2,8,1};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

    public static void quickSort(int[] arr) {
        if (null==arr|| arr.length==0||arr.length==1) {
            return;
        }
		sortv2(arr, 0, arr.length - 1);

    }
    /**
     * 分治（双边循环法）
     * @param arr     待交换的数组
     * @param left    起始下标
     * @param right    结束下标
     */
    private static void sortv1(int[] arr, int left, int right) {
    	if(left>right){
    		return ;
		}
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[left];
        int i = left;
        int j = right;

        while( i != j) {
            //顺序很重要，先从右边开始往左找，控制right指针比较并左移
            while(i<j && arr[j] >= pivot){
                j--;
            }
            //控制left指针比较并右移
            while( i<j && arr[i] <= pivot) {
                i++;
            }
            // // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置，交换left和right指向的元素
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //pivot和指针重合点交换，交换 pivot 和 left 的值
        arr[left] = arr[i];
        arr[i] = pivot;

		sortv1(arr,left,i-1);
		sortv1(arr,i+1,right);
    }

	/**
	 * 分治（单边循环法）
	 * @param arr     待交换的数组
	 * @param left    起始下标
	 * @param right    结束下标
	 */
	private static void sortv2(int[] arr, int left, int right) {
		if(left>right){
			return ;
		}
		// 取第一个位置的元素作为基准元素（也可以选择随机位置）
		int pivot = arr[left];
		int mark=left;
		for (int i = left+1; i <=right ; i++) {
			if(pivot>arr[i]){
				mark++;
				int temp = arr[mark];
				arr[mark]=arr[i];
				arr[i] = temp;
			}
		}

		//pivot和指针重合点交换，交换 pivot 和 left 的值
		arr[left] = arr[mark];
		arr[mark] = pivot;

		sortv2(arr,left,mark-1);
		sortv2(arr,mark+1,right);
	}


}
