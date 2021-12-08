package com.paes.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class p1238PermutationBinary {
    public static List<Integer> circularPermutation(int n, int start) {
        if(n==1) return (start==1)?List.of(start,0):List.of(0,1);
        LinkedList<Integer> permutationBits = new LinkedList<>();
        backtracking(permutationBits,1<<n,start,start);
        return new ArrayList<>(permutationBits);
    }
    public static void backtracking(LinkedList<Integer> permutation,int n,int start,int init){
        if(permutation.contains(start)) return;
        if(permutation.size()==n) return;
        if(!permutation.contains(start)){
            permutation.add(start);
        }
        for(int i=0,j=n-1;i<0 && j>=0;i++,j--){
            int bits1 = Integer.bitCount(i^start);
            int bits2 = Integer.bitCount(j^start);
            if(bits1==1){
                backtracking(permutation,n,j,init);
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> bits = circularPermutation(4,1);
        System.out.println(bits.toString());
    }
}
