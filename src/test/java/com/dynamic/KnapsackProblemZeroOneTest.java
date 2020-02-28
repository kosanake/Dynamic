package com.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackProblemZeroOneTest {

    @Test
    public void shouldCalculateValue() {
        KnapsackProblemZeroOne knapsackProblemZeroOne = new KnapsackProblemZeroOne(new int[] {20, 12, 2, 32}, new int[] {35, 24, 234, 43});
        assertEquals(0, knapsackProblemZeroOne.calculateValue(0));
        assertEquals(269, knapsackProblemZeroOne.calculateValue(32));
        assertEquals(336, knapsackProblemZeroOne.calculateValue(1000));
    }
}