package org.example.demo.twopoint.slipwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lilinjun
 * @date 2023/4/24
 * 没有重复字母的最长字符串
 * #3
 **/
public class NoRepeatCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


    public static int lengthOfLongestSubstring(String s) {
        //定义[left,right]中没有重复的字符
        int left = 0;
        int right = -1;
        char[] chars = s.toCharArray();
        int maxLength = 0;

        /* map<key=字符，v=位置>*/
        Set<Character> characterSet = new HashSet<>();
        while (left < chars.length) {
            if (right < chars.length - 1 && !characterSet.contains(chars[right + 1])) {
                characterSet.add(chars[right + 1]);
                right++;
            } else {
                characterSet.remove(chars[left++]);
//                characterSet.add(chars[right]);
            }
            if (maxLength < (right - left + 1)) {
                maxLength = (right - left + 1);
            }
        }
        return maxLength;
    }
}
