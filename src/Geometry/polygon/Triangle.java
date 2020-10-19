package Geometry.polygon;

import java.util.Arrays;

public class Triangle {
    // 给定一个数组nums，判断当前数组元素可以组成多少个三角形 -> # of two sum > target
    // https://www.lintcode.com/problem/triangle-count/description
    // a + b > c (a, b < c)
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int start = 0, end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] <= nums[i]) {
                    start++;
                } else {
                    ans += (end - start);
                    end--;
                }
            }
        }

        return ans;
    }
}
