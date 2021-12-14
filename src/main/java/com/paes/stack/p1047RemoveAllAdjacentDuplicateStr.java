package com.paes.stack;

/*
Problem: 1047
Remove All Adjacent Duplicates In String
Input: s = "abbaca"
Output: "ca"
*/
public class p1047RemoveAllAdjacentDuplicateStr {
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char letter : s.toCharArray()){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==letter){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}

