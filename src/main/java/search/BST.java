package search;

import search.inter.BstInterface;

/**
 * 默认认为key和value 都不为null
 * @param <Key>
 * @param <Value>
 * 如果树是一个完全平衡的 查找的次数约为 ~lgN
 */
public class BST<Key extends Comparable, Value> implements BstInterface<Key, Value> {
    private Node root;

    private class Node {
        private Node left, right;
        private int N;
        private Key key;
        private Value value;

        public Node(int n, Key key, Value value) {
            N = n;
            this.key = key;
            this.value = value;
        }
    }


    @Override
    public Value get(Key key) {
        //在以x为根节点的子树中查找并返回key的值
        //如果找不到则返回null
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp > 0) {//节点的key值大于参数key值 从左边找
            return get(node.left, key);
        } else if (cmp < 0) {
            return get(node.right, key);
        }else {
            return node.value;
        }
    }


    @Override
    public void put(Key key, Value value) {
        //存在则更新 不存在则新增一个节点
        root = put(root, key, value);

    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(1, key, value);
        int cmp = node.key.compareTo(key);
        if (cmp > 0) {//如果该节点的key大于参数可以 则放在左边
            node.left = put(node.left, key, value);
        } else if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


    /**
     * 返回新增 or 更新的节点
     */
//    private Node put(Node node, Key key, Value value) {
//        if (node == null) {
//            return new Node(1, key, value);
//        }
//        int cmp = node.key.compareTo(key);//比较的值
//        if (cmp < 0) {//如果node比key小 则找右边
//            node.right = put(node.right, key, value);
//        } else if (cmp > 0) {
//            node.left = put(node.left, key, value);
//        } else {
//            node.value = value;
//        }
//        node.N = size(node.left) + size(node.right) + 1;
//        return node;
//    }


    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }



    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key floor() {
        return null;
    }

    @Override
    public Key ceiling() {
        return null;
    }

    @Override
    public Key select() {
        return null;
    }

    @Override
    public int rank() {
        return 0;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

}
