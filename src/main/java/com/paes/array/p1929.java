package com.paes.array;

import java.util.Arrays;

public class p1929 {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n<<1];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
