package org.example.demo.sort;

/**
 * @author lilinjun
 * @date 2023/6/8
 * 插入排序
 * 插入有序的序列中
 **/
public class InsertSort {

    public int[] sort(int[] arr) throws Exception {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];// temp 要插入了，所以其它的要往后挪一步。
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
