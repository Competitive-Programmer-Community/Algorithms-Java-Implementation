package Graph.ShortestPath.BellmanFord;

import java.util.Arrays;

public class BellmanFord {
    /**
     * 以Edge List的形式表示graph，以edge为研究对象，无须关系顶点
     * time: O(E * V)
     * 求有权图中(正权/负权)单源点到有各个节点的最短距离
     */

    public static void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        // 最多进行n-1次iteration，确定其他n-1个节点到达source的最短距离
        for (int i = 0; i < graph.vertices - 1; i++) {
            // 每次遍历所有的边，更新所有点的权值 ->  优化，无需遍历所有edge
            for (int j = 0; j < graph.edges.size(); j++) {
                Edge edge = graph.edges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }
        }

        // 进行第n次iteration，判断是否存在负权环，并将被负权边影响的节点距离标记为负无穷
        for (int j = 0; j < graph.edges.size(); j++) {
            Edge edge = graph.edges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                minDist[end] = Integer.MIN_VALUE;
            }
        }

        print(minDist);
    }

    public static void print(int[] minDist) {
        System.out.println("BellmanFord : ");
        for (int i = 0; i < minDist.length; i++) {
            System.out.println("Source Vertex 0 : to Vertex " + i + " minDist : " + minDist[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2, 1, 1);
        graph.addEdge(3, 2, -2);
        graph.addEdge(1, 3, 2);
        graph.addEdge(4, 3, -1);
        graph.addEdge(4, 1, -4);
        graph.addEdge(5, 4, 1);
        graph.addEdge(0, 5, 8);
        graph.addEdge(0, 1, 10);
        bellmanFord(graph);
    }
}
