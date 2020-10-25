package org.example.demo;

import java.util.Stack;

public class StringDemo {

    /**
     * 判断字符串是否符合 括号匹配原则（）
     * @param str
     * @return
     */
    public boolean judgeStr(String str) {
        String[] chars = str.split("");
        Stack<String > characters = new Stack<>();
        for (String s : chars) {
            if (" ".equals(s)) {
                continue;
            }
            try {
                if ("(".equals(s)) {
                    characters.push(s);
                } else if (")".equals(s)) {
                    characters.pop();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return characters.empty();
    }


    public static void main(String[] args) {
       boolean resut =  new StringDemo().judgeStr("()()  ()");
        System.out.println(resut);
    }
}
