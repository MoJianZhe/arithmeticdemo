package org.example.demo.sort;

import org.example.demo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author lilinjun
 * @date 2023/4/22
 * #75
 *  三元快排
 **/
public class SortColor {
    public static void main(String[] args) {
        int[] result = new int[]{1, 2, 0, 2, 1, 2, 0, 0, 1, 2};
        threeSort(result);
        System.out.println(Arrays.toString(result));
    }

    /**
     * array 只有 0,1,2
     * 对他们排序
     * 时间复杂度： O(n)
     * @param arrays 数组
     */
    public static void threeSort(int[] arrays) {
        // 定义 [0,zero] 全为0
        // [zero+1, two -1] 全为1
        // [two , length-1] 全为2；
        int zero = -1;
        int two = arrays.length;
        //for (int i = 0; i < arrays.length;)  这个明细错误，循环的额条件必须考虑清楚，
        // 当 i 和 two 遇见的时候，已经结束了，[tow,leng-1] 的数据已经全是2了。
        for (int i = 0; i < two;) {
            if (arrays[i] == 0) {
                ArrayUtils.swap(arrays, i++, ++zero);
            }else if (arrays[i] == 2) {
                ArrayUtils.swap(arrays, i, --two);
            }else {
                if (arrays[i] != 1) {
                    throw new IllegalArgumentException("参数错误哦");
                }
                i++;
            }

        }
    }
}
