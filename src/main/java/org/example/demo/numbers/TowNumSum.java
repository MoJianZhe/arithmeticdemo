package org.example.demo.numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilinjun
 * @date 2023/4/24
 * 2数之和
 * #1
 **/
public class TowNumSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 3, 2, 2, 3}, 5);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] twoSum(int[] nums, int target) {
        /*key:值，value:索引位置*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int add = target - nums[i];
            if (map.containsKey(add)) {
                return new int[]{map.get(add),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

}
