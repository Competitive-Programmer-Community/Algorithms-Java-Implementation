package Graph.Tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bridges {
    // Graph.Tarjan's algorithm: use one pass dfs to find out all the bridges in the graph
    // time: O(n)
    // space: O(n)

    // 1 use dfs to mark the node on path
    // 2 when backtracking, compare and update the low link value
    // 3 use the condition: ids[cur] < low[next] to find out the bridge (cur, next)

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // define id array and low link value array
        int[] ids = new int[n];
        int[] low = new int[n];
        Arrays.fill(ids, -1); // check whether the node i has been visited

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n]; // use adjcent list to show graph

        // initialize the undirected graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection: connections) {
            int u = connection.get(0), v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // check if node i has been visited to begin another dfs
        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i, ids, low, graph, ans, i);
            }
        }

        return ans;
    }

    private static int id = 0;

    private static void dfs(int cur, int[] ids, int[] low, ArrayList<Integer>[] graph,
                     List<List<Integer>> ans, int parent) {

        ids[cur] = low[cur] = id++;

        for (Integer next: graph[cur]) {
            // ignore parent node
            if (next == parent) {
                continue;
            }

            if (ids[next] == -1) {
                dfs(next, ids, low, graph, ans, cur);
                low[cur] = Math.min(low[cur], low[next]);
                // importance condition to check bridges
                if (ids[cur] < low[next]) {
                    ans.add(Arrays.asList(cur, next));
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


        List<List<Integer>> bridges = criticalConnections(n, connections);
        for (List<Integer> bridge: bridges) {
            System.out.println(bridge.toString());
        }

    }
}
