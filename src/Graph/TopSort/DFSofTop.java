package Graph.TopSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 拓扑排序 in 有向图(DFS)
 */
public class DFSofTop {
    public int[] topSort(int numCourses, int[][] prerequisites) {
        /**
         * 预处理，建立graph
         */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());

        }
        // prev -> next
        for (int[] pair: prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        /**
         * DFS:
         * 0: not visited, 1: visiting 2: visited
         * <key node, state value>
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (map.get(i) == 0) {
                // helper函数返回false，说明不符合topSort规则
                if (!helper(graph, map, ans, i)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            // 最后需要倒序输出
            result[i] = ans.get(numCourses - i - 1);
        }

        return result;
    }

    private boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> map, List<Integer> ans, int i) {
        if (map.get(i) == 2) {
            return true;
        }
        if (map.get(i) == 1) {
            return false;
        }

        map.put(i, 1);
        for (int j: graph.get(i)) {
            if (!helper(graph, map, ans, j)) {
                return false;
            }
        }

        map.put(i, 2);
        // 逆序加入
        ans.add(i);
        return true;
    }
}
