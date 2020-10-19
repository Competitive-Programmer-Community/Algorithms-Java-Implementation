package Graph.Matching;

import java.util.Arrays;

/**
 * 二分图最大匹配问题: 匈牙利算法
 * 左半边n个点，右半边m个点
 * 时间复杂度: O(n * m)
 */

public class Hungary {
    int[] person = new int[4];
    int[] place = new int[3];

    public void match(int[][] matrix) {
        Arrays.fill(person, -1);
        Arrays.fill(place, -1);
        int ans = 0; // 最大匹配数
        for (int i = 0; i < person.length; i++) {
            boolean[] visited = new boolean[place.length];
            if (hungary(matrix, i, visited)) {
                ans++;
            }
        }

        System.out.println("最大匹配个数: " + ans);
        System.out.println("person: " + Arrays.toString(person));
        System.out.println("place: " + Arrays.toString(place));
    }

    // 判断当前person i是否可以加入最大匹配图中
    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < place.length; end++) {
            // 从start -> end 没有边 / 当前end已经被访问过
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }

            visited[end] = true;
            // end没有被占用 / 如果end被占用，其对应的place[end]是否可以让位置
            if (place[end] == -1 || hungary(matrix, place[end], visited)) {
                person[start] = end;
                place[end] = start;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
        };
        Hungary hungary = new Hungary();
        hungary.match(matrix);
    }
}
