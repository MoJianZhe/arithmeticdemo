package org.example.demo.map;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    /**
     * #125
     * 判断2个字母是不是回文
     * rat 和 tar 是回文
     * 相同的字母，顺序不一样就可以
     */


    public static void main(String[] args) {
        System.out.println(Integer.valueOf("012"));
    }

    /**
     * o(N)
     * //fixme 有 bug 吧，这个map 的比较,只是表示字母的数量一样，就一定是回文么？
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isPalindromeStr(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : chars1) {
            map1.merge(c, 0, Integer::sum);
        }
        for (char c : chars2) {
            map2.merge(c, 0, Integer::sum);
        }
        return map1.equals(map2);
    }


    /**
     * 判断是否是回文的数字
     * @param x
     * @return
     */
    public static boolean isPalindromeInt(Integer x) {
        return false;
    }
}
