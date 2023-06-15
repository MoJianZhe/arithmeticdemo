package org.example.demo.sort;

/**
 * @author lilinjun
 * @date 2023/4/19
 * 冒泡排序
 * 将最大（小）的数一步一步放在队列的末尾，就像冒泡泡一样的浮现出来。
 *
 * 冒泡排序和插入排序的不同：
 * 1. 冒泡只是和邻近的值比较，选择插入排序是选择最值
 * 2. 冒泡极端情况，交换的次数是 O(n^2) , 而选择插入是 O(n)
 *
 **/
public class BubbleSort {

    private int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean Flag = false; // 是否发生交换。没有交换，提前跳出外层循环.
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    Flag = true;
                }
            }
            /**
             * 没有交换，说明待排序的，都已经有序了。·
             */
            if (!Flag) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 2, 1, 3, 28, 2, 3, 4};
        int[] b = new BubbleSort().bubbleSort(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }
}
