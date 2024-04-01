package sorts;

public class BubbleSort {
    public static void bubble_sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n - 1 - i; ++j) {
                if(arr[j] > arr[j + 1]) {
                    BubbleSort.swap(arr, j);
                }
            }
        }
    }
    private static void swap(int[] arr, int i) {
       int temp = arr[i];
       arr[i] = arr[i + 1];
       arr[i + 1] = temp;
    }
}
