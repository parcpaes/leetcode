package com.paes.greedy;

import java.util.HashMap;
import java.util.Map;

public class p1221 {
    public static int balancedStringSplit(String s) {
        short RL[] = new short[2];
        int count=0;
        for(int i=1;i<s.length();i+=2){
            RL[getValue(s.charAt(i-1))]++;
            RL[getValue(s.charAt(i))]++;
            if(RL[0] == RL[1]){
                RL[0]=0;
                RL[1]=0;
                count++;
            }
        }
        return count;
    }
    public static int balancedStringSplit2(String s){
        int count=0,result=0;
        for(int i=1;i<s.length();i+=2){
            result += getValue(s.charAt(i-1))+getValue(s.charAt(i));
            if(result==0) count++;
        }
        return count;
    }
    public static int getValue(char c){
        return (c=='L')?1:-1;
    }
    public static void main(String[] args) {
        String s = "LLLLRLLRRLLRLRLRLRLRRLLRRLLRLRRRRLLRRLLLRLRRRLRRLLRLRRRRLLRLRLRLRRLRLRLLLRLLRRLRLRRRRRLLRRRLRRLLRLLRLLLRLRLLLLLRLLLLLLRRLLLRRRRRRLRRLRLRRLLRLRRRRRRLRRRRRLLRRLLRRLRLLRRRRLRRRRLRLRLLRRRLLLLRRLLLLRRLRRRLLRRRRRRLRLLLRLRRLRLLLRRRLRLLRRLRLRLLLRRLLLLRRLRLRRLRLRRRRLRLRLRLRRLLRRLRLRLLLRLRRRLRRRLRRLRLLLRLLRRRRRLRLLLLRRLLRLLLRRLLRRLLLLLLRLLRRRRRRLRRLLLRRLLLLRRLRRLLLLLRRRRLRLRRLRLLRLLLRLLRLLLRLLRLRLRLLLRLLLLL"
                ;
        String s2 = "RLRRLLRLRL";
        System.out.println(balancedStringSplit2(s2));
    }
}
