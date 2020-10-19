package BitManipulation;

public class BitMove {
    private static void commonOps(int n) {
        // 查看n的二进制表示中的第i位取值  n >> i & 1
        System.out.println((n >> 3) & 1);

        // 计算n的补码, 得到 -n
        System.out.println((~n) + 1);

        // n & -n = n & ((~n) + 1) -> n的二进制表示中最后一位1表示的数字
        System.out.println(n & ((~n) + 1));
    }

    public static void main(String[] args) {
        commonOps(11);
    }
}
