package Stack.Impl;

import java.util.EmptyStackException;

/**
 * 使用Array实现Stack，需要在数组尾部进行加入删除操作
 * time: O(1)
 * space: O(n)
 * @param <E>
 */
public class ArrayStack<E> implements IStack<E> {
    private E[] data;
    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
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
    public void push(E e) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = e;

    }

    @Override
    public E pop() {
        E obj = peek();
        size--;
        data[size] = null;
        return obj;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[size - 1];
    }

    @Override
    public void print() {
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }
}

