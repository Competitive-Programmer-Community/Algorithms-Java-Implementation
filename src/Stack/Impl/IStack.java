package Stack.Impl;

public interface IStack<E> {
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
     * 加入数据，入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈，删除元素
     * @return
     */

    E pop();
    /**
     * 查看栈顶元素
     */
    E peek();

    /**
     * 打印数据和结果
     */
    void print();
}

