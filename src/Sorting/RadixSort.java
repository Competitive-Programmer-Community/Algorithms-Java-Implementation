package Sorting;

import java.util.Arrays;

// 1 find out the max val in nums array to get max # of digits/loops
// 2 for every loop, use b^i to sort the corresponding digits of nums using counting sort
// 3 use count array to record the index of nums[i]

// time: O(logb(maxVal)*(n + b))
// space: O(n)
// 稳定性排序算法：取决于countSort的排序稳定性

public class RadixSort {
    private static int b = 10;

    public static void radixSort(int[] nums) {
        // find out the max val in nums to get max num of digits
        int maxVal = findMax(nums);
        for (int exp = 1; maxVal / exp != 0; exp *= b) {
            countSort(nums, exp);
        }
    }

    private static void countSort(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n];

        // use counting sort to record the order of digits
        int[] count = new int[b];
        for (int i = 0; i < n; i++) {
            count[nums[i] / exp % b]++;
        }
        // compute the index of each digits
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        // 根据count数组中的index，将对应的num元素放入output数组中
        for (int i = n - 1; i >= 0; i--) {
            output[count[nums[i] / exp % b] - 1] = nums[i];
            count[nums[i] / exp % b]--;
        }
        // 将sort之后的数组放入nums中
        for (int i = 0; i < n; i++) {
            nums[i] = output[i];
        }
    }

    private static int findMax(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
