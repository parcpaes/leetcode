package com.paes.strings;

public class p1816 {
    public String truncateSentence(String s, int k) {
        String words[] = s.split(" ");
        for(int i=1;i<words.length;i++){
            words[i] = words[i-1]+" "+words[i];
        }
        return words[k-1];
    }
    public static void main(String[] args) {
        p1816 p = new p1816();
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(p.truncateSentence(s,k));
    }
}
