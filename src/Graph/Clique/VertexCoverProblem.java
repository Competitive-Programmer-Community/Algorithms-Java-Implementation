package Graph.Clique;


// minimum vertex cover problems:
// find out the minimum # of vertex in the given graph such that
// for every edge in the graph, there must be one of its vertex in the above vertex set

import java.util.*;

import static Graph.Clique.MaximumClique.maximumClique;

// minimum vertex cover -> V - maximum independent set -> V - maximum clique in the complement graph
// time: O(n^3)
// space: O(n)

public class VertexCoverProblem {
    public static List<Integer> minVertexCover(int[][] graph) {
        Set<Integer> maxClique = new HashSet(maximumClique(graph));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (maxClique.contains(i)) {
                continue;
            }
            ans.add(i);
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

        List<Integer> ans = minVertexCover(graph);
        System.out.println(ans);
    }
}
