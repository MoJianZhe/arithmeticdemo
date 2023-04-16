package org.example.demo.numbers;

import javax.management.DynamicMBean;

/**
 * 斐波那契数
 *
 * @author jun
 */
public class Fibonacci {

    /**
     * 直接求，O(2^n)
     * @param n 第 n 项
     * @return 斐波那契值
     */
    public int direct(int n) {
        if (n <= 1) {
            return n;
        }
        return direct(n - 1) + direct(n - 2);
    }

    /**
     * 动态规划 O(n)，空间复杂度 O(n),需要记录已经计算过的数。
     * @param n 第 n 项
     * @return 第n项的斐波那契值
     */
    public int dynamicProgram(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().dynamicProgram(5));
    }

}
