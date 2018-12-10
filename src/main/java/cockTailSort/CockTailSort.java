package cockTailSort;

import java.util.Arrays;

/**
 * 功能：鸡尾酒排序法：优点：减少排序的回合数；缺点：代码量几乎扩大了一倍
 * 适用场景：大部分元素已经有序
 * 代码外层的大循环控制着所有排序回合，大循环内包含两个小循环，
 * 第一个循环从左向右比较并交换元素，第二个循环从右向左比较并交换元素。
 *
 *
 * @author kmm on 2018/10/31下午2:54
 */
public class CockTailSort {
    public static void main(String[] args){
        int[] arrays = new int[]{3,4,5,67,31,756,8,43,21,76,324};
        cockTailSork(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void cockTailSork(int[] arrays) {
        int tmp = 0;
        for (int i = 0; i < arrays.length/2; i++) {
            //有序标记，每一轮的初始值为true
            boolean isSorted = true;
            //奇数轮从左开始，从左向右开始比较交换
            for (int j = i;j<arrays.length-i-1;j++){
                if (arrays[j] > arrays[j + 1]) {
                    tmp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            //偶数轮开始之前，重新标记
            isSorted = true;

            //偶数轮从右开始，从右向左开始比较交换
            for (int j = arrays.length-1;j>i;j--){
                if (arrays[j] < arrays[j - 1]) {
                    tmp = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = tmp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }

        }
    }
}
