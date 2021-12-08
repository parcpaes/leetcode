package com.paes.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class p1219PathWithMaxGoldTest {

    @DisplayName("it should return a path with maximum gold")
    @Test
    public void getPathWithMaximumGold(){
        //arrange
        int grid[][]= {{0,6,0},{5,8,7},{0,9,0}};
        p1219PathWithMaxGold pickGolds = new p1219PathWithMaxGold();

        //act
        int actual = pickGolds.getMaximumGold(grid);
        int expected = 24;
        //assert
        assertEquals(expected,actual);
    }
}