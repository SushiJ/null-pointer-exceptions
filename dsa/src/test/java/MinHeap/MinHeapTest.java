package MinHeap;

import MinHeap.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    @Test
    void test_heap() {
        MinHeap heap = new MinHeap();

        Integer mock[] = {5, 3, 59, 420, 4, 1, 8, 7};
        for(int i: mock) {
            heap.insert(i);
        }
        assertEquals(1, heap.delete());
        assertEquals(3, heap.delete());
        assertEquals(4, heap.delete());
    }

    @Test
    void should_return_negative_if_empty_and_we_delete() {
        MinHeap heap = new MinHeap();
        assertEquals(-1, heap.delete());
    }
}
