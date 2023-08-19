package org.example.demo.twopoint.slipwindow;

import java.util.*;

/**
 * @author linjun
 * @date 2023/4/24
 * #438
 * 寻找异味字母
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引
 **/
public class Anagram {

    public static void main(String[] args) {
        System.out.println(findAnagrams("baa", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pCharMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pCharMap.merge(p.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s, i, pCharMap, p.length())) {
                result.add(i);
            }
        }
        return result;

    }

    public static boolean isAnagram(String s, int index,  Map<Character, Integer> pCharMap,Integer pLength) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < pLength; i++) {
            sMap.merge(s.charAt(i + index), 1, Integer::sum);
        }
        return pCharMap.equals(sMap);
    }



    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++sCount[s.charAt(i) - 'a'];
                ++pCount[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                --sCount[s.charAt(i) - 'a'];
                ++sCount[s.charAt(i + pLen) - 'a'];

                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }



}
