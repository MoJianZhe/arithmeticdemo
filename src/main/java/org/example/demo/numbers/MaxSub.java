package org.example.demo.numbers;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 连续最大子数组 #152
 *
 * @author jun
 */
public class MaxSub {

    public int maxProduct(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int multiLength = nums.length - 1;
        int[] multi = new int[multiLength];
        for (int i = 0; i < nums.length - 1; i++) {
            multi[i] = nums[i] * nums[i + 1];
        }
        Arrays.sort(multi);
        Arrays.sort(nums);
        return Math.max(multi[multiLength - 1], nums[multiLength]);

    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2};
        MaxSub maxSub = new MaxSub();
        System.out.println(maxSub.maxProduct(test));
    }

    class Solution {
        /**
         * 分成 正和负
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            int maxF = nums[0], minF = nums[0], ans = nums[0];
            int length = nums.length;
            for (int i = 1; i < length; ++i) {
                int mx = maxF, mn = minF;
                maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
                minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
                ans = Math.max(maxF, ans);
            }
            return ans;
        }
    }

}
