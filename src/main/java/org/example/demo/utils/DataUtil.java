package org.example.demo.utils;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lilinjun
 * @date 2023/4/22
 * 随机生成函数
 **/
public class DataUtil {


    public static int[] generateRandomList(int size) {
        int[] results = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = RandomUtils.nextInt(0, 10000);
        }
        return results;
    }

    public static int[] generateOrderArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }
}
