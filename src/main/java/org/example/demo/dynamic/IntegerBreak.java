package org.example.demo.dynamic;

/**
 * @author lilinjun
 * @date 2023/5/5
 * #343
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化
 * 返回 你可以获得的最大乘积
 **/
public class IntegerBreak {

    private int res;

    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        return findMaxMultiplication(n);
    }

    private int findMaxMultiplication(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = Math.max(i * findMaxMultiplication(n - i), result);
            int a = i * (n - i);
            result = Math.max(a, result);
        }
       return result;

    }


    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(4));

    }


}
