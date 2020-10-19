package Geometry.polygon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * algo: bfs - 轮流将节点标记为1和-1，如果相邻两个节点color相同，则不是二分图
 * time: O(n + m)
 * space: O(n)
 * n is the # of nodes, m is the # of edges
 */

public class Bipartite {

    // 给定graph表示为为一个n x n的matrix，其中n为节点个数
    // 可以为无向图或有向图，可以联通或者非联通
    public static boolean isBipartite(int[][] graph) {
        // colors[i] 初始化为0，着色可以取值为1和-1
        // 当相邻节点着色值相同时，该graph非二分图

        int n = graph.length;
        int[] colors = new int[n];
        // 给定graph非联通时，需要遍历并check所有节点
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }

            colors[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                for (int next: graph[cur]) {
                    // 如果相邻节点着色值相同时，则不是二分图
                    if (colors[next] == colors[cur]) {
                        return false;
                    } else if (colors[next] == 0) {
                        colors[next] = - colors[cur];
                        queue.offer(next);
                    }
                }
            }
        }

        return true;
    }
}
