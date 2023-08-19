package org.example.demo.twopoint.slipwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linjun
 * @date 2023/4/24
 * #78
 * 返回数组子集
 **/
public class SubSet {

    public static void main(String[] args) {
        System.out.println(binaryBit(new int[]{1,2,3}));
        System.out.println(subSet(new int[]{1,2,3}));
        System.out.println(new ArrayList<List<Integer>>());
    }


    //fixme 可以跳跃
    public static List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            List<List<Integer>> integers = buildList(i, nums);
            lists.addAll(integers);
        }
        return lists;
    }

    private static List<List<Integer>> buildList(int length, int[] nums) {

/*        if (length == 0) {
            return new ArrayList<List<Integer>>();
        }*/

        List<List<Integer>> listList = new ArrayList<>();

        //定义 [i,j) 为nums 的子数组
        int i = 0;
        int j = i + length;
        while (j <= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int k = i; k < j; k++) {
                list.add(nums[k]);
            }
            j++;
            i++;
            listList.add(list);
        }

        return listList;

    }


    /**
     * 解法，位运算
     * @param nums
     * @return
     */
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // i 到 2^length 循环
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }


    class Solution {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));
            }
            return ans;
        }
    }



}
