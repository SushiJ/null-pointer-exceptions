package sorts;

public class SelectionSort {
    public static void selection_sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; ++i) {
            int currMinIdx = i;
            for(int j = i+1; j < arr.length; ++j) {
                if(arr[j] < arr[currMinIdx]) {
                    currMinIdx = j;
                }
            }
            if(currMinIdx != i) {
                int temp = arr[i];
                arr[i] = arr[currMinIdx];
                arr[currMinIdx] = temp;
            }
        }
    }
}
