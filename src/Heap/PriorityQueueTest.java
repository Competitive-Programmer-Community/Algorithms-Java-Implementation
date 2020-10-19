package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    /**
     * 继承Comparator类，自定义排序函数
     * @param nums
     */
    private static void compare1(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num: nums) {
            heap.offer(num);
        }
        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }

    static class NumberComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }


    private static void compare2(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new NumberComparator());
        for (int num: nums) {
            heap.offer(num);
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }

    /**
     * 使用lambda表达式定义排序函数
     * time: O(nlogn)
     * space: O(n)
     * @param nums
     */
    private static void compare3(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int num: nums) {
            heap.offer(num);
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        compare1(nums);
        System.out.println();
        compare2(nums);
        System.out.println();
        compare3(nums);

    }
}
