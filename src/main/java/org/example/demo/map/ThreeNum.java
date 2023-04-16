package org.example.demo.map;

import java.util.*;

public class ThreeNum {


    public static void main(String[] args) {
        int[] ints = {0, 0, 0};
        List<List<Integer>> lists = threeSum(ints);
        lists.forEach(s -> System.out.println(s));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        Set<String> strs = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {continue;}
                int reversal = -(nums[i] + nums[j]);
                int index = list.indexOf(reversal);
                if (index >= 0 && index != i && index != j) {
                    List<Integer> targetList = new ArrayList<>();
                    targetList.add(nums[i]);
                    targetList.add(nums[j]);
                    targetList.add(nums[index]);
                    Collections.sort(targetList);
                    StringBuilder str = new StringBuilder();
                    for (Integer integer : targetList) {
                        str.append(integer);
                    }
                    if (strs.add(str.toString())) {
                        lists.add(targetList);
                    }
                }
            }
        }
        return lists;

    }


    //官方解法
    public List<List<Integer>> threeSumOffice(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

}
