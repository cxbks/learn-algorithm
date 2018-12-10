package bubbleSort;

import java.util.Arrays;

/**
 * 功能：冒泡排序的基本思想
 * 使用双循环来进行排序。外部循环控制所有的回合，内部循环代表每一轮的冒泡处理，
 * 先进行元素比较，再进行元素交换
 *
 * @author kmm on 2018/10/23上午10:22
 */
public class BubbleSort1 {
    public static void main(String[] args){
        int[] array = new int[]{5, 7, 32, 65, 12, 76, 12, 34,76,1,4,573,143,54653645};
        bubblesort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubblesort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j+1]= tmp;
                }
            }
        }
    }

}
