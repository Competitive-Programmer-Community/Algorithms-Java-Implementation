package Sorting;

import java.util.Arrays;

public class SelectionSort {
    /**
     * time: O(n^2)
     * space: O(1)
     * stabilization: unstable 1 3 1 0 0 3
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

