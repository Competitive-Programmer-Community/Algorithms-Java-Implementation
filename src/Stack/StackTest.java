package Stack;

/**
 * 最大递归层数测试
 * 一般level取值10000 - 20000之间
 */

public class StackTest {
    public static int level = 1;

    public static void level() {
        level++;
        level();
    }

    // level = 10,000 产生溢出
    public static void main(String[] args) {
        try {
            level();
        } catch (StackOverflowError e) {
            System.out.println(level);
        }
    }


}

