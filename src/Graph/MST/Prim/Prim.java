package Graph.MST.Prim;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    /**
     * 无向有权图
     * lazy version: may insert outdated edge into pq
     * time: O(ElogE)
     * space: O(V)
     * @param
     */

    public static void prim(Graph graph, int source) {
        boolean[] visited = new boolean[graph.vertices];
        int E = graph.vertices - 1, edgeCount = 0;
        Edge[] tree = new Edge[graph.vertices - 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        visited[source] = true;
        for (Edge edge: graph.list.get(source)) {
            pq.offer(edge);
        }

        while(!pq.isEmpty() && edgeCount != E) {
            Edge edge = pq.poll();
            // skip out-dated/stale edge
            if (visited[edge.end]) {
                continue;
            }

            tree[edgeCount++] = edge;
            visited[edge.end] = true;

            List<Edge> edges = graph.list.get(edge.end);
            for (int i = 0; i < edges.size(); i++) {
                Edge next = edges.get(i);
                if (visited[edge.end]) {
                    continue;
                }

                pq.offer(next);
            }
        }

        if (edgeCount != E) {
            System.out.println("The given graph cannot form minimum spaining tree!");
        } else {
            print(tree);
        }
    }

    public static void print(Edge[] tree) {
        int minWeight = 0;
        System.out.println("MST: ");
        for (int i = 0; i < tree.length; i++) {
            System.out.println("Edge : " + tree[i].start + " - " + tree[i].end + " weight : " + tree[i].weight);
            minWeight += tree[i].weight;
        }

        System.out.println("Total minimum weight: " + minWeight);
    }

//    public static void main(String[] args) {
//        Graph graph = new Graph(6);
//        graph.addEdge(0, 1, 6);
//        graph.addEdge(0, 2, 1);
//        graph.addEdge(0, 3, 5);
//        graph.addEdge(1, 2, 5);
//        graph.addEdge(1, 4, 3);
//        graph.addEdge(2, 4, 6);
//        graph.addEdge(2, 3, 5);
//        graph.addEdge(2, 5, 4);
//        graph.addEdge(3, 5, 2);
//        graph.addEdge(4, 5, 6);
//        Prim(graph);
//    }
}
