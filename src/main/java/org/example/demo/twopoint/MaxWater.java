package org.example.demo.twopoint;

/**
 * @author lilinjun
 * @date 2023/4/23
 * #11 求最大水的容量
 **/
public class MaxWater {

    public static void main(String[] args) {

    }

    /**
     * 暴力解法
     * 循环遍历
     * 时间复杂度：O(n^2)
     */
    public static int maxArea(int[] height) {
        //最大的面积
        int maxArea = 0;
        for (int i : height) {
            //计算出所有的面积，然后取最大的
            for (int j = i + 1; j < height.length; j++) {
                int areaHeight = Math.min(height[i], height[j]);
                int currentArea = areaHeight * (j - i);
                if (maxArea < currentArea) {
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }


    /**
     * 双指针解法
     */
    static class Solution {
        /**
         * 1. 选择最左和最右，保证底部是最大的。
         * 2. 将指针向内侧移动，这时候底是变小的，面积的变化分下面2中情况
         *     a. 移动短板，因为高度变了，所以面积可能会变大，也可能会变小
         *     b. 移动长板，<p>因为短板不变，所以编辑可定会变小</p>
         * 所以只需要不停地移动短板，看那个面积是最大值。
         */
        public int maxArea(int[] height) {
            int left = 0; //左指针，一开始在最左边
            int right = height.length - 1;//有指针，一开始在最右边
            int maxArea = Math.min(height[left], height[right]) * (right - left);
            while (left < right) {
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
                int currentArea = Math.min(height[left], height[right]) * (right - left);
                if (maxArea < currentArea) {
                    maxArea = currentArea;
                }
            }

            return maxArea;
        }
    }
}
