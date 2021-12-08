package com.paes.strings;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Shuffle String
public class p1528 {
    public static String restoreString(String s, int[] indices) {
        TreeMap<Integer,String> shuffledString = new TreeMap<>();
        for(int i=0;i<indices.length;i++){
            shuffledString.put(indices[i],""+s.charAt(i));
        }
        return shuffledString
                .values()
                .stream()
                .collect(Collectors.joining());
    }

    public static String restoreString2(String s, int[] indices){
        char[] array = new char[s.length()];
        for(int i=0;i<indices.length;i++){
            array[indices[i]] = s.charAt(i);
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        String s = "aaiougrt";
        int indices[] = {4,0,2,6,7,3,1,5};
        System.out.println(restoreString2(s,indices));
    }
}
