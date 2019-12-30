package sort.heap;

import java.util.Arrays;

/**
 * 实现一个二叉树堆
 */
public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int n;

    public MaxPQ(int n) {
        pq = (Key[]) new Comparable[n + 1];//由于是从1开始 故加1
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
    /**
     * 新增key 并放在最后末梢
     * @param key
     */
    public void insert(Key key) {
        pq[++n] = key;
        swim(n);
    }

    /**
     *  删除最大的并返回
     */
    public Key delMax() {
        Key max = pq[1];
        pq[1] = pq[n];
        n--;
        pq[n + 1] = null;//这个操作最开始没有看懂， 这个是java特有的。 目的是为了垃圾回收。 不知道其他语言没有垃圾回收机制的如何处理
        sink(1);
        return max;
    }

    private void sink(int i) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && less(j, j + 1)) {//下沉到两个子节点都比他更小
                j++;
            }
            if (!less(i, j)) {
                break;
            }
            exch(i, j);
            i = j;
        }
    }


    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            exch(n / 2, n);
            n = n / 2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                ", n=" + n +
                '}';
    }
    /*
    *               66, 65, 48, 51, 29, 36, 38, 8, 47
    *               66
    *               65    48
    *           51  29    36 38
    *          8 47
    *
    *
    *
    * */
}
