package com.dynamic;

/**
 * Knapsack 0-1 problem
 */
public class KnapsackProblemZeroOne {

    int[] weight;
    int[] value;
    int[][] mat;

    public KnapsackProblemZeroOne(int[] weight, int[] value) {
        this.weight = weight;
        this.value = value;
    }

    public int calculateValue(int knapsackCapacity) {

        this.mat = new int[weight.length + 1][knapsackCapacity + 1];

        for (int item = 1; item <= weight.length; item++) {
            for (int capacity = 1; capacity <= knapsackCapacity; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxValWithCurr = 0; // We initialize this value to 0

                int weightOfCurr = weight[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
                    maxValWithCurr = value[item - 1]; // If so, maxValWithCurr is at least the value of the current item

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
                }

                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
            }
        }

        return mat[weight.length][knapsackCapacity];
    }

    public int[][] getMatrix() {
        return mat;
    }
}
