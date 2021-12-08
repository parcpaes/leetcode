package com.paes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p1773 {
    private static final Map<String,Integer> rule = Map.of("type",0,"color",1,"name",2);
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue){
        Map<Boolean, List<List<String>>> collect = items.stream()
                .collect(Collectors.partitioningBy(s -> s.get(getIndexKey(ruleKey)).equals(ruleValue)));
        return collect.get(true).size();
    }

    public static int countMatches2(List<List<String>> items,String ruleKey,String ruleValue){
        return (int)items.stream()
                .filter(item->item.get(rule.get(ruleKey)).equals(ruleValue)).count();
    }

    public static int getIndexKey(String ruleKey){
        if(ruleKey.equals("type"))  return 0;
        else if(ruleKey.equals("color"))  return 1;
        else if(ruleKey.equals("name")) return 2;
        throw new IndexOutOfBoundsException("Key not found");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            List<List<String>> items = new ArrayList<>();
            for(int j=0;j<3;j++){
                items.add(new ArrayList<>());
                for(int i=0;i<3;i++){
                    items.get(j).add(in.next());
                }
            }
            System.out.println(countMatches2(items,"type","phone"));
        }
    }
}
