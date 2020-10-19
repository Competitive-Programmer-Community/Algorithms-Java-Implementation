package Heap.HeapImpl;

import Heap.HeapImpl.IMaxHeap;

public class MaxHeap<E extends Comparable<E>> implements IMaxHeap<E> {
    private int capacity;
    private int size;
    private E[] data;

    public MaxHeap(E[] data) {
        this.capacity = data.length;
        this.size = data.length;
        this.data = data;
        heapify(data);
    }
    public MaxHeap() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    /**
     * 类似HeapSort过程，从后往前依次将非叶子节点shiftDown，直到找到合适位置
     * time: O(n)
     * space: O(1)
     * @param data
     */
    private void heapify(E[] data) {
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            shiftDownHeapify(i);
        }
    }

    /**
     * 向Heap中加入新元素，如果size == capacity，则需要进行倍增扩容
     */
    @Override
    public boolean offer(E item) {
        if (size == capacity) {
            expandCapacity();
        }
        data[size++] = item;
        shiftUp();
        return true;
    }

    private void expandCapacity() {
        capacity = capacity * 2;
        E[] temp = (E[]) new Comparable[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    /**
     * 删除并返回堆顶元素
     * 1 如果堆顶元素为空，则抛出异常
     * 2 否则返回第一个元素，将最后一个元素放到第一个位置，然后进行shiftDown调整顺序
     * @return
     */
    @Override
    public E poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        E temp = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        shiftDown();
        return temp;
    }

    /**
     * 直接返回堆顶元素，即第一个元素
     * 如果堆为空，则抛出异常
     * @return
     */
    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        return data[0];
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
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private int getParentIndex(int childIndex) {
        // index 从0开始
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private E leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private E rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    private E parent(int index) {
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * shiftUp: 通过不断和parent进行比较，将最后加入的新元素调整到指定位置
     * time: O(logn)
     * space: O(1)
     */
    private void shiftUp() {
        int index = size - 1;
        while(getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * shiftDown: 将堆顶元素删除之后，将最后一个元素放到堆顶，不断将当前元素和左右孩子的最大值比较/交换，直到到达指定位置
     * time: O(logn)
     * space: O(1)
     */
    private void shiftDown() {
        int index = 0;
        while(getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && data[getRightChildIndex(index)].compareTo(data[biggerChildIndex]) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
                index = biggerChildIndex;
            }
        }
    }

    /**
     * shiftDownHeapify: 给定一个array，从后往前进行heapify，将当前元素和左右孩子最大值进行对比，调整位置直到满足要求
     * time: O(n)
     * space: O(1)
     * @param index
     */
    private void shiftDownHeapify(int index) {
        while(getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && data[getRightChildIndex(index)].compareTo(data[biggerChildIndex]) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
                index = biggerChildIndex;
            }
        }
    }
}
