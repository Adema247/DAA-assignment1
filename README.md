Report
Project Architecture

The project consists of separate classes for each algorithm:

MergeSort — merge sort implementation.

QuickSort — quicksort with randomized pivot selection.

Select — k-th order statistic (Median of Medians).

Benchmark — measures execution time of the algorithms.

AppTest — correctness tests.

This separation makes it easy to test and compare the algorithms.

Algorithms and Analysis

MergeSort splits the array into halves, recursively sorts them, and merges.
Complexity: Θ(n log n).

QuickSort randomly chooses a pivot and recursively sorts the smaller partition.
Average complexity: Θ(n log n).

Select (Median of Medians) divides the array into groups of 5 and selects a good pivot.
Complexity: Θ(n).

Experiments

The algorithms were tested on arrays of different sizes. Results showed:

MergeSort and QuickSort grow approximately like n log n.

QuickSort is usually faster due to smaller constant factors.

Select demonstrates linear time, but the advantage is noticeable only on large arrays.

Conclusion

The theoretical analysis matched the practical measurements.
MergeSort and QuickSort are effective for sorting, while Select is useful for selection problems.
