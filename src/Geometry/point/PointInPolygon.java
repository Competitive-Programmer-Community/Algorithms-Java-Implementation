package Geometry.point;


import static Geometry.point.Orientation.orientation;
import static Geometry.point.PointOnSegment.onSegment;

/**
 * 给定三个点，如果AB斜率=BC斜率，且有B这个公共点，则三点共线
 * 同样可以通过比较AB和BC的斜率大小，判断C点在AB的左侧/右侧
 * 共线定理: (x2-x1) * (y3-y1) = (x3-x1)(y2-y1)
 */

public class PointInPolygon {

    // 判断两个线段是否直接相交: 通过计算比较三点的orientation，确定其中一个线段的两个端点是否在另一线段的两侧(orientation不同)
    public static boolean segmentIntersect(Point p1, Point q1, Point p2, Point q2) {
        // 计算其中任意三点的orientation (一条线段两个端点 + 另一线段的一个端点)
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        // 如果orientation不同则被平分，两点在线段的两侧 (确认两条线段互相分割)
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // 如果orientation = 0，则三点共线，需要进一步判断给定点是否在线段之上 (需要验证所有点, 最后才能返回false)
        if (o1 == 0 && onSegment(p2, p1, q1)) {
            return true;
        }
        if (o2 == 0 && onSegment(q2, p1, q1)) {
            return true;
        }
        if (o3 == 0 && onSegment(p1, p2, q2)) {
            return true;
        }
        if (o4 == 0 && onSegment(q1, p2, q2)) {
            return true;
        }

        return false;
    }

    // 给定一个Points表示的多边形(连续节点)，判断point在多边形内部/上面/外部
    // 判断polygon的每条边[polygon[i], polygon[next]]和以point为起点, 向右无限延伸的直线[point, extreme]的交点总个数
    // 为奇数个则在polygon内部
    // 为偶数个：
    //         1 如果point在某条边上 则属于polygon内部 -> 判断point在某条边上：1 验证point与某条边polygon[i], polygon[next]共线； 2 判断point在polygon[i], polygon[next]坐标之间
    //         2 如果point不在边上 则属于polygon外部
    public static boolean pointInPolygon(Point[] polygon, Point point) {
        Point extreme = new Point(Integer.MAX_VALUE, point.y);
        int count = 0;
        for (int i = 0; i < polygon.length; i++) {
            int next = (i + 1) % polygon.length;
            if (segmentIntersect(polygon[i], polygon[next], point, extreme)) {
                if (onSegment(point, polygon[i], polygon[next])) {
                    return true;
                }

                count++;
            }
        }

        return count % 2 == 1;
    }

    public static void main(String[] args) {

    }
}
