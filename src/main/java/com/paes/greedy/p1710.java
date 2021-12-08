package com.paes.greedy;

import java.util.Arrays;

public class p1710 {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->(a[1]==b[1])?b[0]-a[0]:b[1]-a[1]);
        int countBoxes = 0, units=0;
        for(int boxType[]:boxTypes){
            int boxes = boxType[0];
            int unitPerBox= boxType[1];

            if((countBoxes+boxes)<=truckSize){
                countBoxes+=boxes;
                units+=boxes*unitPerBox;
            }else{
                units+=(truckSize-countBoxes)*unitPerBox;
                break;
            }
        }
        return units;
    }
    public static void main(String[] args) {
        int boxTypes[][] = {
                {2,18},{4,9},{6,7},{3,9}//7
        };
        int boxTypes2[][] = {
                {5,10},{2,5},{4,7},{3,9}
        };
        int boxTypes3[][] = {
                {1,3},{2,2},{3,1}
        };
        System.out.println(maximumUnits(boxTypes3,4));
    }
}
