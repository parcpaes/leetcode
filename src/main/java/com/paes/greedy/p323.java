package com.paes.greedy;

import java.util.Arrays;
import java.util.Collection;

public class p323 {
    public static int maximum69Number(int num) {
        int len = (int)Math.log10(num);
        int ones = (int) Math.pow(10,len+1)/9;
        if((num/9)==ones) return num;
        String value = String.valueOf(num);
        return ((int) Math.pow(10,len-value.indexOf('6'))*3)+num;
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number(6966));
    }
}
