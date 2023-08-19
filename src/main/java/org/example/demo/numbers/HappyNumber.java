package org.example.demo.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author linjun
 * @date 2023/4/25
 * # 202
 * 总觉的这个事情是无限的，是无法求解的。
 * 计算机就是打破固有的思维
 **/
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(getNext(100));
        System.out.println(isHappyNumber(19));
    }


    /**
     * 是否快乐数
     * 循环计算有三种情况
     * 1.结果为1
     * 2. 死循环,有重复值
     * 3. 无限循环
     * 因为 n 为整数，他的最大值可以求出来，可以证明 3 无线循环不存在
     *
     */
    public static boolean isHappyNumber(int n) {
        Set<Integer> hashSet = new HashSet<>();
        int next = n ;
        //不等于1，或者没有循环的时候，就继续。
        while (next != 1 && !hashSet.contains(next)) {
            hashSet.add(next);
            next = getNext(next);
        }
        //不一定所有的数都有1的，有些就是循环了。
//        return hashSet.contains(1);
        return next == 1;
    }


    public static int getNext(int n) {
     /*   int sum = 0;
        int d = n ;  这样写有问题，比如 100 ，第一次就为0 了，就没法循环了
        while (d != 0) {
            d = n % 10;
            n = n / 10;
            sum = sum + d * d;
        }
        return sum;*/


        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum = sum + d * d;
            n = n / 10;
        }
        return sum;
    }

}
