package Stack;


/**
 * 递归和迭代的相互转换
 */

public class Stack2Iteration {
    /**
     * 尾递归
     */
    public static int sum = 0;
    public static void sumOfN1(int n) {
        if (n == 0) {
            return;
        }

        sum += n;
        sumOfN1(n - 1);
    }
    /**
     * 非尾递归
     */
    public static int sumOfN2(int n) {
        if (n == 0) {
            return n;
        }

        return n + sumOfN2(n - 1);
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public static int iteration(int n) {
        int sum = 0;
        while(n >= 0) {
            sum += n;
            n--;
        }

        return sum;
    }

    public static void main(String[] args) {
        sumOfN1(10);
        System.out.println(sum);
        System.out.println(sumOfN2(10));
        System.out.println(iteration(10));
    }
}

