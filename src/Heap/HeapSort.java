package Heap;

import java.util.Arrays;

public class HeapSort {
    /**
     * 根据给定的nums array，构建一个最大堆
     * time: O(nlogn)
     * space: O(1)
     * @param nums
     */
    public static void heapSort(int[] nums) {
        // 从最后一个非叶子节点开始向下一个个进行heapify调整
        // 1 建堆 O(n)
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));

        // 2 每次poll出堆顶元素，然后对堆进行shift down调整 O(nlogn)
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    // 对nums[root]进行shift down
    private static void heapAdjust(int[] nums, int root, int length) {
        int child = 2 * root + 1;
        while(child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[root] < nums[child]) {
                swap(nums, root, child);
            } else {
                break;
            }

            root = child;
            child = 2 * root + 1;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 23, 30, 32, 8, 31, 41, 1, 15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
