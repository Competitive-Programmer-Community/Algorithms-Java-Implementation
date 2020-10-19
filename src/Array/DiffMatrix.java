package Array;


import java.util.Arrays;

/**
    二维差分(类似一维差分)
    基于二维matrix a, 假定存在一个matrix b为其差分矩阵，即a为b的前缀和矩阵
    在matrix a中[x1, y1][x2, y2]的sub matrix中所有元素加c，则只需要执行 

    b[x1][y1] += c
    b[x1][y2 + 1] -= c
    b[x2 + 1][y1] -= c
    b[x2 + 1][y2 + 1] += c

    https://www.acwing.com/solution/content/2137/

    time: O()
    space: O(m * n)
 **/

public class DiffMatrix {
    private static void insert(int[][] diff, int x1, int y1, int x2, int y2, int c) {
        diff[x1][y1] += c;
        if (y2 + 1 < diff[0].length) {
            diff[x1][y2 + 1] -= c;
        }
        if (x2 + 1 < diff.length) {
            diff[x2 + 1][y1] -= c;
        }
        if (x2 + 1 < diff.length && y2 + 1 < diff[0].length) {
            diff[x2 + 1][y2 + 1] += c;
        }
    }


    private static int[][] addRange(int[][] matrix, int[][] updates) {
        int m = matrix.length, n = matrix[0].length;
        int[][] diff = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                insert(diff, i, j, i, j, matrix[i - 1][j - 1]);
            }
        }

        for (int[] update: updates) {
            int x1 = update[0], y1 = update[1], x2 = update[2], y2 = update[3], c = update[4];
            insert(diff, x1 + 1, y1 + 1, x2 + 1, y2 + 1, c);
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                matrix[i - 1][j - 1] = diff[i][j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 1},
                {3, 2, 2, 1},
                {1, 1, 1, 1},
        };
        int[][] updates = {
                {0, 0, 1, 1, 1},
                {0, 2, 1, 2, 2},
                {2, 0, 2, 3, 1},
        };

        int[][] ans = addRange(matrix, updates);
        for (int[] row: ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}

