package com.paes.greedy;

import java.util.Arrays;
import java.util.Collection;

public class p323 {
    public static int maximum69Number(int num) {
        int ones = (int) Math.pow(10,(int)Math.log10(num)+1)/9;
        if((num/9)==ones) return num;
        String value = String.valueOf(num);
        char numbers[] = value.toCharArray();
        numbers[value.indexOf('6')]='9';
        return Integer.parseInt(String.valueOf(numbers));
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
}
