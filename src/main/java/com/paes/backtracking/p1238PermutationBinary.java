package com.paes.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class p1238PermutationBinary {
    public static List<Integer> circularPermutation(int n, int start) {
        int size = (1<<n);
        int startIndex= grayToBinary(start);
        ArrayList<Integer> permutationBits = new ArrayList<>();
        int modIndex;
        for (int i = 0; i < (1<<n); i++) {
            modIndex = startIndex%size;
            permutationBits.add((modIndex)^(modIndex>>1));
            startIndex++;
        }
        return permutationBits;
    }

    public static int grayToBinary(int g){
        int B = g^(g>>1);
        B = B^(B>>2);
        B = B^(B>>4);
        B = B^(B>>8);
        B = B^(B>>16);
        return B;
    }

    public static List<Integer> circularPermutation2(int n, int start) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; ++i)
            result.add(start^i^i>>1);
        return result;
    }

    
    public static void main(String[] args) {
        List<Integer> bits = circularPermutation2(4,2);
        System.out.println(bits.toString());
        for (Integer bit : bits) {
            System.out.println(Integer.toBinaryString(bit));
        }
    }
}
