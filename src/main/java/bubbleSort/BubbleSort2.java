package bubbleSort;

import java.util.Arrays;

/**
 * 功能：冒泡排序第二版
 * 利用布尔变量isSorted作为标记。
 * 如果在本轮排序中，元素有交换，则说明数列无序；如果没有元素交换，说明数列已然有序，直接跳出大循环
 *
 * @author kmm on 2018/10/23上午10:39
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = new int[]{12,324,54,56,74,6756,2413,6,7,21,52,3,5555,5555,5555};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    //有元素交换，所以不是有序，编辑变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                  break;
            }
        }
    }
}
