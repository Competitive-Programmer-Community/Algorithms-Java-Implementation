package Graph.Traversal;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {
    /**
     * Resursion DFS in 非联通无向图
     * @param list
     */
    public static void dfsInGraphs(List<GraphNode> list) {
        HashSet<GraphNode> set = new HashSet<>();
        for (GraphNode node: list) {
            if (!set.contains(node)) {
                dfs(node, set);
            }
        }
    }

    private static void dfs(GraphNode node, HashSet<GraphNode> set) {
        set.add(node);
        for (GraphNode neighbor: node.neighbors) {
            if (!set.contains(neighbor)) {
                dfs(neighbor, set);
            }
        }
    }

    /**
     * Resursion DFS in 联通无向图
     * @param node
     */
    public static void dfsInGraph(GraphNode node) {
        HashSet<GraphNode> set = new HashSet<>();
        dfs(node, set);
    }

    /**
     * No-Resursion DFS in 联通无向图
     * @param node
     */
    public static void dfsGraphIteration(GraphNode node) {
        HashSet<GraphNode> set = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            node = stack.pop();
            set.add(node);
            for (GraphNode neighbor: node.neighbors) {
                if (!set.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }

    }

    /**
     * dfs in matrix
     * @param matrix
     */
    public static void dfsInMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                dfs(matrix, visited, i);
            }
        }
    }

    /**
     * Resursion DFS in matrix
     * @param matrix
     * @param visited
     * @param vertex
     */
    public static void dfs(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        for (int i = 0; i < matrix[vertex].length; i++) {
            if (matrix[vertex][i] == 1) {
                if (visited[i] == 0) {
                    dfs(matrix, visited, i);
                }
            }
        }
    }

    /**
     * No-Recursion DFS in matrix
     * @param matrix
     */
    public static void dfsMatrixIteration(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                stack.push(i);
                while(!stack.isEmpty()) {
                    int vertex = stack.pop();
                    visited[vertex] = 1;
                    for (int j = 0; j < matrix[vertex].length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                stack.push(j);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
