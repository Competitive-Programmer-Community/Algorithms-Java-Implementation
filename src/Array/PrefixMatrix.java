package Array;

import java.util.Arrays;

/**
    https://leetcode.com/problems/range-sum-query-2d-immutable/
    time: O(m * n)
    space: O(m * n)
 **/

public class PrefixMatrix {
    // sub matrix sum from [0, 0] to [i, j] = prefixSum[i + 1][j + 1]
    // sub matrix sum from [i, j] to [a, b] = prefixSum[a + 1][b + 1] - prefixSum[i][j]
    private static void prefixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }

            System.out.println(Arrays.toString(prefixSum[i]));
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        prefixSum(matrix);
    }
}
