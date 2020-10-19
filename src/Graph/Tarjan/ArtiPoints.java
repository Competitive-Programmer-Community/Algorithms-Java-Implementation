package Graph.Tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtiPoints {
    // Graph.Tarjan's algorithm: use one pass dfs to find out articulation points (without which, there will be more connected components)
    // time: O(n)
    // space: O(n)

    // 1 if there is a cycle in given graph, then there must be one articulation point
    // 2 if there is a bridge in given graph, then one of the two points in bridge must be one articulation point
    // 3 the degree of articulation points must >= 2

    private static int id = 0;

    private static int outEdgeCount = 0;

    public static boolean[] findArtiPoints(int n, List<List<Integer>> connections) {
        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] isArt = new boolean[n];
        Arrays.fill(ids, -1);

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection: connections) {
            int u = connection.get(0), v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                // reset outEdgeCount is 0, count the out degree of current node
                outEdgeCount = 0;
                dfs(i, i, -1, ids, low, graph, isArt);
                isArt[i] = isArt[i] && (outEdgeCount > 1);
            }
        }

        return isArt;
    }

    private static void dfs(int root, int cur, int parent, int[] ids, int[] low, ArrayList<Integer>[] graph, boolean[] isArt) {
        if (parent == root) {
            outEdgeCount++;
        }

        ids[cur] = low[cur] = id++;
        for (Integer next: graph[cur]) {
            if (next == parent) {
                continue;
            }

            if (ids[next] == -1) {
                dfs(root, next, cur, ids, low, graph, isArt);
                low[cur] = Math.min(low[cur], low[next]);
                // 条件1：如果存在bridge
                if (ids[cur] < low[next]) {
                    isArt[cur] = true;
                }
                // 条件2：如果存在cycle
                if (ids[cur] == low[next]) {
                    isArt[cur] = true;
                }
            } else {
                low[cur] = Math.min(low[cur], ids[next]);
            }
        }
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        boolean[] isArt = findArtiPoints(n, connections);
        System.out.println(Arrays.toString(isArt));
    }
}
