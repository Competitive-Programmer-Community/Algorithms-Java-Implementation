package Sorting;

import java.util.Arrays;

public class ParallelQuickSort {
    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end, mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while(left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    private static Thread quickSortParallel(int[] nums, int start, int end, int numOfThreads) {
        return new Thread() {
            @Override
            public void run() {
                parallelQuickSort(nums, start, end, numOfThreads / 2);
            }
        };
    }

    public static void parallelQuickSort(int[] nums, int start, int end, int numOfThreads) {
        if (start >= end) {
            return;
        }
        if (numOfThreads <= 1) {
            quickSort(nums, start, end);
        }

        int left = start, right = end, mid = start + (end - start) / 2;
        int pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        Thread leftside = quickSortParallel(nums, start, right, numOfThreads);
        Thread rightside = quickSortParallel(nums, left, end, numOfThreads);

        leftside.start();
        rightside.start();

        try {
            leftside.join();
            rightside.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        parallelQuickSort(nums, 0, nums.length - 1, 4);
        System.out.println(Arrays.toString(nums));
    }
}
