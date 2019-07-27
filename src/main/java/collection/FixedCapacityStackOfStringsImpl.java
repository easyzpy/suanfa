package collection;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/7/27 14:54
 */
public class FixedCapacityStackOfStringsImpl implements FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStringsImpl(int cap) {
        a = new String[cap];
    }



    @Override
    public void push(String item) {
        a[N++] = item;
    }

    @Override
    public String pop() {
        return a[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}
