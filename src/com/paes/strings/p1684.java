package com.paes.strings;

public class p1684 {
    public static int countConsistentStrings(String allowed, String[] words) {
        String regex = "";
        int count =0;

        for(Character c : allowed.toCharArray()){
            regex +=c+"+|";
        }
        for(String word:words){
            String empty = word.replaceAll(regex,"");
            if(empty.equals("")) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String allowed = "ab";
        String words[] = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings(allowed,words));
    }
}
