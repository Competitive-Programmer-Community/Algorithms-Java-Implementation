package Math;

// Least Common Multiple(LCM) for a and b:
// 求a和b的最小公倍数 = a * b / a和b的最大公约数

public class LCM {
    public static int LCM(int a, int b) {
        GCD gcd = new GCD();
        return a /  gcd.iterationGCD(a, b) * b; // avoid overflow, a * b / gcd(a, b)
    }
}
