package Sorting;

import java.util.Arrays;

public class QuickSort {
    /**
     * time:
     * best: O(nlogn)
     * worse: O(n^2)     reversed array
     * average: O(nlogn)
     * space: O(n ~ logn)    递归调用的栈空间
     * stabilization:
     * @param nums
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    // 每次确定一个元素pivot的位置
    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start], left = start + 1, right = end;
        while(left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while(left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        swap(nums, start, right);
        quickSort(nums, start, right - 1);
        quickSort(nums, left, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

