package Sorting;

import java.util.Arrays;

// a variance of insertion sort
// time: O(n^2)
// space: O(1)

// 1 calculate the gap for the nums
// 2 for the element depart from gap index, compare and swap them
// 3 update gap to gap / 2, repeat 1-2 until gap to be 1 (insertion sort)

public class ShellSort {
    public static void shellSort(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums[i];

                int j = 0;
                for (j = i; j >= gap; j -= gap) {
                    if (nums[j - gap] > temp) {
                        nums[j] = nums[j - gap];
                    } else {
                        break;
                    }
                }

                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
