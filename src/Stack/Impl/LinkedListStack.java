package Stack.Impl;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 使用LinkedList实现Stack，有两种实现方式：
 * 1 使用普通的LinkedList，在头部进行加入删除操作
 * 2 使用DoubleLinkedList，定义两个指针head和tail，在尾部进行加入删除操作
 *
 * time: O(1)
 * space: O(n)
 * @param <E>
 */
public class LinkedListStack<E> implements IStack<E> {
    private LinkedList<E> linkedlist;

    public LinkedListStack() {
        this.linkedlist = new LinkedList<>();
    }

    @Override
    public int size() {
        return linkedlist.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedlist.add(0, e);
    }

    @Override
    public E pop() {
        return linkedlist.removeFirst();
    }

    @Override
    public E peek() {
        return linkedlist.getFirst();
    }

    @Override
    public void print() {
        System.out.println("size: " + linkedlist.size());

//        for (int i = 0; i < linkedlist.size(); i++) {
//            System.out.print(linkedlist.get(i) + " ");
//        }
        Iterator it = linkedlist.iterator();
        while(it.hasNext()) {
            System.out.print((int)it.next() + " ");
        }

        System.out.println();
    }

}
