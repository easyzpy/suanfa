package sort.heap;

import edu.princeton.cs.algs4.Heap;
import javafx.scene.chart.Chart;
import main.Javac;
import sun.security.util.Length;

import java.util.Arrays;

public class HeapSort {
    /**
     * S
     * O       R
     * T    E   X  A
     * M P  L  E
     * <p>
     * 构造一个大顶堆， 然后对堆进行排序
     */
    public static void main(String[] args) {
        char[] chars = "SORTEXAMPLE".toCharArray();
        heapSort(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void heapSort(char[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
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
        return arr[i - 1] < arr[j - 1];
    }

    public static void exch(char[] arr, int i, int j) {
        char c = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = c;
    }
}
