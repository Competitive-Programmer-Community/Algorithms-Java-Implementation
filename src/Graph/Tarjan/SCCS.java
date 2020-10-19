package Graph.Tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SCCS {
    // Graph.Tarjan's algorithm: use one pass dfs to find out the # of strongly connected components in the given graph
    // time: O(n)
    // space: O(n)

    private static int id = 0;

    private static int sccCount = 0;

    private static int[] findSccs(int n, List<List<Integer>> connections) {
        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] onStack = new boolean[n];
        Arrays.fill(ids, -1);
        Stack<Integer> stack = new Stack<>();

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

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i, ids, low, stack, onStack, graph);
            }
        }

        return low;
    }

    private static void dfs(int cur, int[] ids, int[] low, Stack<Integer> stack, boolean[] onStack, ArrayList<Integer>[] graph) {
        stack.push(cur);
        onStack[cur] = true;
        ids[cur] = low[cur] = id++;

        // visit all neighbors && minimize the low-link value when backtracking
        for (Integer next: graph[cur]) {
            if (ids[next] == -1) {
                dfs(next, ids, low, stack, onStack, graph);
            }
            if (onStack[next]) {
                low[cur] = Math.min(low[cur], low[next]);
            }
        }

        // after visiting all neighbors, if current node is the start of SCC
        // then pop all the associated nodes from stack until going back to the start of SCC
        if (ids[cur] == low[cur]) {
            for (Integer node = stack.pop();; node = stack.pop()) {
                onStack[node] = false;
                // update the low-link value of associated nodes to the id of the start node of SCC
                low[node] = ids[cur];
                if (node == cur) {
                    break;
                }
            }
            sccCount++;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        int[] low = findSccs(n, connections);
        System.out.println(sccCount);
        System.out.println(Arrays.toString(low));
    }
}
