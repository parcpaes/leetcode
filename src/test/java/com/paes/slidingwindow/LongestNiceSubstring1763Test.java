package com.paes.slidingwindow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestNiceSubstring1763Test {
    @ParameterizedTest
    @MethodSource("getInput")
    @DisplayName("it should return the longest substring of S that is nice")
    void itShouldReturnTheLongestSubstringOfSThatIsNice(String s, String expected) {
        LongestNiceSubstring1763 longestString = new LongestNiceSubstring1763();
        String actual = longestString.longestNiceSubstring(s);
        assertEquals(expected,actual);
    }

    static List<Arguments> getInput(){
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments("YazaAay","aAa"));
        list.add(Arguments.arguments("Bb","Bb"));
        list.add(Arguments.arguments("YazaAayZ","YazaAayZ"));
        list.add(Arguments.arguments("c",""));
        return list;
    }
}