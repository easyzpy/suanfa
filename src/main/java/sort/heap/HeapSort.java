package sort.heap;

import main.Javac;
import sun.security.util.Length;

import java.util.Arrays;

public class HeapSort {
    /**
     *          S
     *        O       R
     *      T    E   X  A
     *     M P  L  E
     *
     *     构造一个大顶堆， 然后对堆进行排序
      */
    public static void main(String[] args) {
        char[] chars = "1SORTEXAMPLE".toCharArray();
        heapSort(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void heapSort(char[] arr) {
        int N = arr.length - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(arr, i, N);
        }
        while (N > 1) {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    /**
     * 构造一个大顶堆
     */
    public static void sink(char[] arr, int k, int length) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            exch(arr, k, j);
            k = j;
        }
    }

    public static boolean less(char[] arr, int i, int j) {
        try {
            return arr[i] < arr[j];
        } catch (Exception e) {
            System.out.println(i + " " + j);
            throw e;
        }
    }

    public static void exch(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
