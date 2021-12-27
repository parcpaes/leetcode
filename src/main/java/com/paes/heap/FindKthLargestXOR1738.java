package com.paes.heap;

import java.util.PriorityQueue;

public class FindKthLargestXOR1738 {
    public static int kthLargestValue(int[][] matrix, int k) {
        if(matrix.length==1 && matrix[0].length==1) return matrix[0][0];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(matrix[0][0]);
        for (int j = 1; j < matrix[0].length; j++) {
            matrix[0][j]^=matrix[0][j-1];
            heap.add(matrix[0][j]);
            if(heap.size()>k) heap.poll();
        }
        for (int i = 1; i < matrix.length; i++) {
            int xorSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                xorSum^=matrix[i][j];
                matrix[i][j]=xorSum^matrix[i-1][j];

                heap.add(matrix[i][j]);
                if(heap.size()>k) heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int matrix [][]={{5,4,3},{6,7,9},{2,5,8}};
        System.out.println(kthLargestValue(matrix,1));
    }
}
