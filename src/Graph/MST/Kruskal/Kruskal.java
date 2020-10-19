package Graph.MST.Kruskal;

import UnionFind.UnionFind;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    /**
     * time: O(VlogE)
     * space: O(V)
     * @param graph
     */

    public static void kruskal(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> { return a.weight - b.weight; });
        pq.addAll(graph.edges);

        UnionFind uf = new UnionFind(graph.vertices);
        List<Edge> ans = new ArrayList<>();
        int components = graph.vertices;
        while(!pq.isEmpty()) {
            if (components <= 1) {
                break;
            }
            Edge edge = pq.poll();
            if (uf.connected(edge.start, edge.end)) {
                continue;
            }
            uf.union(edge.start, edge.end);
            components--;
            ans.add(edge);
        }
        print(ans);
    }

    public static void print(List<Edge> ans) {
        int total = 0;
        System.out.println("Kruskal: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("Edge: " + ans.get(i).start + " - " + ans.get(i).end + " weight: " + ans.get(i).weight);
            total += ans.get(i).weight;
        }

        System.out.println("Total: " + total);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);
        kruskal(graph);
    }
}
