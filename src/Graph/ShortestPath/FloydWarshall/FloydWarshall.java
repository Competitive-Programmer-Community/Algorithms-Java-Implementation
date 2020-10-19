package Graph.ShortestPath.FloydWarshall;

public class FloydWarshall {

    /**
     * all - pairs shortest path algorithm: 求出图中任意给定两点i和j之间的最短距离
     * time: O(V * V * V)
     * space: O(V * V)
     * @param graph
     */

    public static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] minDist = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    minDist[i][j] = 0;
                } else if (graph[i][j] != 0) {
                    minDist[i][j] = graph[i][j];
                } else {
                    minDist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 从 i to j 的最短距离 = min(route through [0, k], 从 i to j 的距离)
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (minDist[i][j] > minDist[i][k] + minDist[k][j]) {
                        minDist[i][j] = minDist[i][k] + minDist[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
