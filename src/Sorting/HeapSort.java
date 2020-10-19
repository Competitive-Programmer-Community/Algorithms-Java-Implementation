package Sorting;

import java.util.Arrays;

// for every unsorted element in nums array, use heapify to compare it with its parents
// until the added element <= its parent, then we will get maxHeap
// time: O(nlogn)
// space: O(1)
// 非稳定性的排序算法
public class HeapSort {
    public static void heapSort(int[] nums) {
        int n = nums.length - 1;
        while(n > 0) {
            for (int i = 0; i <= n; i++) {
                heapify(nums, i);
            }

            int temp = nums[0];
            nums[0] = nums[n];
            nums[n] = temp;
            n--;
        }
    }

    private static void heapify(int[] nums, int index) {
        while(index != 0) {
            if (nums[index] > nums[index / 2]) {
                int temp = nums[index];
                nums[index] = nums[index / 2];
                nums[index / 2] = temp;
                index = index / 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
