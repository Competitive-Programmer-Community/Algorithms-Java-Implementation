package Sorting;

import java.util.Arrays;

public class InsertionSort {
    /**
     * time:
     * best: O(n^2)
     * worse: O(n^2)
     * average: O(n^2)
     * space: O(1)
     * stabilization: stable  -> 查找当前array中的最长递增子序列
     * @param nums
     */
    // swap元素到指定位置
    public static void insertSort(int[] nums) {
        // 锁定第i个待插入元素
        for (int i = 0; i < nums.length; i++) {
            // 将其从后往前交换
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    // 找到位置之后返回
                    break;
                }
            }
        }
    }

    /**
     * time:
     * best: O(n)     sorted array
     * worse: O(n^2)  reversed array
     * average: O(n^2)  random array
     * space: O(1)
     * @param nums
     */
    // 移动元素到指定位置（最优）
    public static void insertSort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i, temp = nums[j];
            while(j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * time:
     * best: O(nlogn)     sorted array
     * worse: O(n^2)  reversed array
     * average: O(n^2)  random array
     * space: O(1)
     * @param nums
     */
    // 在前面sorted array中二分查找到待排元素的位置
    public static void insertSort3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 确定待排元素target和插入区间[0, i]
            int target = nums[i + 1];
            int left = 0, right = i;
            // 在[0, i]中找到第一个>target的元素位置left
            while(left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 将[left, i]区间的元素后移一位
            for (int j = i; j >= left; j--) {
                nums[j + 1] = nums[j];
            }
            // 插入待排元素
            nums[left] = target;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        insertSort3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
