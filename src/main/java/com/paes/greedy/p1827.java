package com.paes.greedy;

import java.util.Arrays;

public class p1827 {
    public static int minOperations(int[] nums) {
        int operations=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                operations += (nums[i-1]-nums[i])+1;
                nums[i] = nums[i-1]+1;
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        System.out.println(minOperations(nums));
    }
}
