package Geometry.polygon;

import java.util.HashSet;
import java.util.List;

/**
 * 给定坐标系上的一些points，判断这些点能够组成多少个平行于X轴的正方形
 * time: O(n * n)
 * space: O(n)
 * n is the # of points
 */
public class Square {

    public static int countSquare(List<Point> points) {
        if (points == null || points.size() < 4) {
            return 0;
        }

        int ans = 0;
        HashSet<Point> set = new HashSet<>();
        for (Point point: points) {
            set.add(point);
        }

        HashSet<String> squares = new HashSet<>();
        // 正方形由其对角线两个顶点(node1, node2)唯一确定
        for (int i = 0; i < points.size(); i++) {
            Point node1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point node2 = points.get(j);
                // 判断邻边是否相等：正方形四条边相等
                // 判断node1和node2是否为同一个点
                if (Math.abs(node1.x - node2.x) != Math.abs(node1.y - node2.y) // 长方形需要去除邻边相等的条件
                        || node1.x == node2.x && node1.y == node2.y) {
                    continue;
                }

                // 在平行X轴的条件下，由node1和node2得出node3和node4，判断node3和node4是否在list中
                Point node3 = new Point(node1.x, node2.y);
                Point node4 = new Point(node2.x, node1.y);
                if (set.contains(node3) && set.contains(node4)) {
                    // 正方形可以用中点坐标和对角线长度唯一确定
                    // 判断当前正方形是否已经算过：同一正方形可以由正反对角线计算两次，避免重复
                    long len = (node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y);
                    double centerX = (node1.x + node2.x) / 2.0;
                    double centerY = (node1.y + node2.y) / 2.0;
                    String square = "" + len + "+" + centerX + "+" + centerY;
                    squares.add(square);
                }
            }
        }

        return squares.size();
    }
}
