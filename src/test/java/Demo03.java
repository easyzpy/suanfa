import collection.FixedCapacityStack;
import collection.FixedCapacityStackOfStringsImpl;
import collection.LinkedStack;
import collection.MyQueue;
import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import java.util.LinkedList;


/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 15:03
 */
public class Demo03 {
    @Test
    public void test7() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.get(4);
    }
    @Test
    public void test6() {
        MyQueue<String> queue = new MyQueue<>();
        String[] arr = {"1", "2", "3", "4"};
        for (int i = 0; i < arr.length; i++) {
            queue.enqueue(arr[i]);
        }
        System.out.println(queue);
    }
    @Test
    public void test5() {
        Queue<String> queue = new Queue<>();
        String[] arr = {"1", "2", "3", "4"};
        for (int i = 0; i < arr.length; i++) {
            queue.enqueue(arr[i]);
        }
        System.out.println(queue);

    }
    @Test
    public void test4() {
        LinkedStack<String> st = new LinkedStack<>();
        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }

    @Test
    public void test3() {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
    @Test
    public void test2() {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        stack.push("asdf");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        FixedCapacityStack<Double> stackdouble = new FixedCapacityStack<>(3);
        stackdouble.push(.011123123);
        System.out.println(stackdouble.size());
        System.out.println(stackdouble.isEmpty());

        System.out.println(stackdouble.pop());
        System.out.println(stackdouble.size());
        System.out.println(stackdouble.isEmpty());
    }
    @Test
    public void test1() {
        FixedCapacityStackOfStringsImpl stack = new FixedCapacityStackOfStringsImpl(3);
        stack.push("asdf");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

    }
}
