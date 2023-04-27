package org.example.demo.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lilinjun
 * @date 2023/4/25
 * #290 单词规律
 **/
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("juery","juery"));
    }


    public static boolean wordPattern(String pattern, String s) {
        /*key=字符， v= 位置*/
        Map<Character, Integer> charIndexMap = new HashMap<>();
        /*key=位置索引，value:之前出现过得字符的位置，没出现过为-1 */
        Map<Integer, Integer> indexMap = new HashMap<>();
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //这一步在前面，一开始是挺难理解的，就好比 set 去重一样，先要判断存不存在，然后再 add
            indexMap.put(i, charIndexMap.getOrDefault(chars[i], -1));
            charIndexMap.put(chars[i], i);
        }


        String[] s1 = s.split(" ");
        if (s1.length < chars.length) {
            return false;
        }
        Set<String> sMap = new HashSet<>();
        for (int i = 0; i < s1.length; i++) {
            int j = i % chars.length;
            if (indexMap.get(j) != -1) {
                if (!s1[indexMap.get(j)].equals(s1[i])) {
                    return false;
                }
            } else {
                //表示是新的数，如果和之前的一样了就不行
                if (sMap.contains(s1[i])) {
                    return false;
                }
            }
            sMap.add(s1[i]);

        }
        return true;
    }
}
