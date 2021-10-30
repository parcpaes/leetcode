package com.paes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1221 {
    public static int balancedStringSplit(String s){
        if(s.length()<1) return 0;
        Map<Character,Integer> RL = new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i+=2){
            RL.merge(s.charAt(i),1,Integer::sum);
            RL.merge(s.charAt(i+1),1,Integer::sum);
            if(RL.get('R') == RL.get('L')){
                RL.put('R',0);
                RL.put('L',0);
                count++;
            }
        }
        return count;
    }

    public static int balancedStringSplit2(String s){
        int res =0, cnt = 0;
        for(int i=0;i<s.length();i++){
            cnt+=s.charAt(i)=='L' ? 1 :-1;
            if(cnt==0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            System.out.println(balancedStringSplit2(s));
        }
    }
}