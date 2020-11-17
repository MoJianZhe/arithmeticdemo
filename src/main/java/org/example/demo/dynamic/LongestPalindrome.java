package org.example.demo.dynamic;

import java.util.*;

/**
 * 最长回文串 #5
 * @author jun
 */
public class LongestPalindrome {

    String direct(String s) {
        Map<Integer, StringBuilder> palindromeMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder demo = new StringBuilder().append(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (officePalindrome(demo.toString())) {
                    demo.append(chars[j]);
                    //fixme 有问题，连续3个不是，可能连续4个就是回文，比如 abba
                } else {
                    palindromeMap.put(demo.length(), demo);
                }
            }
        }
        Object[] list =  palindromeMap.keySet().toArray();
        Arrays.sort(list);
        return palindromeMap.get(list[list.length - 1]).toString();
    }

    public boolean isPalindrome(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean officePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }

    /**
     * 自己实现的回文。
     * @param s
     * @return
     */
    public String myLongestLindrome(String s) {
        int length = s.length();
        // 存储 dp[i][l],i表示起始位置，l 表示长度。
        boolean [][] dp = new boolean[length][length];
        String ans = "";
        //必须得先遍历l ,如果先遍历i ,后面的 i+l<length 就限制了 l的长度。
        for (int l = 0; l < length; l++) {
            for (int i = 0; i + l < length; i++) {
                int j = i + l;
                if (l == 0) {
                    //一个字符
                    dp[i][j] = true;
                } else if (l == 1) {
                    //两个字符的时候
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j- 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;

    }



    public static void main(String[] args) {
        boolean result = new LongestPalindrome().officePalindrome("aabbaa");
        boolean result2 = new LongestPalindrome().isPalindrome("aabbaa".toCharArray());
        System.out.println(result);
        System.out.println(new LongestPalindrome().direct("abba"));
        System.out.println(new LongestPalindrome().myLongestLindrome("babad"));

    }

    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            String ans = "";
            //l 表示回文串的长度
            for (int l = 0; l < n; ++l) {
                for (int i = 0; i + l < n; ++i) {
                    int j = i + l;
                    if (l == 0) {
                        dp[i][j] = true;
                    } else if (l == 1) {
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    } else {
                        // 如果l>1,那么比较他们的字串是否是回文的。
                        // l 是从0开始递增的，所以d[i+1][j-1]的值是已经初始化了的
                        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                    }
                    if (dp[i][j] && l + 1 > ans.length()) {
                        ans = s.substring(i, i + l + 1);
                    }
                }
            }
            return ans;
        }
    }


}
