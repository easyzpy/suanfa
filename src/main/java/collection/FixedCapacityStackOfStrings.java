package collection;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 14:52
 */
public interface FixedCapacityStackOfStrings {
    void push(String item);

    String pop();

    boolean isEmpty();

    int size();
}
