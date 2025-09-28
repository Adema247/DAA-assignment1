package com.daa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testApp() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testMergeSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr);
    }

    @Test
    void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr);
    }

    @Test
    void testSelect() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int result = Select.select(arr, 0, arr.length - 1, 3);
        assertEquals(5, result);
    }


}
