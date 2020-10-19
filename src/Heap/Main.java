package Heap;

import Heap.HeapImpl.MaxHeap;

public class Main {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Integer[] nums = new Integer[]{2, 23, 30, 32, 8, 31, 41, 1, 15};
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        maxHeap.print();
    }
}
