package org.example.demo.numbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给一个数组，把所有0移到末尾，原来非0顺序不变 #283
 */
public class MoveZero {

    public static void main(String[] args) {

    }

    public static void move0(int[] nums) {
        int lastNoZero = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果不为0，只是简单的复制
            // 从0~下一个不为0，把最后不为0的值附上去就好了。
            if (nums[i] != 0) {
                nums[lastNoZero++] = nums[i];
            }
        }
        for (int i = lastNoZero; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
