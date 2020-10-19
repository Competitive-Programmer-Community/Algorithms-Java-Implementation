package Geometry.polygon;

public class PointInCircle {

    /**
     * 查找以(0, 0)为圆心, 以r为半径的圆中包含多少个整数点
     * 1 根据圆的对称性将其分为四分，只研究第一象限
     * 2 对于第一象限定一动一，确定x计算y，然后对y取整得到当前列整数坐标个数
     * 3 四个象限 + 圆心坐标
     */
    public static int countPointsInCircle(double r) {
        int ans = 0;
        for (int x = 0; x <= r; x++) {
            int y = (int)Math.sqrt(r * r - x * x); // x确定，y取整之后表示 >= 1 的整数点个数
            ans += y;
        }

        return ans * 4 + 1;
    }

    /**
     * 判断指定点cur是否在以center为圆心，r为半径的圆内
     * @param center
     * @param r
     * @param cur
     * @return
     */
    public static boolean inCircle(Point center, double r, Point cur) {
        return Math.pow(center.x - cur.x, 2) + Math.pow(center.y - cur.y, 2) <= r * r;
    }

    public static void main(String[] args) {

    }
}
