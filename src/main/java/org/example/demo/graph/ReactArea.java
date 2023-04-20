package org.example.demo.graph;

/**
 * 正方形最大面积  #221
 * 最优解：动态规划
 * @author jun
 */
public class ReactArea {
    public static void main(String[] args) {
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }
    }

    public static int maxArea(int[][] nums) {
        // 找出列第一个为1的数
        //找出行第一个为1的数
        // 找出列最后一个为1的数
        // 找出行最后一个为1的数

        //相减，取最大值


        return 0;
    }


    static class Solution {
        /**
         * 时间O(n^2)
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            int l = 1, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int cnt = 0;
                for (int i = 0; i < n; ++i) {
                    if (nums[i] <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    ans = mid;
                }
            }
            return ans;
        }
    }

}
