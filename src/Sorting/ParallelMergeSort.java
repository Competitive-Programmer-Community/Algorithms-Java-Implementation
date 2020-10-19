package Sorting;

import java.util.Arrays;

// 对于给定array的左右部分的mergeSort相互独立，可以分配不同的threads独立执行
// 最后将sort之后的左右部分进行合并
// 需要指定threads的个数，防止创建太多线程

public class ParallelMergeSort {
    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, index = 0;
        while(i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[index++] = nums[i++];
        }
        while(j <= end) {
            temp[index++] = nums[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[start + k] = temp[k];
        }
    }

    private static Thread mergeSortParallel(int[] nums, int start, int end, int numOfThreads) {
        return new Thread() {
            @Override
            public void run() {
                parallelMargeSort(nums, start, end, numOfThreads / 2);
            }
        };
    }


    public static void parallelMargeSort(int[] nums, int start, int end, int numOfThreads) {
        if (numOfThreads <= 1) {
            mergeSort(nums, start, end);
            return;
        }

        int mid = start + (end - start) / 2;
        Thread left = mergeSortParallel(nums, start, mid, numOfThreads);
        Thread right = mergeSortParallel(nums, mid + 1, end, numOfThreads);
        left.start();
        right.start();

        try {
            left.join();
            right.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(nums, start, mid, end);
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        parallelMargeSort(nums, 0, nums.length - 1, 4);
        System.out.println(Arrays.toString(nums));
    }
}
