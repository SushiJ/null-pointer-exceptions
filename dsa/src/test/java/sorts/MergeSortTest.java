package sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void merge_sort() {
        int[] arr = {9, 3, 7, 4, 69, 420, 42};
        int[] result = new int[7];
        MergeSort.merge_sort(arr, result);
        assertArrayEquals(result, arr);
    }
}