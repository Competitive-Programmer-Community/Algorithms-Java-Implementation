package Sorting;

import java.util.Arrays;

// a variance of insertion sort
// 1 find out 1st nums[i] < nums[i - 1]
// 2 move nums[i] to left side until nums[i] >= nums[i - 1]
// 3 continue from the location at step 1, until reach the end of array

// time: O(n^2)
// space: O(1)
// 稳定性排序算法

public class GnomeSort {
    public static void gnomeSort(int[] nums) {
        int index = 1;
        int pos = 2;
        while(index < nums.length) {
            if (nums[index - 1] > nums[index]) {
                int temp = nums[index - 1];
                nums[index - 1] = nums[index];
                nums[index] = temp;

                index--;
                if (index == 0) {
                    index = pos++;
                }
            } else {
                index = pos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        gnomeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
