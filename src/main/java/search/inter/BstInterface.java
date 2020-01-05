package search.inter;

/**
 * 二叉查找树
 * 每个节点都含有一个左连接、一个右连接、一个节点计数器、一个键、一个值
 * 节点计数器N为以该节点为根的子树的节点总数，所以有以下：
 * size(x) = size(x.left) + size(x.right) + 1；  1为本身
 *
 *
 */
public interface BstInterface<Key, Value> {

    int size();

    /**
     * 取
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 存
     */
    void put(Key key, Value value);

    /**
     * 最大的key
     * @return
     */
    Key max();

    /**
     * 最小的key
     * @return
     */
    Key min();

    /**
     * 以下不解释。
     * @return
     */
    Key floor();

    Key ceiling();

    Key select();

    int rank();

    void delete();

    void deleteMin();

    void deleteMax();

    Iterable<Key> keys();





}
