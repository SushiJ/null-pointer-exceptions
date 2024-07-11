package sorts;

public class MergeSort {
    public static void merge_sort(int[] arr, int[] result) {
        MergeSort.ms(arr, result, 0, arr.length - 1);
    }

    private static void ms(int[] arr, int[] result, int low, int high) {
        if(low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        ms(arr, result, low, mid);
        ms(arr, result, mid + 1, high);
        merge(arr, result, low, mid, high);
    }
    private static void merge(int[] arr, int[] result, int low, int mid, int high) {
        int k = low, i = low, j = mid + 1;

        while(i < mid && j < high) {
            if(arr[i] <= arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            result[k] = arr[i];
            k++;
            i++;
        }
        while (j <= high) {
            result[k] = arr[j];
            k++;
            j++;
        }
    }
}
