package Sorting;

import java.util.Arrays;

// 1 找到待排序数组中的最大值
// 2 将最大值和第一个值进行交换
// 3 调用flip函数将最大值从第一个位置翻转到最后一个位置，并更新待排序数组的右边界--
// 4 循环以上step直到右边界到达0

// time: O(n^2)
// space: O(1)
// 非稳定性排序算法
// 排序算法的稳定性在对单个key进行排序时没有效果
// 对一些对象/key-value pairs排序时，可以保持其原有顺序

public class PancakeSort {
    public static void pancakeSort(int[] nums) {
        int n = nums.length - 1;

        while(n > 0) {
            int maxIndex = 0;
            for (int i = 0; i <= n; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            if (maxIndex == n) {
                n--;
                continue;
            }

            int temp = nums[maxIndex];
            nums[maxIndex] = nums[0];
            nums[0] = temp;
            flip(nums, n);
            n--;
        }
    }

    private static void flip(int[] nums, int end) {
        int start = 0;
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        pancakeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
