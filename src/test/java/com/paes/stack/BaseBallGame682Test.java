package com.paes.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGame682Test {
    @Test
    @DisplayName("itShouldReturnTheSumOfAllScores")
    void itShouldReturnTheSumOfAllScores() {
        BaseBallGame682 baseBallGame = new BaseBallGame682();
        int expected = 27;
        String operations[] = {"5","-2","4","C","D","9","+","+"};
        int actual = baseBallGame.calPoints(operations);
        assertEquals(expected,actual);
    }
}