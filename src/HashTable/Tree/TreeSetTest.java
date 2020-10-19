package HashTable.Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet: 基于TreeMap创建，底层使用红黑树
 * 必须实现Comparable接口，按照给定的排序算法，对所有元素排序
 * time: O(logn)
 * space: O(n)
 */

public class TreeSetTest {
    public static void test() {
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(7);

        treeSet.remove(3);
        System.out.println(treeSet.contains(3));
        System.out.println(treeSet.size());
        System.out.println(treeSet.isEmpty());

        int first = treeSet.first();
        first = treeSet.pollFirst();
        int last = treeSet.last();
        last = treeSet.pollLast();

        Integer prev = treeSet.floor(5);
        Integer next = treeSet.ceiling(5);
        Integer x = treeSet.lower(5);
        Integer y = treeSet.higher(5);

        for (int n: treeSet) {
            System.out.println(n);
        }

        Iterator it = treeSet.iterator();
        while(it.hasNext()) {
            System.out.println((int)it.next());
        }
    }


    public static void main(String[] args) {
        test();
    }
}
