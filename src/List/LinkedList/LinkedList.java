package List.LinkedList;

public class LinkedList<E> implements ILinkedList<E> {

    private class ListNode<E> {
        public E val;
        public ListNode next;
        public ListNode(E val) {
            this.val = val;
        }

    }

    private int size;

    private ListNode dummy;

    public LinkedList() {
        dummy = new ListNode(null);
        size = 0;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * time: O(n)
     * @param index
     * @param val
     */
    @Override
    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于容量）");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    /**
     * time: O(n)
     * @param val
     * @return
     */
    @Override
    public boolean add(E val) {
        addLast(val);
        return true;
    }

    /**
     * time: O(1)
     * @param val
     */
    @Override
    public void addFirst(E val) {
        add(0, val);
    }

    /**
     * time: O(n)
     * @param val
     */
    @Override
    public void addLast(E val) {
        add(size, val);
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * time: O(n)
     * @return
     */
    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * time: O(n)
     * @param val
     * @return
     */
    @Override
    public boolean remove(E val) {
        ListNode prev = dummy;
        while(prev.next != null) {
            if (prev.next.val.equals(val)) {
                prev.next = prev.next.next;
                size--;
                return true;
            }

            prev = prev.next;
        }

        return false;
    }

    /**
     * time: O(n)
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于等于容量）");
        }

        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return (E)delNode.val;
    }

    /**
     * time: O(n)
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于等于容量）");
        }

        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return (E)cur.val;
    }

    /**
     * time: O(n)
     * @param index
     * @param val
     */
    @Override
    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于等于容量）");
        }

        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.val = val;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * time: O(n)
     * @return
     */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    /**
     * time: O(n)
     * @param val
     * @return
     */
    @Override
    public boolean contains(E val) {
        ListNode cur = dummy.next;
        while(cur != null) {
            if (cur.val.equals(val)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    /**
     * O(n)
     */
    @Override
    public void print() {
        ListNode cur = dummy.next;
        while(cur != null) {
            System.out.print(cur.val + " -> " );
            cur = cur.next;
        }
        System.out.println("null");
    }
}

