package Array;

import java.util.Arrays;

public class RotateMatrix {
    // 以主对角线为对称轴，翻转一半元素
    public static void diagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);
    }

    // 以副对角线为对称轴，翻转一半元素
    public static void counterDiagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        print(matrix);
    }

    // 以中心row为对称轴，翻转一半元素
    private static void horizontal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        print(matrix);
    }

    // 以中心col为对称轴，翻转一半元素
    private static void vertical(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        print(matrix);
    }

    // 顺时针旋转90度
    private static void clockwise90(int[][] matrix) {
        diagonal(matrix);
        vertical(matrix);
    }

    // 逆时针旋转90度
    private static void reverseClockwise90(int[][] matrix) {
        counterDiagonal(matrix);
        vertical(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        diagonal(matrix);
        System.out.println();
        counterDiagonal(matrix);
        System.out.println();
        horizontal(matrix);
        System.out.println();
        vertical(matrix);
    }
}

