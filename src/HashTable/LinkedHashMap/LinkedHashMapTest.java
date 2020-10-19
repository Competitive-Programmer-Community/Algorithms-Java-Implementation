package HashTable.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于HashMap + DoublelyLinkedList实现，保证元素插入和访问的顺序 和 访问顺序一致 -> LRU
 * 继承HashMap类，拥有相同的方法和参数
 * time: O(1)
 * space: O(n)
 */

public class LinkedHashMapTest {
    // for HashMap, 插入顺序和最后打印顺序不同：打印顺序按照array从上到下挂载的LinkedList从前往后打印
    // for LinkedHashMap, 其array上面挂载的LinkedList中的每一个ListNode, 都有：
    // 一个node.link指针指向下一个被映射在同一位置的node
    // 一个node.next指针指向下一个加入的元素
    // 一个node.prev指针指向上一个加入的元素
    // 通过next和prev指针得到插入顺序 -> LRU
    public static void main(String[] args) {
        // access order为false时按照插入顺序
        //             为true时按照访问顺序
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "1");
        linkedHashMap.put("3", "1");
        linkedHashMap.put("4", "1");
        print(linkedHashMap);
        // put or get会将当前key对应的entry重新插入
        linkedHashMap.get("1");
        print(linkedHashMap);
    }

    private static void print(LinkedHashMap<String, String> linkedHashMap) {
        for (Map.Entry<String, String> entry: linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + "\t");
        }
        System.out.println();
    }
}
