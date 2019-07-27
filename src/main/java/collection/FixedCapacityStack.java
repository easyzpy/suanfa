package collection;

import java.util.Iterator;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 15:11
 * 栈
 */
public class FixedCapacityStack<T> implements Iterable<T>{
    private T[] a;
    private int N;

    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (isFull()) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public T pop() {
        T t = a[--N];
        if (N > 0 && N == a.length / 4) {
            resize(N/2);
        }
        return t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return N == a.length;
    }

    /**
     * 将数组赋值到更大的max数组中去
     * @param max
     */
    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalized");
    }

}
