package com.paes.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p1403 {
    public static List<Integer> minSubsequence(int[] nums) {
        if(nums.length<0) return List.of();
        if(nums.length==1) return List.of(nums[0]);
        List<Integer> subSeq= new ArrayList<>();
        int total = 0, subtotal=0;
        for(int num:nums) total+=num;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            subtotal+=nums[i];
            subSeq.add(nums[i]);
            if(subtotal>(total-subtotal)) break;
        }
        return subSeq;
    }
    public static void main(String[] args) {
        int nums[] ={4,4,7,6,7};
        System.out.println(minSubsequence(nums));
    }
}
