package org.example.demo.backtrack;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lilinjun
 * @date 2023/4/29
 * #17
 * 数字键盘表示的所有字符
 **/
public class DigitString {

    private final String[] digitMap = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private ArrayList<String> list = new ArrayList<>();

    /**
     * 为什么不用 for 循环，
     * 因为不知道 digits 的n 有多少个，所以没法写。
     * 比如你第一层 是i , 第二层 是 j , 但是你不知道一共有多少层，所有没法遍历出来。
     */
    public List<String> letterCombinations(String digits) {

        if (StringUtils.isEmpty(digits)) {
            return list;
        }
        list.clear();
        findChar(digits, 0, "");

        return list;


    }

    private void findChar(String digits, int index, String s) {
        if (digits.length() == index) {
            list.add(s);
            return;
        }

        char c = digits.charAt(index);
        String digitStr = digitMap[c - '0'];
        for (int i = 0; i < digitStr.length(); i++) {
            findChar(digits, index + 1, s + digitStr.charAt(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(new DigitString().letterCombinations("232"));
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        list.remove(2);
        System.out.println(list);
    }
}
