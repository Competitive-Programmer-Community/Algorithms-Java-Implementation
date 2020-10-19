package Geometry.point;

public class PointInTriangle {
    // 平面坐标系上给定三角形的三个点计算其面积
    // 海伦公式 -> ABC 在坐标系中顺序为三点按逆时针排列
    // |x1  y1  1|
    // |x2  y2  1|
    // |x3  y3  1|
    // S = [(x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3)] / 2.0
    // 合并同类项: S = [x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)] / 2.0
    public static double getArea(Point A, Point B, Point C) {
        return Math.abs(A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0;
    }

    // return 0 在边上
    //        1 在内部
    //       -1 在外部
    public static int pointIsInTriangle(Point A, Point B, Point C, Point X) {
        double S = getArea(A, B, C);
        double S1 = getArea(A, B, X);
        double S2 = getArea(B, C, X);
        double S3 = getArea(C, A, X);

        if (S1 == 0 || S2 == 0 || S3 == 0) {
            return 0;
        } else {
            return S == S1 + S2 + S3 ? 1: -1;
        }
    }

    public static void main(String[] args) {
        Point A = new Point(0, 3);
        Point B = new Point(0, 0);
        Point C = new Point(3, 0);

        Point X = new Point(3, 3); // 外面 -> -1
        System.out.println(pointIsInTriangle(A, B, C, X));

        Point Y = new Point(1, 1); // 里面 -> 1
        System.out.println(pointIsInTriangle(A, B, C, Y));

        Point Z = new Point(0, 0); // 边上 -> 0
        System.out.println(pointIsInTriangle(A, B, C, Z));
    }
}
