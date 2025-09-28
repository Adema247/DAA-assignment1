package com.daa;

public class App {
    public static void main(String[] args) {
        System.out.println("=== MergeSort Test ===");
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(arr1);
        for (int x : arr1) System.out.print(x + " ");
        System.out.println("\n");

        System.out.println("=== QuickSort Test ===");
        int[] arr2 = {10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr2);
        for (int x : arr2) System.out.print(x + " ");
        System.out.println("\n");

        System.out.println("=== Deterministic Select Test ===");
        int[] arr3 = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int kthSmallest = Select.select(arr3, 0, arr3.length - 1, k);
        System.out.println(k + "-th smallest element is " + kthSmallest + "\n");

        System.out.println("=== Closest Pair of Points Test ===");
        ClosestPair.Point[] points = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };

        double result = ClosestPair.closestPair(points);
        System.out.println("Closest distance = " + result);
    }
}
