package com.paes.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p46Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length==1) return List.of(List.of(nums[0]));
        List<List<Integer>> result = new ArrayList<>();
        boolean choice[] = new boolean[nums.length];
        dfs(result,nums, new LinkedList<>(),choice);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums,LinkedList<Integer> permutations, boolean[] choice) {
        if(permutations.size()==nums.length){
            result.add(new ArrayList<>(permutations));
        }
        for(int i=0;i<nums.length;i++){
            if(!choice[i]){
                choice[i]=true;
                permutations.add(nums[i]);
                dfs(result,nums,permutations,choice);
                choice[i]=false;
                permutations.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> list = permute(nums);
        for(List<Integer> val:list){
            System.out.println(val.toString());
        }
    }
}
