package Queue;

public interface IQueue<E> {
    /**
     * 实际占用大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 加入数据，入queue
     * @param e
     */
    boolean offer(E e);

    /**
     * 出queue，删除元素
     * @return
     */

    E poll();
    /**
     * 查看队首元素
     */
    E peek();

    /**
     * 打印数据和结果
     */
    void print();
}

