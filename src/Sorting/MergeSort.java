package Sorting;

import java.util.Arrays;

public class MergeSort {
    /**
     * time: O(nlogn)
     * space: O(n)  temp[]
     * stabilization: stable
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

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

        int index = 0, left = start, right = mid + 1;
        while(left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while(left <= mid) {
            temp[index++] = nums[left++];
        }

        while(right <= end) {
            temp[index++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}

