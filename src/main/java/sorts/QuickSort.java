package sorts;

public class QuickSort {
    public void quick_sort(int[] arr) {
        this.qs(arr, 0, arr.length - 1);
    }

    private int partition(int[] arr, int low, int high) {
       int pivot = arr[high];

       int idx = low -1;

       for(int i = low; i < high; ++i) {
           if(arr[i] <= pivot) {
               idx++;
               int temp = arr[i];
               arr[i] = arr[idx];
               arr[idx] = temp;
           }
       }

       idx++;
       arr[high] = arr[idx];
       arr[idx] = pivot;

       return idx;
    }

    private void qs(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivotIdx = partition(arr, low, high);
        this.qs(arr, low, pivotIdx - 1);
        this.qs(arr, pivotIdx + 1, high);
    }
}
