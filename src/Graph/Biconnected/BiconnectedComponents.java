package Graph.Biconnected;

// find out all the bridges in the graph
// remove bridges from the graph, the remaining will be the biconnected components

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Graph.Tarjan.bridges.criticalConnections;

public class BiconnectedComponents {
    public static List<List<Integer>> biconnectedComponents(int n, List<List<Integer>> connections){
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> bridges = criticalConnections(n, connections);
        for (List<Integer> connection: connections) {
            for (List<Integer> bridge: bridges) {
                String s = connection.get(0) + ":" + connection.get(1);
                String t = bridge.get(0) + ":" + bridge.get(1);
                String x = bridge.get(1) + ":" + bridge.get(0);
                if (!s.equals(t) && !s.equals(x)) {
                    ans.add(connection);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        List<List<Integer>> ans = biconnectedComponents(n, connections);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
