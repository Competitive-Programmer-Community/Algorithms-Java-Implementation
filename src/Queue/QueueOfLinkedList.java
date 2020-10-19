package Queue;

/**
 * 使用LinkedList实现Queue时，在尾部加入新元素，头部删除旧元素
 * 需要维护两端的指针head和tail; 本身即为动态数据结构，不需要resize
 * time: O(1)
 * space: O(n)
 * @param <E>
 */

public class QueueOfLinkedList<E> implements IQueue<E> {

    ListNode head, tail;
    private int size;

    public QueueOfLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(E e) {
        if (tail == null) {
            tail = new ListNode(e);
            head = tail;
        } else {
            tail.next = new ListNode(e);
            tail = tail.next;
        }

        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        ListNode ans = head;
        head = head.next;
        ans.next = null;
        if (head == null) {
            tail = null;
        }

        size--;
        return (E) ans.val;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        return (E) head.val;
    }

    @Override
    public void print() {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " -> " );
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {
        public E val;
        public ListNode next;
        public ListNode(E val) {
            this.val = val;
        }
    }
}

