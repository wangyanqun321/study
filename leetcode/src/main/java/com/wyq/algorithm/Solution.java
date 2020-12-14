package com.wyq.algorithm;

import java.util.Arrays;

/**
 * @author 王艳群
 * @description Solution
 * @date 2020/7/27
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length && j != i; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
