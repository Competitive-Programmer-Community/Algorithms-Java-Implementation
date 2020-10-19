package Graph.Coloring;

import java.util.Arrays;
import java.util.PriorityQueue;

// The least number of colors required to color a graph to guarantee that the adjacent nodes have different colors
// Welsh Powell Graph colouring approximate algorithm: may not get the min # of required colors, but a upper bound

// 1 find the degree of every vertex
// 2 sort all vertex with their degree to get vertex list
// 3 color the vertex with color i
// 4 move down the list to color all vertex that is not connected to current vertex
// 5 repeat step 4 for uncolored vertex in the list until all vertex colored

// time: O(n^2)
// space: O(n)

public class ChromaticNumber {
    public static int chromaticNumber(int[][] graph, int[] color, int n) {
        int[] degree = new int[n];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    degree[i]++;
                }
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{i, degree[i]});
        }

        int colorNum = 0;
        boolean[] avaliable = new boolean[n];
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            int node = cur[0];
            Arrays.fill(avaliable, true);
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && color[i] != -1) {
                    avaliable[color[i]] = false;
                }
            }

            int c = 0;
            for (c = 0; c < avaliable.length; c++) {
                if (avaliable[c]) {
                    colorNum = Math.max(colorNum, c + 1);
                    break;
                }
            }
            color[node] = c;
        }

        return colorNum;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        int colorNum = chromaticNumber(graph, color, n);
        System.out.println("The minimum required colors: " + colorNum);
        for (int i = 0; i < n; i++) {
            System.out.println("node: " + i + " - color: " + color[i]);
        }
    }
}
