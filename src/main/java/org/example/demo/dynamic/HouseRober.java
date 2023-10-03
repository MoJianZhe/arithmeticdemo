package org.example.demo.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * #198 小偷最大值
 * @auther lilinjun
 * @date 2023/10/1
 */
public class HouseRober {

    Map<Integer, Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return 0;
    }

    /**
     * 如果有负数的情况
     * 考虑要偷的最大值 [X。。。。。n-1]
     * f(x) = 考虑偷的最大值 [x.....n-1]
     * f(0) = max{V0+f(2),v1+f(3),v2+f(4)......Vn-3 +f(n-1),Vn-2,Vn-1 }
     * @param nums 价值数组
     * @param index 索引
     * @return 最大值
     */
    public int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        int max = 0;
        for (int i = index; i < nums.length; i++) {
            int result = i + 2 > nums.length ? 0 : tryRob(nums, i + 2);
            max = Math.max(nums[i] + result, max);
        }
        cache.put(index, max);
        return max;
    }


    public static void main(String[] args) {
        int [] a = new int []{2,7,9,3,1};

        int i = new HouseRober().tryRob(a, 0);
        System.out.println(i);

    }


    /**
     * 在数组不会有负数的情况，只需要计算index 和 index+1 两种情况
     * 即 [x.....n-1] 中考虑最大值
     * f(x) = = 考虑在[x.....n-1]中最大值
     * f(x) = max{Vx+f(x+2),Vx+1 + f(x+3))
     * @param nums
     * @param index
     * @return
     */
    public int robBySelf(int[] nums, int index) {
        if (index < 0 || index > nums.length - 1) {
            return 0;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int max = nums[index] + robBySelf(nums, index + 2);
        int tmp = index + 1 > nums.length - 1 ? 0 : nums[index + 1];
        int second = tmp + robBySelf(nums, index + 3);
        max = Math.max(max, second);
        cache.put(index, max);
        return max;
    }
}
