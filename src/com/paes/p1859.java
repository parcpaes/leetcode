package com.paes;

import java.util.Arrays;
import java.util.stream.Collectors;

//Sorting the Sentence
public class p1859 {

    public static String sortSentence(String s){
        String words[] = s.split(" ");
        String aux[] = new String[words.length];
        for(String word:words) {
            int i = word.length()-1;
            aux[word.charAt(i) - '1'] = word.substring(0,i);
        }
        return String.join(" ",aux);
    }

    public static void main(String[] args) {
        String a = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(a));
    }
}
