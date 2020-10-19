package Graph.Clique;


// an independent set is a subset of the vertices in which none of the vertices are adjacent to each other
// cliques in a original graph become independent sets in its complement graph, and vice-versa
// to find out the Maximum Independent Set in the original set, just find out the maximum clique in its complement graph

import java.util.List;

import static Graph.Clique.ComplementGraph.complementGraph;
import static Graph.Clique.MaximumClique.maximumClique;


public class MaximumIndependentSet {
    private static List<Integer> maximumIndependentSet(int[][] graph) {
        int[][] complement = complementGraph(graph);
        List<Integer> ans = maximumClique(complement);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        List<Integer> maximumIndependentSet = maximumIndependentSet(graph);
        System.out.println("Maximum independent set size: " + maximumIndependentSet.size());
        System.out.println(maximumIndependentSet);
    }
}
