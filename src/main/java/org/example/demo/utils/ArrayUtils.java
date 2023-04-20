package org.example.demo.utils;

/**
 * @author lilinjun
 * @date 2023/4/19
 **/
public class ArrayUtils {

    public static void swap(int[] nums, int a, int b) {
        if (nums == null) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
