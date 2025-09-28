package com.daa;

import java.util.Random;

public class QuickSort {

    public static long comparisons = 0;
    public static int maxDepth = 0;
    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        comparisons = 0;
        maxDepth = 0;
        quicksort(arr, 0, arr.length - 1, 1);
    }

    private static void quicksort(int[] arr, int left, int right, int depth) {
        if (left >= right) return;

        maxDepth = Math.max(maxDepth, depth);

        // randomized pivot
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];

        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) { comparisons++; i++; }
            while (arr[j] > pivot) { comparisons++; j--; }
            if (i <= j) {
                swap(arr, i, j);
                i++; j--;
            }
        }

        // recurse only on smaller side
        if ((j - left) < (right - i)) {
            if (left < j) quicksort(arr, left, j, depth + 1);
            if (i < right) quicksort(arr, i, right, depth + 1);
        } else {
            if (i < right) quicksort(arr, i, right, depth + 1);
            if (left < j) quicksort(arr, left, j, depth + 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
