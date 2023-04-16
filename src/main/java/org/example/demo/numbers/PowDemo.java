package org.example.demo.numbers;

import java.util.Date;

/**
 * 计算pow(x,n)，x的n次方，#50
 */
public class PowDemo {

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        System.out.println(myPow(0.00001, 2147483647));
        Long hasTime = System.currentTimeMillis() - time;
        System.out.println("end +" + hasTime);
        time = System.currentTimeMillis();
        new Solution().myPow(0.00001, 2147483647);
        System.out.println("end2 is " + (System.currentTimeMillis() - time));

    }

    //结果超时了，因
    public static double myPow(double x, int n) {
        if (n >= 0) {
            return getPow(x, n);
        } else {
            return 1 / getPow(x, -n);
        }

    }


    //n 为正数
    public static double getPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double y = getPow(x, n / 2);
        if (isEvenNum(n)) {
            //不需要重复调用getPow(),这样的话，会调用很多层，直接超时了。
//            return getPow(x, n / 2) * getPow((x), n / 2);
            return y * y;
        } else {
//            return getPow(x, n / 2) * getPow(x, n / 2) * x;
            return y * y * x;
        }
    }

    public static boolean isEvenNum(int x) {
        return x % 2 == 0;
    }


    static class Solution {
        public double quickMul(double x, long N) {
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;
        }

        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }
    }

}
