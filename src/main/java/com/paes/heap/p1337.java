package com.paes.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p1337 {
    public static class Pair implements Comparable<Pair>{
        private int index;
        private int value;
        Pair(int index,int value){
            this.index = index;
            this.value = value;
        }
        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Pair o) {
            return (value==o.value)? index-o.index: value-o.value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int count[] = new int[mat.length],index=0;
        int weakness[] = new int[k];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) break;
                count[i]++;
            }
            queue.add(new Pair(i,count[i]));
        }
        while(index<k){
            Pair pair = queue.poll();
            weakness[index++]=pair.getIndex();
        }
        return weakness;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1,1,1,0,0,0,0},
                {1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1}
        };
        int result[] = kWeakestRows(mat,4);
        System.out.println(Arrays.toString(result));
    }
}
