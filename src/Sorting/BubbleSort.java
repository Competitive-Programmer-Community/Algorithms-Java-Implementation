package Sorting;

import java.util.Arrays;

// time: O(n^2)
// space: O(1)
// 稳定性排序算法
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        boolean swaped = true;
        while(swaped) {
            swaped = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swaped = true;
                }
            }
        }
    }

    public static void bubbleSort_optimized(int[] nums) {
        boolean swaped = true;
        int n = nums.length - 1;

        while(swaped) {
            swaped = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swaped = true;
                }
            }
            n--;
        }
    }

    public static void bubbleSort_optimized_more(int[] nums) {
        boolean swaped = true;
        int n = nums.length - 1, m = nums.length - 1;

        while(swaped) {
            swaped = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swaped = true;
                    m = i;
                }
            }

            n = m;
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        int[] arr = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        bubbleSort_optimized(arr);
        System.out.println(Arrays.toString(arr));

        int[] temp = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        bubbleSort_optimized_more(temp);
        System.out.println(Arrays.toString(temp));

    }
}
