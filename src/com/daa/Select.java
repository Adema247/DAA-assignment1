package com.daa;

public class Select {

    // k-й минимальный элемент (Median of Medians)
    public static int select(int[] arr, int left, int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right, medianOfMedians(arr, left, right));

            if (pos - left == k - 1)
                return arr[pos];

            if (pos - left > k - 1)
                return select(arr, left, pos - 1, k);

            return select(arr, pos + 1, right, k - pos + left - 1);
        }
        return Integer.MAX_VALUE; // ошибка
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        int pivotIndex = -1;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            java.util.Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int[] medians = new int[(n + 4) / 5];
        int m = 0;
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            java.util.Arrays.sort(arr, i, subRight + 1);
            medians[m++] = arr[i + (subRight - i) / 2];
        }
        return medianOfMedians(medians, 0, m - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
