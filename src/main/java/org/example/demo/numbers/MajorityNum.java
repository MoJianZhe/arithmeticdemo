package org.example.demo.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数 #169
 */
public class MajorityNum {

    public static void main(String[] args) {

    }

    private static int majority(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()) {
            if (maxEntry == null || integerEntry.getValue() > maxEntry.getValue()) {
                maxEntry = integerEntry;
            }
        }
        return maxEntry.getKey();
    }
}
