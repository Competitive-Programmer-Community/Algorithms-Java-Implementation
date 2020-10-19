package Geometry.point;

import static Geometry.point.Orientation.orientation;

/**
 * 判断C点是否在AB线段上面
 */
public class PointOnSegment {

    // 判断C点是否在AB线段之上: C的x坐标在AB之间，C的y坐标在AB之间，ABC三点共线
    public static boolean onSegment(Point C, Point A, Point B) {
        if (C.x >= Math.min(A.x, B.x) && C.x <= Math.max(A.x, B.x)
                && C.y >= Math.min(A.y, B.y) && C.y <= Math.max(A.y, B.y) && orientation(A, B, C) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Point A = new Point(1, 3);
        Point B = new Point(2, 4);
        Point C = new Point(3, 5);
        Point D = new Point(4, 6);

        System.out.println(onSegment(C, A, B));
        System.out.println(onSegment(B, A, D));
    }
}
