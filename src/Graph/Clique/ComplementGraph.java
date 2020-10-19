package Graph.Clique;

import java.util.Arrays;

// The complement graph is another graph in which all vertices that are adjacent in the original graph are disconnected
// all vertices that are not adjacent in the original graph are adjacent.

public class ComplementGraph {
    public static int[][] complementGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] ^= 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] complement = complementGraph(graph);
        for (int i = 0; i < complement.length; i++) {
            System.out.println(Arrays.toString(complement[i]));
        }
    }
}
