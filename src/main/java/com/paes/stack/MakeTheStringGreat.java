package com.paes.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeTheStringGreat {
    static short LOWER_UPPER_DISTANCE = 32;
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char letter: s.toCharArray()){
            int len = sb.length();
            if(len>0 && Math.abs(sb.charAt(len-1)-letter)==LOWER_UPPER_DISTANCE){
                sb.delete(sb.length()-1,sb.length());
            }else{
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "JTqEfAlhEfR";
        System.out.println(makeGood(s));
    }
}
