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
        mat = new int[weight.length + 1][knapsackCapacity + 1];
        for (int item = 1; item <= weight.length; item++) {
            for (int capacity = 1; capacity <= knapsackCapacity; capacity++) {
                int currWeight = weight[item - 1];
                int valueWithCurrent = 0;
                int valueWithoutCurrent = mat[item - 1][capacity];
                if (currWeight <= capacity) {
                    int balanceWeight = capacity - currWeight;
                    valueWithCurrent = mat[item - 1][balanceWeight] + value[item - 1];
                }
                mat[item][capacity] = Math.max(valueWithCurrent, valueWithoutCurrent);
            }
        }
        return mat[weight.length][knapsackCapacity];
    }

    public int[][] getMatrix() {
        return mat;
    }
}
