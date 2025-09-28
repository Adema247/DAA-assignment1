package com.daa;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    void testRandomArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] copy = arr.clone();

        MergeSort.sort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = arr.clone();

        MergeSort.sort(arr);

        assertArrayEquals(copy, arr);
    }

    @Test
    void testReversed() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] copy = arr.clone();

        MergeSort.sort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }
}
