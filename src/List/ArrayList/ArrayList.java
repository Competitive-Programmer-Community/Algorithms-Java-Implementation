package List.ArrayList;

public class ArrayList<E> implements IArrayList<E> {

    private E[] data;
    private int size;

    // default capacity = 10
    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * time: O(1)
     * @return
     */
    @Override
    public int capacity() {
        return data.length;
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
     * time: O(1)
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * time: O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        // index [0, size]
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于容量）");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * time: O(n)
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * time: O(1)
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        // index [0, size - 1]
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于等于容量）");
        }
        return data[index];
    }

    /**
     * time: O(1)
     * @param index
     * @param element
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误（小于0或者大于等于容量）");
        }
        data[index] = element;
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
        E ans = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // 当前存储元素个数 * 4 <= capacity && capacity / 2 != 0, 则进行resize将capacity减半
        if (size * 4 <= data.length && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ans;
    }

    /**
     * time: O(n)
     * @param element
     */
    @Override
    public void removeElement(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index  = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("元素不存在");
        }

        remove(index);
    }

    /**
     * time: O(n)
     * @param
     */
    @Override
    public void print() {
        System.out.println("size: " + size);
        System.out.println("capacity: " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**
     * time: O(n)
     * @param capacity
     */
    @Override
    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

}

