package search;

import search.inter.SearchSt;

/**
 * 基于有序数组的二分查找
 * 自动扩容 很牛逼
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements SearchSt<Key, Value> {
    /**
     * length
     */
    private int n;
    private Key[] keys;
    private Value[] values;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    @Override
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("key is not be null");
        int i = rank(key);
        if (i == n) {
            return null;
        } else {
            return keys[i];
        }

    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is not be null");
        int i = rank(key);
        if (i == n || !key.equals(keys[i])) {
            return;
        }
        for (int j = i; j < n - 1 ; j++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[n-1] = null;
        values[n-1] = null;
        n--;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is not be null");

        int i = rank(key);
        if (i <n && key.equals(keys[i])) return values[i];
        return null;

    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key is not be null");
        if (value == null) {
            delete(key);
            return;
        }
        // key is already in table
        int i = rank(key);
        if (i < n && key.equals(keys[i])) {
            values[i] = value;
            return;
        }
        //size is full
        if (keys.length == n) {
            resize(2 * n);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    @Override
    public int rank(Key key) {
        return rank(0, n - 1, key);
    }
    /**
     * 递归的二分查找
     */
    public int rank(int lo, int hi, Key key) {
        if (lo > hi) return lo;
        int mid = (lo + hi) / 2;
        if (greater(keys[mid], key))
            hi = mid - 1;
        else if (less(keys[mid], key))
            lo = mid + 1;
        else return mid;
        return rank(lo, hi, key);
    }
//    @Override
//    public int rank(Key key) {
//        if (key == null) throw new IllegalArgumentException("rank key is not be null");
//        //二分查找
//        int lo = 0;
//        int hi = n - 1;
//        while (lo <= hi) {
//            int mid = (hi + lo) / 2;
//            if (hi == lo) {
//                System.out.println();
//            }
//            if (less(keys[mid], key))
//
//                lo = mid + 1;
//            else if (greater(keys[mid], key))
//                hi = mid - 1;
//            else
//                return mid;
//        }
//        return lo;
//    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }
    private boolean greater(Key k1, Key k2) {
        return k1.compareTo(k2) > 0;
    }

    /**
     * 扩容方法
     */
    private void resize(int capacity) {
        assert n < capacity;
        Key[] keys = (Key[]) new Comparable[capacity];
        Value[] values = (Value[]) new Comparable[capacity];
        for (int i = 0; i < n; i++) {
            keys[i] = this.keys[i];
            values[i] = this.values[i];
        }
        this.keys = keys;
        this.values = values;
    }


    public static void main(String[] args) {
//        BinarySearchST<Integer, Object> st = new BinarySearchST<>();
//        System.out.println(st.less(1, 2));
//        System.out.println(st.less(100, 2));
        //test rank
//        BinarySearchST<Integer, Object> st = new BinarySearchST<>();
//        st.keys = new Integer[]{1, 3, 5, 7, 9};
//        st.n = 5;
//        System.out.println(st.rank(7));
//        System.out.println(st.rank(1));
//        System.out.println(st.rank(3));
//        System.out.println(st.rank(6));
//        System.out.println(st.rank(10));
        //test ceiling algs4
//        edu.princeton.cs.algs4.BinarySearchST<Integer, Object> st2 = new edu.princeton.cs.algs4.BinarySearchST<>();
//        st2.put(1, 1);
//        st2.put(2, 1);
//        st2.put(3, 1);
//        st2.put(4, 1);
//        Integer ceiling = st2.ceiling(2);
//        System.out.println(ceiling);
        //test resize
//        Comparable integer = new Integer(1);
//        BinarySearchST<Integer, Object> st = new BinarySearchST<>(10);
//        st.n = 10;
//        for (int i = 0; i < 10; i++) {
//        }
//        st.put(1,2);
//        st.resize(20);
//        System.out.println();
        //test get
//        BinarySearchST<Integer, Object> st = new BinarySearchST<>();
//        st.put(1, 1);
//        st.n = 1;
//        Object o = st.get(0);
//        System.out.println(o);
//        System.out.println(st.get(1));
        //test put
        BinarySearchST<Integer, Object> st = new BinarySearchST<>();
        st.put(3, "3");
//        st.put(3, "8");
//        st.put(2, "2");
//        st.put(1, "1");
//        st.put(5, "5");99609 100000
//        st.put(3, null);
        for (int i = 100000; i > 0; i--) {
            st.put(i, i);
        }
        long start = System.currentTimeMillis();
        System.out.println(st.get(9_9999));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(st.get(1));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
