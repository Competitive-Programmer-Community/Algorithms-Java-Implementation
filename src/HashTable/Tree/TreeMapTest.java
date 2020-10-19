package HashTable.Tree;


import java.util.*;

/**
 * TreeMap: 底层由红黑树(平衡二叉搜索树)实现
 * 其中key必须实现Comparable接口，按照给定的排序算法，对所有key-value pairs排序
 * time: O(logn)
 * space: O(n)
 */

public class TreeMapTest {
    public static void test() {
        TreeMap<String, Integer> treeMap = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.equals(o2) ? 0 : o1.compareTo(o2);
            }
        });

        treeMap.put("Bob", 0);
        treeMap.put("Lily", 1);
        treeMap.put("Alex", 2);
        treeMap.put("Frank", 3);

        treeMap.remove("Bob");
        System.out.println(treeMap.containsKey("Bob"));
        System.out.println(treeMap.containsValue(0));
        System.out.println(treeMap.size());

        String firstKey = treeMap.firstKey();
        String lastKey = treeMap.lastKey();

        Set<String> keySet = treeMap.keySet();
        Collection values = treeMap.values();

        String prevKey = treeMap.floorKey("Alex");
        Map.Entry<String, Integer> prevEntry = treeMap.floorEntry("Alex");
        Map.Entry<String, Integer> x = treeMap.lowerEntry("Alex");
        System.out.println(prevEntry.getKey());
        System.out.println(prevEntry.getValue());

        String nextKey = treeMap.ceilingKey("Alex");
        Map.Entry<String, Integer> nextEntry = treeMap.ceilingEntry("Alex");
        Map.Entry<String, Integer> y = treeMap.higherEntry("Alex");
        System.out.println(nextEntry.getKey());
        System.out.println(nextEntry.getValue());

        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Map.Entry<String, Integer> first = treeMap.firstEntry();
        first = treeMap.pollFirstEntry();
        Map.Entry<String, Integer> last = treeMap.lastEntry();
        last = treeMap.pollLastEntry();

        Iterator it = treeMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
