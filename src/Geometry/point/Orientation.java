package Geometry.point;

public class Orientation {
    // 判断A B C的方向
    // 0：共线  1：逆时针  2：顺时针
    public static int orientation(Point A, Point B, Point C) {
        int ans = (B.y - A.y) * (C.x - B.x) - (C.y - B.y) * (B.x - A.x);

        // 共线
        if (ans == 0) {
            return 0;
            // 右侧，顺时针
        } else if (ans > 0) {
            return 1;
            // 左侧，逆时针
        } else {
            return -1;
        }
    }
}
