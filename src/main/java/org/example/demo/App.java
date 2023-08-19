package org.example.demo;

import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println(new App().getOverturn(123));
        System.out.println(new App().getOverturn(1221));
    }


    /**
     * 获取一个数字的翻转数字
     * eg: 123 翻转 321
     * @param x 数字
     * @return 翻转数字
     */
    private int getOverturn(int x) {
        if (x <= 0) {
            return 0;
        }
        int n = x ;
        int cur = 0;
        while (n != 0) {
            cur = cur * 10 + n % 10;
            n = n / 10 ;
        }
        return cur;

    }

}
