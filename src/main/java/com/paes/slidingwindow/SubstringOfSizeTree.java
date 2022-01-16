package com.paes.slidingwindow;

import java.util.*;

public class SubstringOfSizeTree {
    public static int countGoodSubstrings(String s) {
        if(s.length()<3) return 0;
        if(s.isEmpty() || s.length()==0){
            throw new IllegalArgumentException();
        }
        LinkedList<Character> list = new LinkedList<>();
        int total=0, K=3;
        for (char c: s.toCharArray()) {
            list.add(c);
            if(list.size()>=K){
                HashSet<Character> set = new HashSet<>(list);
                total += (set.size()==K) ? 1 :0;
                list.removeFirst();
            }
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aabacdefgal"));
    }
}
