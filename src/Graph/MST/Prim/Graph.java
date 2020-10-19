package Graph.MST.Prim;

import java.util.ArrayList;
import java.util.List;

// 邻接表形式表示无向有权图
public class Graph {
    int vertices;
    List<List<Edge>> list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            list.add(new ArrayList<>());
        }

    }

    // 由于为无向图，每次加入一个new edge时需要双向加入
    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        list.get(start).add(edge);

        edge = new Edge(end, start, weight);
        list.get(end).add(edge);
    }
}
