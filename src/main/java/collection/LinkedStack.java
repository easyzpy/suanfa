package collection;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 16:11
 * 链表实现一个栈
 */
public class LinkedStack<T> {
    //    private Node element;
    private int N;
    private Node first;

    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        N++;
    }

    public T pop() {
        Node oldFirst = first;
        first = oldFirst.nextNode;
        oldFirst.nextNode = null;
        N--;
        return oldFirst.item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private class Node {
        T item;
        //        Node preNode;
        Node nextNode;

        Node(T item, /*Node preNode, */Node nextNode) {
            this.item = item;
//            this.preNode = preNode;
            this.nextNode = nextNode;
        }
    }
//    private T item;
//    private LinkedStack next;

}
