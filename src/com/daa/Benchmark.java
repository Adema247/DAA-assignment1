package com.daa;

import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000, 50000};

        for (int n : sizes) {
            int[] arr1 = generateArray(n);
            int[] arr2 = arr1.clone();

            long start, end;

            start = System.nanoTime();
            MergeSort.sort(arr1);
            end = System.nanoTime();
            System.out.println("MergeSort " + n + " elements: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            QuickSort.sort(arr2);
            end = System.nanoTime();
            System.out.println("QuickSort " + n + " elements: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("----------------------");
        }
    }

    private static int[] generateArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }
}
