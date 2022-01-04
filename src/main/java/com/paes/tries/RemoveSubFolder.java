package com.paes.tries;

import java.util.*;
public class RemoveSubFolder {

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        HashSet<String> result = new HashSet<>();
        StringBuilder prefix = new StringBuilder();
        for (String f : folder) {
            boolean isSubFolder = (prefix.length() < f.length()) &&
                    (f.charAt(prefix.length())=='/') &&
                    result.contains(f.substring(0, prefix.length()));
            if(!isSubFolder){
                prefix.delete(0,prefix.length());
                prefix.append(f);
                result.add(f);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String args[]){
        String[] folder = {"/c","/d/c/e"};
        System.out.println(removeSubfolders(folder));
    }
}
