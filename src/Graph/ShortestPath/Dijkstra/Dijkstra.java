package Graph.ShortestPath.Dijkstra;

import java.util.*;

public class Dijkstra {

    /**
     * 以Edge List的形式表示graph，当给定graph为稀疏图时效率较高
     * time: O((V + E)logV)
     * 求正权图中单源点到有各个节点的最短距离
     */

    private static class Pair {
        public int index;
        public int dist;
        public Pair(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public static void dijkstra(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];
        int[] prev = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        // 定义一个pq按照pair的dist从小到大排序
        PriorityQueue<Pair> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o1.dist - o2.dist;
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int start = pair.index;
            // optimization for duplicate key-value pairs in heap, if current dist < minDist, no need to update other nodes based on current dist
            if (minDist[start] < pair.dist) {
                continue;
            }

            visited[start] = true;
            List<Edge> edges = graph.list[start];
            for (Edge edge: edges) {
                if (visited[edge.end]) {
                    continue;
                }

                int end = edge.end;
                int curDist = minDist[start] + edge.weight;
                if (curDist < minDist[end]) {
                    minDist[end] = curDist;
                    prev[end] = start;
                    pq.offer(new Pair(end, minDist[end]));
                }

            }

                // stop early if we only need the shortest distance between source and distination node
////            if (distination == start) {
////                return minDist[start];
////            }
        }


          // 打印当前给定source 0 到图中每个节点的最短距离
//        print(minDist);
    }

    // print the length of shortest path from source 0 to every node
    public static void print(int[] minDist) {
        System.out.println("Dijkstra: ");
        for (int i = 0; i < minDist.length; i++) {
            System.out.println("Source Vertex 0 to Destination Vertex " + i + " minDist: " + minDist[i]);
        }
    }

    // print the shortest path from start to end
    public static void findShortestPath(int[] minDist, int[] prev, int start, int end) {
        List<Integer> path = new LinkedList<>();
        if (minDist[end] == Integer.MAX_VALUE) {
            return;
        }

        for (Integer at = end; at != null; at = prev[at]) {
            path.add(0, end);
        }

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);
        dijkstra(graph);
    }
}
