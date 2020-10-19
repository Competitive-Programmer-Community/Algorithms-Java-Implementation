package Graph.Traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /**
     * BFS in Graph
     * time: O(n)
     * space: O(n)
     * @param node
     */
    public static void bfsInGraph(GraphNode node) {
        HashSet<GraphNode> set = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        set.add(node);
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.label);
            for (GraphNode neighbor: node.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }

    }

    /**
     * BFS in Matrix
     * time: O(v * v)
     * space: O(v)
     * v 为节点个数
     * @param matrix
     */

    public static void bfsInMatrix(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int vertex = queue.poll();
                    visited[vertex] = 1;
                    System.out.println(vertex);
                    for (int j = 0; j < matrix[vertex].length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                queue.offer(j);
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
