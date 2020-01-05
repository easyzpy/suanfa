import org.junit.Test;
import sort.ShellSort;
import sort.heap.MyHeap;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class HeapSortTest {

//    @Test
//    public void test2() {
//        String s = "zhangpingyang";
//        System.out.println(Arrays.toString(s.value));
//    }
    @Test
    public void test1() {
        char[] chars = "SORTEXAMPLE".toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }
        //构造一个堆有序的堆
        for (int k = characters.length/2; k > 0;k--) {
            MyHeap.sink(characters, k, characters.length);
        }
        System.out.println(Arrays.toString(characters));
        /*
        arr[0] 和 arr[N-1]调换顺序
       对剩余 0 - n-2的数组进行sink操作
         */
        int N = characters.length;
        while (N > 1) {
//            MyHeap.exch(characters, 1, N);
//            MyHeap.sink(characters, 1, N-1);
//            N--;
            MyHeap.exch(characters, 1, N--);
            MyHeap.sink(characters, 1, N);
        }
        System.out.println(Arrays.toString(characters));
    }


//    @Test
//    public void test2() {
//        int length = 1_000_000;
//        Double[] arr1 = new Double[length];
//        double[] arr2 = new double[length];
//        Random random = new Random();
//        for (int i = 0; i < length; i++) {
//            double v = random.nextDouble();
//            arr1[i] = v;
//            arr2[i] = v;
//        }
//        long start = System.currentTimeMillis();
//        ShellSort.shellSort(arr1);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//
//        start = System.currentTimeMillis();
//        ShellSort.shellSort(arr2);
//        end = System.currentTimeMillis();
//    }
}
