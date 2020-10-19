package Math;

import java.util.ArrayList;
import java.util.List;

public class Primes {

    /**
     * 给定一个整数n，判断其是否为一个素数
     * 假设n / x == y, 则x和y都为n的divisor，且两个数中至少有一个 <= sqrt(n)
     * time: O(sqrt(n))
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 在给定区间[start, end]之间找到所有素数/素数个数 - 埃拉托斯特尼筛法(Sieve of Eratosthenes)
     * 如果i为素数，则标记[i * i + k * i]为合数 (k >= 0)
     * time: O(nloglogn)
     * space: O(n)
     * @param start
     * @param end
     * @return
     */
    public static int SieveOfEratosthenes(int start, int end) {
        int count = 0;
        boolean[] visited = new boolean[end - start + 1];
        for (int i = start; i <= end; i++) {
            if (i < 2) {
                continue;
            }
            if (visited[i - start]) {
                continue;
            }

            count++;
            for (int j = i * i; j <= end; j += i) {
                visited[j - start] = true;
            }

        }

        return count;
    }

    // 给定一个整数n，返回其对应的prime factors，使其乘积为n
    // 所有的prime factors必定在[2, sqrt(n)]之间
    public static List<Integer> factorization(int n) {
        List<Integer> ans = new ArrayList<>();
        while(n % 2 == 0) {
            ans.add(2);
            n /= 2;
        }

        for (int d = 3; d * d <= n; d += 2) { // skip all the even numbers except 2
            if (!isPrime(d)) {
                continue;
            }

            while(n % d == 0) {
                ans.add(d);
                n /= d;
            }
        }

        if (n >= 2) {
            ans.add(n);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
