package Queue;

public class QueueOfArray<E> implements IQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;

    public QueueOfArray() {
        this(10);
    }

    public QueueOfArray(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
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
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = e;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        E obj = data[head++];
        if (head == tail) {
            head = 0;
            tail = 0;
        }
        size--;
        return obj;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        return data[head];
    }

    @Override
    public void print() {
        System.out.println("size: " + size);
        System.out.println("capacity: " + data.length);
        for (int i = head; i < tail; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        int i = 0, j = 0;
        for (i = head, j = 0; i < tail; i++) {
            temp[j++] = data[i];
        }
        data = temp;
        head = 0;
        tail = j;
    }
}

