package Queue;

/**
 * 使用CircularArray实现Queue, 需要标记head和tail的位置，元素存储在[head, tail - 1]之间
 * 初始化时指定default capacity为10，如果queue已满，需要进行倍增扩容
 * note: 当head = tail时，可能queue为空，可能queue已满，需要使用size进行判断
 *
 * time: O(1)
 * space: O(n)
 * @param <E>
 */
public class QueueOfCircularArray<E> implements IQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;

    public QueueOfCircularArray() {
        this(10);
    }

    public QueueOfCircularArray(int capacity) {
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
        data[tail] = e;
        if ((tail = (tail + 1) % data.length) == head) {
            resize(data.length * 2);
        }

        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        E obj = data[head];
        data[head] = null;
        head = (head + 1) % data.length;

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
        for (int i = 0; i < size; i++) {
            System.out.print(data[(i + head) % data.length] + " ");
        }

        System.out.println();
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[(i + head) % data.length];
        }

        head = 0;
        tail = data.length;
        data = temp;
    }
}
