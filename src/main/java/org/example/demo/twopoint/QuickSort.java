package org.example.demo.twopoint;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;

/**
 * 快速排序：
 * 1. 切分（使得 j,确定j的位置，使得a[0] ~a[j-1] 都小于a[j]。a[j+1}~a[length-1]都大于a[j];
 * 2. 递归
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {2, 34, 2142, 3, 3, 2};

        Arrays.sort(a);
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int position = partition(nums, start, end);
        quickSort(nums, start, position - 1);
        quickSort(nums, position + 1, end);

    }

    public static int party(int[] nums, int start, int end) {
        int v = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (nums[i] <= v) {
                i++;
                if (i == end) {break;}
            }
            while (nums[j] > v) {
                // j--的时候可能会小于i
                j--;
                if (j == start) {
                    break;
                }
            }
            //交换前，应该要判断一下i和j的大小。
            swap(nums, i, j);
        }
        swap(nums, 0, i);
        return i;
    }


    public static int partition(int[] nums, int low, int high) {
        int i = low;
        int v = nums[low];
        int j = high;
        while (true) {
            while (nums[i] <= v) {
                i++;
                if (i == high) {break;}
            }
            while (nums[j] > v) {
                j--;
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        //注意，这里只能是j，不能是i,i已经是比v大的数了，j只能是<=i的(才有可能break)，所以是j。
        swap(nums, low, j);
        return j;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
