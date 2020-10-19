package BitManipulation;

import java.util.BitSet;

// 10.05

/**
 * bitSet初始化为64位，取值均为false
 * bitSet.set(i)之后对应index = i 取值为true
 * 超出范围之后类似ArrayList，使用倍增法扩容
 *
 * 适用题型：大量数据，但状态有限
 * 优点：减少内存要求，处理大数据
 * 缺点：1 数据碰撞 -> Bloom Filter
 *      2 数据丢失 -> Roaring BitMap
 */

public class BitMap {
    /**
     * 判断给定str中是否有重复元素
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * @param str
     * @return
     */
    private static boolean isUnique(String str) {
        if (str.length() > 256) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // 对于每一个字符其ASCII码val唯一
            // 1 << val 唯一标示了对应的ch
            // checker中val对应的bit位取0则ch还不存在，取1则ch已经存在不为unique
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0) { // 1 & 1 -> 有重复元素
                return false;
            }
            checker |= (1 << val);
        }

        return true;
    }

    private static void bitSet() {
        // 默认大小为64位bits
        BitSet bitSet = new BitSet();
        // 可以设置bits位数
        BitSet set = new BitSet(100); // [0, 99]

        // bitSet.size() -> 返回底层long数组的大小
        System.out.println(bitSet.size());
        // bitSet.length() -> 返回bitSet的实际大小
        System.out.println(bitSet.length());
        // 获取第0位bit的取值
        System.out.println(bitSet.get(0));

        // 将第0位bit设置为true
        bitSet.set(0);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.size());
        System.out.println(bitSet.length());

        bitSet.set(65);
        System.out.println(bitSet.size()); // [128]
        System.out.println(bitSet.length()); // [0, 65]

        bitSet.set(129);
        System.out.println(bitSet.size()); // [256]
        System.out.println(bitSet.length()); // [0, 129]
    }

    public static void main(String[] args) {
        bitSet();
        // System.out.println(isUnique("abcx"));
        // System.out.println(isUnique("abccx"));
    }
}
