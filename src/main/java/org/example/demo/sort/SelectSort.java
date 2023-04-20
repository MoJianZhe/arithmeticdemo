package org.example.demo.sort;

import java.util.Arrays;

import static org.example.demo.twopoint.QuickSort.swap;

/**
 * @author lilinjun
 * @date 2023/4/19
 * 选择排序
 * 选择最大（小）的数，放入新的列表
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] ints = {1, 23, 4, 234, 234};
        selectSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     * @param arrays
     */
    public static void selectSort(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arrays, i, minIndex);
        }
    }
}
