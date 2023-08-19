package org.example.demo.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lilinjun
 * @date 2023/6/17
 * 判断一个整数是否回文数，不能将其转换成字符串
 **/
public class IntegerPalindrome {

    public boolean isPalindromeByMe(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        //得到倒叙的数组
        List<Integer> intArray = intToArray(x);
        int i = 0;
        int j = intArray.size() - 1;
        while (i < j) {
            if (!Objects.equals(intArray.get(i), intArray.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     * 将一个数转换成数组
     * @param x 数
     * @return 数组
     * eg : 100 转换成 [1,0,0]
     */
    private List<Integer> intToArray(int x) {
        List<Integer> list  = new ArrayList<>();
        int n = x ;
        while (n != 0) {
            list.add(n % 10);
            n = n / 10 ;
        }
        return list;
    }


    /**
     * 如果是负数则一定不是回文数，直接返回 false
     * 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
     * 如果是回文数则相等返回 true，如果不是则不相等 false
     * 比如 123 的倒序 321，不相等；121 的倒序 121，相等
     * 作者：guanpengchn
     * 链接：https://leetcode.cn/problems/palindrome-number/solution/hua-jie-suan-fa-9-hui-wen-shu-by-guanpengchn/
     */
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }






}
