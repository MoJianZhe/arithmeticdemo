package org.example.demo.numbers;

import org.example.demo.utils.DataUtil;

import java.util.Arrays;

/**
 * @author linjun
 * @date 2023/4/22
 * 二分查找
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3243, 2, 3, 2, 42,};
        Arrays.sort(array);
     /*   int[] array = DataUtil.generateRandomList(10);
        System.out.println(" 数据源: " + Arrays.toString(array));*/

        int result = binarySearch(array, 42);
        System.out.println("index is " + result);
    }

    public static int binarySearch(int[] array, int target) {
        int l =0 ;
        int r = array.length - 1;// 在 [l....r] 区间寻找元素 target 注意 l和 r 都是闭区间

        while (l <= r) { // l 等于 r 的时候，区间依然成立。
//            int mid = (l + r) / 2; // l + r 可能会越界
            int mid = l + (l - r) / 2;
            if (target == array[mid]) {
                return mid;
            }
            if (target > array[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
