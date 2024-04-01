package sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubble_sort() {
        int arr[] = {9, 3, 7, 4, 69, 420, 42};
        int result[] = {3, 4, 7, 9, 42, 69, 420};
        BubbleSort.bubble_sort(arr);
        assertArrayEquals(result, arr);
    }
}