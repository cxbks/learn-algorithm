package bubbleSort;

import java.util.Arrays;

/**
 * 功能：冒泡排序第三版
 * sortBorder就是无序数列的边界。
 * 每一轮排序过程中，sortBorder之后的元素就完全不需要比较了，肯定是有序的
 *
 * @author kmm on 2018/10/23上午10:49
 */
public class BubbleSort3 {
    public static void main(String[] args) {
        int[] array = new int[]{32, 56, 1, 4, 65, 546, 675, 35, 768, 980, 452, 65, 444, 555, 666, 777, 888, 999, 1000};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int tmp = 0;

        //记录最后一次交换的位置
        int lastExchangeIndex = 0;

        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1]= tmp;

                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;

                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;

                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }

        }
    }
}
