package Graph.Coloring;

// dfs + backtracking:
// 1 for every node, check all available colors and assign that color to current node
// 2 then for next node, repeat step 1, if no available color, then return false
// 3 after checking all nodes, we can say that it is possible to assign m colors to the graph

// time: O(m*n^2)
// space: O(n)

public class MColoringProblem {

    private static boolean isSafe(int[][] graph, int cur, int c, int[] color) {
        for (int i = 0; i < graph[cur].length; i++) {
            if (graph[cur][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }

    public static boolean mColoringProblem(int[][] graph, int m, int[] color, int cur) {
        if (cur >= graph.length) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, cur, c, color)) {
                color[cur] = c;
                if (mColoringProblem(graph, m, color, cur + 1)) {
                    return true;
                }
                color[cur] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        int n = graph.length;
        int[] color = new int[n];
        int m = 3;
        if (mColoringProblem(graph, m, color, 0)) {
            for (int i = 0; i < n; i++) {
                System.out.println("node: " + i + " - color: " + color[i]);
            }
        } else {
            System.out.println("There are no solutions to color all nodes in graphs with " + m + " colors");
        }
    }
}
