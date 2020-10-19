package List.LinkedList;

/**
 * 增删改查：O(n)
 * @param <E>
 */
public interface ILinkedList<E> {

    /**
     * 占用大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 按index插入
     * @param val
     * @param index
     */
    void add(int index, E val);

    /**
     * 正常尾部插入
     * @param val
     */
    boolean add(E val);

    /**
     * 头部插入
     * @param val
     */
    void addFirst(E val);

    /**
     * 尾部插入
     * @param val
     */
    void addLast(E val);

    /**
     * 头部删除
     * @return
     */
    E removeFirst();

    /**
     * 尾部删除
     * @return
     */
    E removeLast();

    /**
     * 删除指定元素
     * @param val
     * @return
     */
    boolean remove(E val);

    /**
     * 按index删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * get方法
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 得到第一个元素
     * @return
     */
    E getFirst();

    /**
     * 得到最后一个元素
     * @return
     */
    E getLast();

    /**
     * set方法
     * @param index
     * @param val
     */
    void set(int index, E val);

    /**
     * 查看是否包含val
     * @param val
     * @return
     */
    boolean contains(E val);

    /**
     * 打印链表
     */
    void print();
}

