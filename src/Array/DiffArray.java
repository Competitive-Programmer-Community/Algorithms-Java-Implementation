package Array;

import java.util.Arrays;

/**
    差分：前缀和逆运算
    基于给定的a数组, 构造一个b数组满足：
    a[i] = b[0] + b[1] + … + b[i], 可以通过
    b[0] = a[0] -> b[i] = a[i] - a[i - 1]
    则a数组为b数组的前缀和数组，b数组为a数组的差分数组

    应用：针对a数组，在指定区间[l, r]之间的所有元素 + c，重复m次这样的操作，返回最终的a数组
    1 初始化全为0的差分数组b，然后通过insert(l, r, c)的方式插入a中数组元素
    2 然后进行指定区间的插入操作，基于差分数组b求前缀和数组a

    https://www.acwing.com/problem/content/799/
    https://leetcode.com/problems/range-addition/

    time: O(n)
    space: O(n)
 **/

public class DiffArray {
    private static void insert(int[] diff, int l, int r, int c) {
        diff[l] += c;
        if (r + 1 < diff.length) {
            diff[r + 1] -= c;
        }
    }

    private static int[] addRange(int[] nums, int[][] updates) {
        int n = nums.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            insert(diff, i, i, nums[i]);
        }

        for (int[] update: updates) {
            int l = update[0], r = update[1], c = update[2];
            insert(diff, l, r, c);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            nums[i] = sum;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 2, 1};
        int[][] updates = {
                {0, 2, 1},
                {2, 4, 1},
                {0, 5, 1}
        };

        // 3 4 5 3 4 2
        System.out.println(Arrays.toString(addRange(nums, updates)));
    }
}
