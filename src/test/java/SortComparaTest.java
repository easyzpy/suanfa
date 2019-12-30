import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import sort.InsertSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.heap.MaxPQ;

import java.util.Arrays;
import java.util.Random;


public class SortComparaTest {
    @Test
    public void test3() {
        In[] streams = new In[3];
        streams[0] = new In("m1.txt");
        streams[1] = new In("m2.txt");
        streams[2] = new In("m3.txt");
        merge(streams);

    }
    private static void merge(In[] streams) {
        int n = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(n);
        for (int i = 0; i < n; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        // Extract and print min and read next from its stream.
        while (!pq.isEmpty()) {
            StdOut.print(pq.minKey() + " ");
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
        StdOut.println();
    }
//    public void merge(In[] streams) {
//        int length = streams.length;
//        IndexMinPQ<String> pq = new IndexMinPQ<>(length);
//        for (int i = 0; i < streams.length; i++) {
//            pq.insert(i, streams[i] +"");
//        }
//        while (!pq.isEmpty()) {
////            StdOut.println(pq.min());
//            int i = pq.delMin();
//            pq.insert(i, streams[i] + "");
//
//        }
//    }
    @Test
    public void test2() {
        Random random = new Random();
        MaxPQ<Integer> pq = new MaxPQ<Integer>(10);
        int[] arr = {8, 36, 47, 48, 29, 38, 51, 66, 65, 96};
        for (int j = 0; j < 10; j++) {
//            int i = random.nextInt(100);
            int i = arr[j];
            System.out.println(i);
            pq.insert(i);

        }
        System.out.println(pq);
        for (int i : arr) {
            Integer integer = pq.delMax();
            System.out.println(integer + "  " + pq.toString());
        }
    }
    @Test
    public void test1() {
        int size = 100000;
        int a = size;
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {

            integers[i] = a--;
        }
        System.out.println(Arrays.toString(integers
        ));
        long start = System.currentTimeMillis();
        InsertSort.insertSort(integers);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        SelectSort.selectSort(integers);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        ShellSort.shellSort(integers);
        end = System.currentTimeMillis();
        System.out.println(end - start);
//        Arrays.sort();
    }
}
