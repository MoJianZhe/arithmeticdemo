package org.example.demo.others;


import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号 #22
 * @author jun
 */
public class Bracket {

    public List<String> generateBrackets(int n) {
        List<String> list = new ArrayList<>();
        helper(n, 0, 0, list, "");
        return list;
    }

    //todo 还并未理解该题。
    public void helper(int n, int left, int right, List<String> list, String result) {
        if (left == n && right == n) {
            list.add(result);
        }
        if (left < n) {
            helper(n, left + 1, right, list, result + "(");
        }
        // 不能使用else if ,如果用else if 那么left<n的时候，right 就不会加。
        if (right < left && right < n) {
            helper(n, left, right + 1, list, result + ")");
        }

    }

    public static void main(String[] args) {
        List<String> strings = new Bracket().generateBrackets(5);
        System.out.println(strings.toString());
    }

    public static class Solution {
        ArrayList[] cache = new ArrayList[100];

        public List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<String>();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c) {
                    for (String left : generate(c)) {
                        for (String right : generate(n - 1 - c)) {
                            ans.add("(" + left + ")" + right);
                        }
                    }
                }
            }
            cache[n] = ans;
            return ans;
        }
    }
}
