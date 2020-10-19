package Array;

import java.util.Arrays;

/**
    prefixSum[i] = arr[0] + arr[1] + arr[i - 1]
    subArraySum[i][j] = prefixSum[j + 1] - prefixSum[i]

    https://leetcode.com/problems/range-sum-query-immutable/
    time: O(n)
    space: O(n)
 **/

public class PrefixArray {
    public static void prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        System.out.println(Arrays.toString(prefixSum));
    }

    public static void prefixSum2(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        prefixSum(arr);
    }
}
