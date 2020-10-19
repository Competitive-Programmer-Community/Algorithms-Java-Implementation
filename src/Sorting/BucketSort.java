package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// !!!
public class BucketSort {
    /**
     * n: 待排元素个数，m为桶个数
     * time:
     * best: O(n)
     * worse: 无意义
     * 平均: O(n + c) c = n * (logn ~ logm)
     * space: O(n + m)
     * stabilization：stable
     * @param nums
     */
    public static void bucketSort(int[] nums) {
        // 1 取得待排数组中的最大值max和最小值min
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // 2 根据元素取值区间定义分配bucket
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        // 3 将nums数组中的依次元素加入对应bucket中
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }

        // 4 针对每一个bucket，分别进行排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        // 5 将bucket中的元素依次加入原数组，返回结果
        System.out.println(bucket.toString());

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8, 20};
        bucketSort(nums);
    }
}
