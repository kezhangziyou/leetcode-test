package base.sort.bubble;

import java.util.Arrays;

/**
 * @description 鸡尾酒排序，针对大部分元素已经有序的情况。
 * 		代码外层的大循环控制着所有排序回合，
 * 		大循环内包含2个小循环， 第1个小循环从左向右比较并交换元素， 第2个小循环从右
 * 		向左比较并交换元素。
 * @author zhangke
 * @date 17:32 2022/2/9
 * @version 1.0
 **/
public class CockTailSort {

    public static void sort(int array[])
    {
        int tmp  = 0;
        for(int i=0; i<array.length/2; i++)
        {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for(int j=i; j<array.length-i-1; j++)
            {
                if(array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }

            //偶数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for(int j=array.length-i-1; j>i; j--)
            {
                if(array[j] < array[j-1])
                {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
