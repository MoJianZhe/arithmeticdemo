package org.example.demo.backtrack;

import java.util.*;

/**
 * @author lilinjun
 * @date 2023/4/29
 *  #46
 * 全排列
 **/
public class Permutation {

    private final List<List<Integer>> numsList = new ArrayList<>() ;

    private final boolean[] indexMap = new boolean[3];

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return numsList;
        }
        numsList.clear();
        Deque<Integer> unitList = new ArrayDeque<>();
        findNumbers(nums, 0, unitList);
        return numsList;
    }

    /**
     * 向这个排列的末尾添加第 index 个元素
     * @param nums 数组
     * @param index 排列的长度
     * @param unitList 选择过的数据
     */
    private void findNumbers(int[] nums, int index, Deque<Integer> unitList) {
        System.out.println("index is " + index + " unitList is " + unitList);
        if (nums.length == index) {
            System.out.println("==================");
            numsList.add(new ArrayList<>(unitList));
            return;
        }

        for (int i = 0; i < nums.length; i++) { // i 就表示选择了哪个数。
            System.out.println("for i is " + i + "  nums[i] is " + nums[i]);
            if (!indexMap[i]) {
                unitList.addLast(nums[i]);
                indexMap[i] = true;
                findNumbers(nums, index + 1, unitList);
                //选择到了最深的节点，需要返回上一层。所以需要把 选择过的数据退出来。
                //移除掉最后一个
                unitList.pollLast();
                System.out.println("remove last ; unitList is " + unitList + "index is " + index);
                // unitList 最多是 nums.length 个，返回到这里的 unitList 的长度是 nums.length -1
                //然后再吐出来一个，就是 nums.length -2 了。
                indexMap[i] = false;
            }
        }
    }


    /**
     *
     *
     * 自己实现
     *
     */

    public List<List<Integer>> myPermuteUnique(int[] nums) {
        if (nums == null) {
            return numsList;
        }
        numsList.clear();
        Deque<Integer> unitList = new ArrayDeque<>();
        myFindNumbers(nums, unitList);
        return numsList;
    }

    /**
     *
     * @param nums 数组
     * @param unitList 已经选择的数
     */
    private void myFindNumbers(int[] nums, Deque<Integer> unitList) {
        if (unitList.size() == nums.length) {
            numsList.add(new ArrayList<>(unitList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //list contain 太慢了，所以有新增一个变量保存。
            if (!unitList.contains(nums[i])) {
                unitList.addLast(nums[i]); //比如第一次选了0，
                myFindNumbers(nums, unitList);
                unitList.removeLast(); // i = 1 的时候，num[0] 就应该是可选的了。
            }
        }
    }


    public static void main(String[] args) {
       Permutation permutation  = new Permutation();
/*         List<List<Integer>> lists = permutation.permuteUnique(new int[]{0, 1, 2});
        for (List<Integer> integers : lists) {
            System.out.println(integers);
        }*/

        System.out.println("=========================");
        List<List<Integer>> lists1 = permutation.myPermuteUnique(new int[]{1, 2, 3});
        for (List<Integer> list : lists1) {
            System.out.println(list);
        }

//        System.out.println("equals " + lists.equals(lists1));
    }
}
