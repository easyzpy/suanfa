package search.inter;


public interface SearchSt<Key, Value> {

    int INIT_CAPACITY = 2;

    int n = 0;
    /**
     * 返回keys数组中大于等于key的最小的key
     * @param key
     * @return
     */
    Key ceiling(Key key);

    void delete(Key key);

    Value get(Key key);

    void put(Key key, Value value);

    /**
     * 二分查找结论
     * 二分查找结束后 如果key未在数组中 则while结束后 lo总是大约hi 且key值位于二者之间
     * 如果key值小于arr[0] 则返回0
     * 如果key值大于arr[1] 则返回length 1+ 1
     *
     * @param key
     * @return
     */
    public int rank(Key key);

    Key select(int k);

    boolean contains(Key key);

    boolean isEmpty();

    int size();


}