package Graph.MST.Kruskal;

import java.util.ArrayList;

public class Graph {
    public int vertices;
    // 只需要存储所有edges，无需关心节点
    public ArrayList<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    // 只需要关心weight，不需要关心节点顺序
    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        edges.add(edge);
    }
}
