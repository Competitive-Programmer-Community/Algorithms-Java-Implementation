package Heap.HeapImpl;

public interface IMaxHeap<E> {
    /**
     * 加入元素
     * @param item
     */
    boolean offer(E item);

    /**
     * 删除元素
     * @return
     */
    E poll();

    /**
     * 查看堆顶元素
     * @return
     */
    E peek();

    /**
     * 返回堆中元素个数
     * @return
     */
    int size();

    /**
     * 判断堆是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 打印当前堆中元素
     */
    void print();
}
