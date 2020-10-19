package Math;

// 二元指数(快速幂变换)
// 以O(logn) 的时间实现 a^b
// a^b = b % 2 ? a^(b / 2) * a^(b / 2) * a, a^(b / 2) * a(b / 2);

public class BinaryExp {
    // 求a^b
    public static int recursionExp(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int temp = recursionExp(a, b / 2);
        return b % 2 == 0 ? temp * temp : temp * temp * a;
    }

    public static int iterationExp(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }

            a *= a;
            b >>= 1;
        }

        return ans;
    }

    // Compute a^b mod n. b maybe a very large number
    public static int mod(int a, int b, int n) {
        a %= n;
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % n;
            }

            a = a * a % n;
            b >>= 1;
        }

        return ans;
    }

    // Compute (a * b) mod n. a * b may be a very large number
    public static int mod2(int a, int b, int n) {
        return (a % n) * (b % n) % n;
    }

    public static void main(String[] args) {

    }
}
