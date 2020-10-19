package Stack;

/**
 * call stack： 递归调用栈
 * 尾递归 VS 非尾递归
 */
public class StackRecursion {
    public static void test() {
        test1();
    }

    public static void test1() {
        System.out.println("这是第一个调用");
        test2();
        System.out.println("第一个调用结束");
    }

    public static void test2() {
        System.out.println("这是第二个调用");
        test3();
        System.out.println("第二个调用结束");
    }

    public static void test3() {
        System.out.println("这是第三个调用");
        test4();
        System.out.println("第三个调用结束");
    }

    public static void test4() {
        System.out.println("这是第四个调用");
        System.out.println("第四个调用结束");
    }

    /**
     * 尾递归
     * @param n
     * @return
     */
    public static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return f1(n - 1);
    }

    /**
     * 非尾递归
     * @param n
     * @return
     */
    public static int f2(int n) {
        if (n == 1) {
            return 1;
        }

        return 1 + f2(n - 1);
    }

    public static void main(String[] args) {
        test();
    }
}

