package com.paes.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//1046. Last Stone Weight
public class p1046 {
    public static int lastStoneWeight(int[] stones) {
        int x, y;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones) maxHeap.add(stone);
        while(maxHeap.size()>1){
            y = maxHeap.poll();
            x = maxHeap.poll();
            if(x!=y) maxHeap.add((y-x));
        }
        return (maxHeap.size()==0)? 0: maxHeap.peek();
    }

    public static void main(String[] args) {
        int stones[] = {80};
        System.out.println(lastStoneWeight(stones));
    }
}
