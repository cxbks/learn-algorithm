package cockTailSort;

import java.util.Arrays;

/**
 * 功能：鸡尾酒排序算法优化
 * 代码中使用了左右两个边界值，rightSortBorder 代表右边界，leftSortBorder代表左边界。
 * <p>
 * 在比较和交换元素时，奇数轮从 leftSortBorder 遍历到 rightSortBorder 位置，
 * 偶数轮从 rightSortBorder 遍历到 leftSortBorder 位置。
 *
 * @author kmm on 2018/10/31下午3:14
 */
public class CockTailSort1 {
    public static void main(String[] args) {
        int[] arrays = new int[]{34, 5, 345, 65, 768658, 324, 1234, 4, 452565356, 643, 32};
        cockTailSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void cockTailSort(int[] arrays) {
        int tmp = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;

        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;

        //无序数列的左界值，每次比较只需要比到这里为止
        int leftSortBorder = 0;

        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = arrays.length - 1;


        for (int i = 0; i < arrays.length / 2; i++) {

            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for (int j=leftSortBorder;j<rightSortBorder;j++){
                if (arrays[j] > arrays[j + 1]) {
                    tmp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if (isSorted) {
                break;
            }

            //偶数轮之前重新标记为true
            isSorted = true;

            //偶数轮，从右向左比较和交换
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    tmp = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = tmp;
                    //有元素交换，所以不是有序，标记为false
                    isSorted = false;
                    lastLeftExchangeIndex = j;

                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted) {
                break;
            }


        }

    }
}
