package List.ArrayList;

public interface IArrayList<E> {
    /**
     * 容量大小
     * @return
     */
    int capacity();

    /**
     * 存储元素个数
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 末尾加入
     */
    void add(E element);

    /**
     * 中间加入
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 查找元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 找到元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 修改元素
     * @param index
     * @param element
     */
    void set(int index, E element);

    /**
     * 根据index删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 找到元素进行删除
     * @param element
     * @return
     */
    void removeElement(E element);

    /**
     * 打印数据和结果
     */
    void print();

    /**
     * 改变capacity大小
     */
    void resize(int capacity);

}
