package com.paes.heap;

import java.util.*;

public class TopKFrequentElements374 {
    public static int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length) return nums;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int result[] = new int[k];
        for (int num : nums) {
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->frequency.get(b)-frequency.get(a));
        priorityQueue.addAll(frequency.keySet());
        for (int i = 0; i < k; i++) {
            result[i]=priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,3,2,3,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
}
