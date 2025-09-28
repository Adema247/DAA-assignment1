package com.daa;

public class Metrics {
    public static long comparisons = 0;
    public static long allocations = 0;
    public static int currentDepth = 0;
    public static int maxDepth = 0;

    public static void reset() {
        comparisons = 0;
        allocations = 0;
        currentDepth = 0;
        maxDepth = 0;
    }

    public static void incComparison() {
        comparisons++;
    }

    public static void incAllocation() {
        allocations++;
    }

    public static void enterRecursion() {
        currentDepth++;
        maxDepth = Math.max(maxDepth, currentDepth);
    }

    public static void exitRecursion() {
        currentDepth--;
    }

    public static String report() {
        return "comparisons=" + comparisons +
                ", allocations=" + allocations +
                ", maxDepth=" + maxDepth;
    }
}