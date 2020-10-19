package Sorting;

public class DualPivotQuickSort {
    public static void dualPivotQuickSort(int[] arr) {
        dualPivotQuickSort(arr, 0, arr.length - 1);
    }

    private static void dualPivotQuickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        if (arr[start] > arr[end]) {
            swap(arr, start, end);
        }

        int pivot1 = arr[start], pivot2 = arr[end];
        int i = start, j = end, k = start + 1;

        while(k < j) {
            if (arr[k] < pivot1) {
                swap(arr, ++i, k++);
            } else if (arr[k] >= pivot1 && arr[k] <= pivot2) {
                k++;
            } else {
                ////////////// 难点！！！！！！////////////
                while(arr[--j] > pivot2) {
                    if (j <= k) {
                        break;
                    }
                }
                if (arr[j] < pivot1) {
                    swap(arr, k, j);
                    swap(arr, k, ++i);
                } else {
                    swap(arr, k, j);
                }
                k++;

            }
        }

        swap(arr, start, i);
        swap(arr, end, j);

        dualPivotQuickSort(arr, start, i - 1);
        dualPivotQuickSort(arr, i + 1, j - 1);
        dualPivotQuickSort(arr, j + 1, end);
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {

    }
}
