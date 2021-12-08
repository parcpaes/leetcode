package com.paes;

import java.util.Arrays;

public class p1464 {
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
    public static void main(String[] args) {
        int array[] = {3,7};
        System.out.println(maxProduct(array));
    }
}
