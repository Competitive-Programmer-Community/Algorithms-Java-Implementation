package Math;

// Euclidean algorithm 求GCD for a and b:
// 以O(logmin(a, b)) 的时间找到a和b的最大公约数

public class GCD {

    public static int recursionGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return recursionGCD(b, a % b);
    }

    public static int iterationGCD(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {

    }
}
