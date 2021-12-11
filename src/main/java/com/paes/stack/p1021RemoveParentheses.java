package com.paes.stack;

import java.util.Stack;
import java.util.StringJoiner;

//1021. Remove Outermost Parentheses
/*Input: s = "(()())(())(()(()))"
  Output: "()()()()(())"*/
public class p1021RemoveParentheses {
    public static String removeOuterParentheses(String s){
        StringBuilder sb = new StringBuilder();
        int open=0; boolean start=false;
        for (char parentheses: s.toCharArray()) {
            open += (parentheses=='(')? 1: -1;
            boolean close = open==0;
            if(!close && start) sb.append(parentheses);
            start=!close;
        }
        return sb.toString();
    }

    public static String removeOuterParentheses2(String s){
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) sb.append(c);
            if (c == ')' && opened-- > 1) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))(((()())))";
        System.out.println(removeOuterParentheses(s));

    }
}
