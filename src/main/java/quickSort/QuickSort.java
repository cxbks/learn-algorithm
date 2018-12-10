package quickSort;

import java.util.Arrays;

/**
 * 功能：快速排序：快速排序在每一轮挑选一个基准元素，并让其他比它大的元素移动到数列一边，
 *               比它小的元素移动到数列的另一边，从而把数列拆解成了两个部分。
 *
 * 避免选中的第一个元素的完全逆序的情况：我们可以不选择数列的第一个元素，而是随机选择一个元素作为基准元素。
 * 当然，即使是随机选择基准元素，每一次也有极小的几率选到数列的最大值或最小值，同样会影响到分治的效果。
 * 所以，快速排序的平均时间复杂度是 O（nlogn），最坏情况下的时间复杂度是 O（n^2）。
 *
 * 挖坑法
 * 代码中，quickSort方法通过递归的方式，
 * 实现了分而治之的思想。
 *
 * partition方法则实现元素的移动，让数列中的元素依据自身大小，
 * 分别移动到基准元素的左右两边。在这里，我们使用移动方式是挖坑法。
 *
 * @author kmm on 2018/11/1下午1:32
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arrays = new int[]{43, 6543, 76, 5, 873, 1, 786, 89685, 43241, 456743, 343};
        quickSort(arrays,0,arrays.length-1);
        System.out.println(Arrays.toString(arrays));
    }

    private static void quickSort(int[] arrays, int startIndex, int endIndex) {
        //递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arrays, startIndex, endIndex);
        //用分治递归数列的两部分
        quickSort(arrays, startIndex, pivotIndex - 1);
        quickSort(arrays, pivotIndex + 1, endIndex);

    }

    private static int partition(int[] arrays, int startIndex, int endIndex) {
        //取第一个位置的元素作为基准元素
        int pivot = arrays[startIndex];
        int left = startIndex;
        int right = endIndex;
        //坑的位置，初始等于pivot的位置
        int index = startIndex;

        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arrays[right] < pivot) {
                    arrays[left] = arrays[right];
                    index = right;
                    left ++;
                    break;
                }
                right--;
            }

            //left指针从左向右进行比较
            while (right >= left) {
                if (arrays[left] > pivot) {
                    arrays[right] = arrays[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arrays[index] = pivot;
        return index;
    }

}
