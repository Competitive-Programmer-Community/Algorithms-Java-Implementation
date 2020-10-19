package Sorting;

import java.util.Arrays;

// time: O(n + k)
// space: O(n + k)
// n is the # of element, k is the max diff val in the array
// 稳定性排序算法
public class CountSort {
    public static void countSort(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] count = new int[max - min + 1]; // k
        for (int num: nums) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) { // k
            count[i] += count[i - 1];
        }

        int[] output = new int[nums.length]; // n
        for (int i = nums.length - 1; i >= 0; i--) { // n
            output[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min]--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
