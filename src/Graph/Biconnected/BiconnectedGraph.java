package Graph.Biconnected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Graph.Tarjan.ArtiPoints.findArtiPoints;

// check if there are articulation points in the given graph
// if no articulation points, then the graph is biconnected graph

public class BiconnectedGraph {
    public static boolean isBiconnectedGraph(int n, List<List<Integer>> connections) {
        boolean[] isArt = findArtiPoints(n, connections);
        for (int i = 0; i < isArt.length; i++) {
            if (isArt[i]) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        System.out.println("Given graph is " + isBiconnectedGraph(n, connections) + " biconnected graph");

    }
}
