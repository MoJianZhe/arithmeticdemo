package org.example.demo.twopoint.slipwindow;

/**
 * @author linjun
 * @date 2023/4/24
 * #209 大于target的最小滑动窗口长度
 **/
public class MinSumLength {

    public static void main(String[] args) {

    }


    /**
     * 定义一个数组是大于 target 的，
     * 1. 如果小于，那么 right 向右移动，如果大于，那么 left 向左移动
     *
     */
    public static int minSubArrayLen(int target, int[] nums) {
        //在 [left,right] 数组的值是大于 target 的
        int left =0;
        int right = -1;
        int sum = 0;// 窗口的和
        int minLength = nums.length + 1;//最小长度，默认设置为不可能的一个值。

        // 边界就是 left 不能超过长度， left  一定不会超过 right ,因为 right 先向右移动
        while (left < nums.length) {
            if (right < nums.length - 1 && sum < target) {
                sum = sum + nums[++right];
            } else {
                sum = sum - nums[left++];
            }
            if (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }
        if (minLength == nums.length + 1) {
            return 0;
        }
        return minLength;
    }
}
