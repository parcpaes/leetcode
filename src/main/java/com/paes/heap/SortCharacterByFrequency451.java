package com.paes.heap;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharacterByFrequency451 {
    public static String frequencySort(String s) {
        StringBuilder[] frequencyS = new StringBuilder['z'-'0'+1];
        StringBuilder result = new StringBuilder();
        Arrays.setAll(frequencyS,StringBuilder::new);
        for (char character: s.toCharArray()){
            frequencyS['z'-character].append(character);
        }
        Arrays.sort(frequencyS,(a,b)->b.length()-a.length());
        for (StringBuilder fs : frequencyS) {
            if(fs.length()>0) result.append(fs);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "a1a11";
        System.out.println(frequencySort(s));
    }
}
