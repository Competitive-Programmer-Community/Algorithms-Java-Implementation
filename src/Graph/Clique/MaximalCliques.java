package Graph.Clique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Using Bron Kerbosch algorithm to find maximal cliques in O(3^(N/3))
// https://iq.opengenus.org/bron-kerbosch-algorithm/

public class MaximalCliques {
    public static void find_maximal_cliques(List<Set<Integer>> list, List<Integer> potential_clique,
                                            List<Integer> remaining_nodes, List<Integer> skip_nodes, List<List<Integer>> ans) {
        if (remaining_nodes.size() == 0 && skip_nodes.size() == 0) {
            ans.add(new ArrayList<>(potential_clique));
            return;
        }

        for (Integer node: remaining_nodes) {
            List<Integer> new_potential_clique = new ArrayList<>(potential_clique);
            new_potential_clique.add(node);

            List<Integer> new_remaining_nodes = new ArrayList<>();
            for (Integer remain : remaining_nodes) {
                if (list.get(node).contains(remain)) {
                    new_remaining_nodes.add(remain);
                }
            }

            List<Integer> new_skip_nodes = new ArrayList<>();
            for (Integer skip : skip_nodes) {
                if (list.get(node).contains(skip)) {
                    new_skip_nodes.add(skip);
                }
            }

            find_maximal_cliques(list, new_potential_clique, new_remaining_nodes, new_skip_nodes, ans);
            remaining_nodes.remove(node);
            skip_nodes.add(node);
        }
    }

    public static List<List<Integer>> maximalCliques(int[][] graph) {
        List<Set<Integer>> list = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> remaining_nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remaining_nodes.add(i);
        }

        find_maximal_cliques(list, new ArrayList<>(), remaining_nodes, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0}
        };

        List<List<Integer>> ans = maximalCliques(graph);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
}
