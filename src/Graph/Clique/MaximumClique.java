package Graph.Clique;


import java.util.ArrayList;
import java.util.List;

// a clique in a graph is a subset of the vertices in which all of the vertices are adjacent to each other
// greedy algorithm: start from node i, then check every other node j, whether can connect all nodes in current clique
// if node j can connect all nodes in current clique, then add the node j into current clique
// if not, then continue check other nodes
// compare the clique and find out the clique with max # of nodes

// time: O(n^3)
// space: O(n)

public class MaximumClique {
    public static List<Integer> maximumClique(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            // create a new clique, starting from node i
            List<Integer> clique = new ArrayList<>();
            clique.add(i);

            // check every other node j
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                // whether node j can connect all nodes in the clique
                int k = 0;
                for (k = 0; k < clique.size(); k++) {
                    int node = clique.get(k);
                    if (graph[j][node] == 0) {
                        break;
                    }
                }
                // if it is, then add node j into current clique
                if (k >= clique.size()) {
                    clique.add(j);
                }
            }

            // compare current clique with max clique and update ans
            ans = (ans.size() < clique.size() ? clique: ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 0}
        };

        List<Integer> maxClique = maximumClique(graph);
        System.out.println("maximum clique size: " + maxClique.size());
        System.out.println(maxClique);
    }
}
