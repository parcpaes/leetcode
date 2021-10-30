package com.paes;

import java.util.Arrays;

public class p1051 {
    public static int heightChecker(int[] heights) {
        int expected[] = Arrays.copyOf(heights,heights.length);
        Arrays.sort(expected);
        int sum = 0;
        for(int i=0;i<heights.length;i++){
            if(expected[i]!=heights[i]) sum+=1;
        }
        return sum;
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};

        System.out.println(heightChecker(array));
    }
}
