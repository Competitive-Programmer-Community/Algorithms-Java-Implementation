package Graph.Traversal;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS: 搜索N层, 每层判断量为X, 则搜索判断总量为X^N
 * Bidirectional BFS: 定义两个起点, 分别搜索N / 2 层, 判断量为 2 * X^ (N / 2)
 * 当N很大时, 双向BFS效率更高
 */

public class BidirectionalBFS {
    public int bidirectionalBFS(GraphNode start, GraphNode end) {
        Queue<GraphNode> startQueue = new LinkedList<>();
        HashSet<GraphNode> startVisited = new HashSet<>();
        startQueue.offer(start);
        startVisited.add(start);

        Queue<GraphNode> endQueue = new LinkedList<>();
        HashSet<GraphNode> endVisited = new HashSet<>();
        endQueue.offer(end);
        endVisited.add(end);

        int ans = 0;
        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            ans++;
            for (int i = 0; i < startSize; i++) {
                GraphNode node = startQueue.poll();
                for (GraphNode neighbor: node.neighbors) {
                    if (endVisited.contains(neighbor)) {
                        return ans;
                    }
                    if (!startVisited.contains(neighbor)) {
                        startVisited.add(neighbor);
                        startQueue.offer(neighbor);
                    }
                }
            }

            int endSize = endQueue.size();
            ans++;
            for (int i = 0; i < endSize; i++) {
                GraphNode node = endQueue.poll();
                for (GraphNode neighbor: node.neighbors) {
                    if (startVisited.contains(neighbor)) {
                        return ans;
                    }
                    if (!endVisited.contains(neighbor)) {
                        endVisited.add(neighbor);
                        endQueue.offer(neighbor);
                    }
                }
            }
        }

        return -1;
    }
}
