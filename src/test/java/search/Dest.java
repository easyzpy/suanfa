package search;

import edu.princeton.cs.algs4.BinarySearchST;
import org.junit.Test;
import util.RequestUtil;

import java.io.FileOutputStream;
import java.io.InputStream;

public class Dest {
    @Test
    public void test8() {
        BST<Integer, Object> bst = new BST<>();
        long start = System.currentTimeMillis();
        for (int i = 50000; i > 0; i--) {
            bst.put(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        search.BinarySearchST<Integer, Object> st = new search.BinarySearchST<>();
        start = System.currentTimeMillis();
        for (int i = 20000; i > 0; i--) {
            st.put(i, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);



//        System.out.println(bst.get(9_9999));

    }
    @Test
    public void test7() {
        BST<Integer, Object> bst = new BST<>();
        bst.put(5, 5);
        bst.put(3, 3);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(9, 9);
        bst.put(10, 10);
        bst.put(2, 12);
        bst.put(1, 1);

        System.out.println(bst.get(1));
        System.out.println(bst.get(2));
        System.out.println(bst.get(3));
        System.out.println(bst.get(4));
        System.out.println(bst.get(5));
        System.out.println(bst.get(6));
        System.out.println(bst.get(7));
        System.out.println(bst.get(8));
        System.out.println(bst.get(9));
        System.out.println(bst.get(10));
    }
    @Test
    public void test6() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 22};
        System.out.println(rank(arr, 5));
        System.out.println(rank(arr, 7));
        System.out.println(rank(arr, 8));
        System.out.println(rank(arr, 9));
        System.out.println(rank(arr, 22));
        System.out.println(rank(arr, 522));

    }

    public static int rank(int[] arr, int key) {
        return rank(arr, 0, arr.length - 1, key);
    }
    /**
     * 递归的二分查找
     */
    public static int rank(int[] arr, int lo, int hi, int key) {
        if (lo > hi) return lo;
        int mid = (lo + hi) / 2;
        if (arr[mid] > key)
            hi = mid - 1;
        else if (arr[mid] < key)
            lo = mid + 1;
        else return mid;
        return rank(arr, lo, hi, key);
    }
    @Test
    public void test5() {
        BinarySearchST<Integer, Object> st = new BinarySearchST<>();
        int rank = st.rank(1);
        System.out.println(rank);

    }
    @Test
    public void test4() {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11};
//        int i = binarySearch(2, arr);
//        System.out.println(i);
//        System.out.println(binarySearch(4, arr));
//        System.out.println(binarySearch(6, arr));
//        System.out.println(binarySearch(8, arr));
        System.out.println(binarySearch(-1, arr));
        System.out.println(binarySearch(100, arr));
//        System.out.println(binarySearch(0, arr));

    }
    /**
     * 如果找到则返回index 没有找到返回最近的小于i的index
     * @param key
     * @param arr
     * @return
     */
    //0,1,2,3,4,5,6
    public static int binarySearch(int key, int[] arr) {
        //lo第一个元素 hi最后一个元素 的角标
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            if (lo == hi) {
                System.out.println();
            }
            int mid = (lo + hi) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    @Test
    public void test3() {
        assert 1 < 2;
        assert 1 < 0;
    }
    /**
     * 测试无序链表
     */
    @Test
    public void test1() {
        SequentialSearchST<Character, Integer> st = new SequentialSearchST<>();
        char[] chars = "SEARCHEXAMPLE".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            st.put(chars[i], i + 1);
        }
        System.out.println(st);
        Integer e = st.get('E');
        System.out.println(e
        );
    }

    @Test
    public void test2() throws Exception {
        InputStream inputStream = RequestUtil.requestGetObtainInputStream("https://www.baidu.com", "");
        FileOutputStream fos = new FileOutputStream("d:\\demo\\gbk.txt");
        //创建转换流对象，构造方法，包装字节输入流
//        InputStreamReader isr = new InputStreamReader(fis, "GBK");
//        new OutputStreamWriter()
//        char[] ch = new char[2014];
//        int len = isr.read(ch);
//        System.out.println(new String(ch, 0, len));
//
//        isr.close();
    }

}
