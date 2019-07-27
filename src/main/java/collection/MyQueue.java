package collection;

import java.util.NoSuchElementException;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 17:22
 * 使用双向链表实现一个队列
 */
public class MyQueue<T> {
    private int N;
    private Node first;
    private Node last;


    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node(item, oldLast, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        } else {
            Node oldLast = last;
            oldLast.next = null;
            Node oldLastPre = oldLast.prev;
            oldLastPre.next = null;
            return oldLast.element;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private class Node{
        T element;
        Node prev;
        Node next;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
