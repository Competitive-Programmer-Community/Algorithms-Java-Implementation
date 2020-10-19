package HashTable.BloomFilter;

/**
 * 计数型布隆过滤器：底层使用counts array，对每一位bits进行计数
 * 每个key通过k个独立的HashFunction映射到k个位置，通过获取k个位置的count最小值确定当前key出现的次数(出现次数可能偏大)
 * k个Hash Function必须相互独立，seeds全为较小的prime number防止计算复杂度高和Hash冲突，capacity和counts array相同
 * 类似HashMap可以进行元素加入，删除，存在判断以及获取出现次数；但是需要保证要删除的元素出现过以防止误删
 */
public class CountingBloomFilter {
    private static final int DEFAULT_SIZE = 1000000;
    private int[] counts = new int[DEFAULT_SIZE];
    private static final int[] seeds = new int[]{5, 7, 11, 13, 19, 37, 61};
    private HashFunction[] functions = new HashFunction[seeds.length];

    private class HashFunction {
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

    public CountingBloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String key) {
        for (HashFunction function: functions) {
            counts[function.hash(key)]++;
        }
    }

    public int get(String key) {
        int ans = Integer.MAX_VALUE;
        for (HashFunction function: functions) {
            ans = Math.min(ans, counts[function.hash(key)]);
        }

        return ans == Integer.MAX_VALUE ? 0: ans;
    }

    public boolean contains(String key) {
        return get(key) != 0;
    }

    public boolean remove(String key) {
        if (get(key) == 0) {
            return false;
        }

        for (HashFunction function: functions) {
            counts[function.hash(key)]--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "cspiration";
        CountingBloomFilter filter = new CountingBloomFilter();

        filter.add(s);
        System.out.println(filter.get(s));
        System.out.println(filter.contains(s));
        System.out.println(filter.remove(s));

        System.out.println(filter.get(s));
        System.out.println(filter.contains(s));
        System.out.println(filter.remove(s));
    }
}
