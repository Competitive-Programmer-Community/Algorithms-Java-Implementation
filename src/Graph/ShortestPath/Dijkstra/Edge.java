package Graph.ShortestPath.Dijkstra;

/**
 有向边的定义
 */
public class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
