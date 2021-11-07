package com.leetcode;

import java.util.HashMap;

/**
 * @Author zj
 * @Date 2021/7/29 18:30
 * @Description
 */

public class TwoNumber {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[map.get(target - nums[i])], nums[i]};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("no such numbers");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        if (twoSum(nums, target) != null) {
            for (int i = 0; i < twoSum(nums, target).length; i++) {
                System.out.print(twoSum(nums, target)[i] + " ");
            }
        }
    }
}
