package org.example.demo.twopoint;

/**
 * @author lilinjun
 * @date 2023/4/23
 * #344
 * 翻转字符串
 **/
public class ReverseChar {
    public static void main(String[] args) {

    }

    public static void reverse(char[] chars) {
        int left = 0;//左指针，从从0开始
        int right = chars.length - 1;//右指针，从1开始
        while (left < right) {
            swap(chars, left++, right--);
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
