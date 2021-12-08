package com.paes;

import java.util.Scanner;
import java.util.stream.Collectors;

public class p1880 {
    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord){
        int firstVal = concatNumber(firstWord);
        int secondVal = concatNumber(secondWord);
        int targetVal = concatNumber(targetWord);
        return (firstVal+secondVal)== targetVal;
    }

    public static int concatNumber(String word){
        return word.chars()
                .map(w->w-'a')
                .reduce(0,(acc,value)-> acc*10+value);
    }

    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);
        while(in.hasNext()){
            String firstWord = in.next();
            String secondWord = in.next();
            String targetWord = in.next();
            System.out.println(isSumEqual(firstWord,secondWord,targetWord));
        }
    }
}
