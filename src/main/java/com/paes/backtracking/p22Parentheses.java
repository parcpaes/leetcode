package com.paes.backtracking;

import java.util.*;

public class p22Parentheses {
    public static List<String> generateParenthesis(int n) {
        if(n==1) return List.of("()");
        List combinations = new ArrayList();
        backtracking(n,combinations,"",0,0);
        return combinations;
    }

    private static void backtracking(int n,List combinations,String concat,int open,int close) {
        if(concat.length()==n*2){
            combinations.add(concat);
            return;
        }
        if(open<n) backtracking(n,combinations,concat+"(",open+1,close);
        if(close<open) backtracking(n,combinations,concat+")",open,close+1);
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        for(String s:result){
            System.out.println(s);
        }
    }
}
