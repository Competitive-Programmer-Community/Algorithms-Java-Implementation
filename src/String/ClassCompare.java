package String;

/**
 * test String/StringBuilder/StringBuffer time cost
 * String is immutable, "+" will create a new string object
 * StringBuilder is mutable and most fast, but only used in single thread environment
 * StringBuffer is mutable, and can be used in multi-thread environment (thread safe)
 */


public class ClassCompare {
    private static final int time = 10000;

    private static void testString() {
        String ans = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ans += "cspiration";
        }
        long end = System.currentTimeMillis();
        System.out.println(ans.getClass().getName() + " 类型需要的时间: " + (end - start));
    }

    private static void testStringBuffer() {
        StringBuffer ans = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ans.append("cspiration");
        }
        long end = System.currentTimeMillis();
        System.out.println(ans.getClass().getName() + " 类型需要的时间: " + (end - start));
    }

    private static void testStringBuilder() {
        StringBuilder ans = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ans.append("cspiration");
        }
        long end = System.currentTimeMillis();
        System.out.println(ans.getClass().getName() + " 类型需要的时间: " + (end - start));
    }

    public static void main(String[] args) {
        testString();
        testStringBuffer();
        testStringBuilder();
    }
}

