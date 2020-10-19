package Graph.TopSort;

import java.util.LinkedList;
import java.util.Queue;

public class BFSofTop {
    // 以入度为0的点为起点进行BFS
    // 如果没有入度为0的点则必有环，反之不一定
    public int[] BFSofTop(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // 计算入度
        int[] indegree = new int[numCourses];
        for (int[] pair: prerequisites) {
            indegree[pair[0]]++;
        }

        int k = 0;
        // 遍历所有节点，将入度为0的点加入queue中作为访问起点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                ans[k++] = i;
            }
        }

        // 每次从queue中拿出一个元素，就将当前元素的下一个元素入度-1，next node入度为0时将其放入queue中作为新的起点
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair: prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        ans[k++] = pair[0];
                    }
                }
            }
        }

        // 是否可以上完所有课程，取决于有向图中是否有环（循环依赖）
        return k == numCourses ? ans: new int[0];
    }
}
