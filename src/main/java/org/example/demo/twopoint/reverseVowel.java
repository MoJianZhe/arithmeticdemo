package org.example.demo.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lilinjun
 * @date 2023/4/23
 * #345
 * 反转元音字母
 **/
public class reverseVowel {
    static Set<Character> vowelSet = new HashSet<>();
    static {
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

    }

    public static void main(String[] args) {
        System.out.println(reverseVowelString("hEllo"));
    }


    public static String reverseVowelString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0 ;
        int right = s.length() - 1;
        while (left < right) {
            boolean leftVowel = isVowel(chars[left]);
            boolean rightVowel = isVowel(chars[right]);
            //交换应该在前面，不然left 和 right 的位置可能会变化
            if (leftVowel && rightVowel) {
                swap(chars, left, right);
            }
            if (leftVowel) {
                right--;
            }
            if (rightVowel) {
                left++;
            }
            //如果左边不是，右边也不是
            if (!leftVowel && !rightVowel) {
                left++;
                right--;
            }
        }
        return new String(chars);

    }

    public static boolean isVowel(char c) {
        char c1 = Character.toLowerCase(c);
        return vowelSet.contains(c1);
    }

    public static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
