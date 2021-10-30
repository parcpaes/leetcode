package com.paes;

import java.util.Scanner;
import java.util.Stack;

public class p1614 {
    public static int maxDepth(String s){
        int max=0,count=0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) =='(') {
                count++;
            }else if(s.charAt(i)==')'){
                max = Math.max(max, count);
                count--;
            }
        }
        return max;
    }


    public static int maxRecur(int array[],int i){
        if(i<=0)  return array[0];
        return Math.max(array[i],maxRecur(array,i-1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(maxDepth(in.next()));
        }
    }
}
