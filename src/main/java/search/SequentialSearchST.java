package search;

/**
 * 实现一个无序链表
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public Value get(Key key) {
        //找到就返回 没找到返回null
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        //如果存在则覆盖其值 如果不存在新增一个节点（Node）
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public String toString() {
        return "SequentialSearchST{" +
                "first=" + first +
                '}';
    }
}
