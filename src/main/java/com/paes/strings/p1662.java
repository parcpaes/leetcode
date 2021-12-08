package com.paes.strings;
//Check If Two String Arrays are Equivalent
public class p1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("",word1).equals(String.join("",word2));
    }
    public static void main(String[] args) {
        String word1[] = {"a", "cb"};
        String word2[] = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
