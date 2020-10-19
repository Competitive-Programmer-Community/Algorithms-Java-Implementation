package HashTable.BloomFilter;

import java.util.BitSet;

/**
 * 标准型布隆过滤器：底层使用BitSet标记，相对于Hash Table节省空间，同时允许一定的Hash冲突
 * 每个key通过k个独立的HashFunction映射到k个位置，通过检测k个位置是否全为1来判断key是否存在(可能出现false positive)
 * k个Hash Function必须相互独立，seeds全为prime number防止Hash冲突，capacity和bitset相同
 * 类似HashSet只能进行元素加入和存在判断；如果想要实现add/remove操作，需要将BitsSet中每一个出现的bits进行计数
 */
public class StandardBloomFilter {
    private static final int DEFAULT_SIZE = 1 << 31;
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private static final int[] seeds = new int[]{5, 7, 11, 13, 19, 37, 61};
    private HashFunction[] functions = new HashFunction[seeds.length];

    public class HashFunction {
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        public int hash(String key) {
            int ans = 0;
            for (int i = 0; i < key.length(); i++) {
                ans = (ans * seed % capacity + key.charAt(i)) % capacity;
            }

            return ans;
        }
    }

    public StandardBloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String key) {
        for (HashFunction function : functions) {
            bits.set(function.hash(key), true);
        }
    }

    public boolean contains(String key) {
        if (key == null || key.length() == 0) {
            return false;
        }

        boolean ans = true;
        for (HashFunction function : functions) {
            ans = ans & (bits.get(function.hash(key)));
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "cspiration";
        String t = "cs";

        StandardBloomFilter filter = new StandardBloomFilter();

        System.out.println(filter.contains(s));
        filter.add(s);
        System.out.println(filter.contains(s));
        System.out.println(filter.contains(t));
    }
}

