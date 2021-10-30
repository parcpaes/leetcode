package com.paes;

import java.util.Arrays;

public class p1913 {
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length-1;
        int difference = (nums[j]*nums[j-1])-(nums[0]*nums[1]);
        return difference;
    }
    public static void main(String[] args) {
        int array[] = {4,2,5,9,7,4,8};
        System.out.println(maxProductDifference(array));
    }
}
