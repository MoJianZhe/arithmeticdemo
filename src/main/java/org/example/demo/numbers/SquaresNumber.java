package org.example.demo.numbers;

/**
 * 找出最少的平方数的和
 * @author jun
 */
public class SquaresNumber {

    public static void main(String[] args) {

    }

    /**
     * 任何一个数 n = a1^2 + a2^2+ a3^2 + a4^2
     * 当满足 n !=4^k*(8m+7） => n =  a1^2 + a2^2+ a3^2
     * @param n 给定的数
     * @return
     */
    public static int squareNums(int n) {
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        if (isSquare(n)) {
            return 1;
        }
        for (int i = 0; i*i <n ; i++) {
            if (isSquare(n - (i * i))) {
                return 2;
            }
        }
        return 3;
    }

    public static boolean isSquare(int n) {
        int s = (int) Math.sqrt(n);
        return n == s * s;
    }

}
