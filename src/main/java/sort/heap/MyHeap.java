package sort.heap;

/**
 * 实现一个大顶堆
 */
public class MyHeap {

    private MyHeap() {
    }


    public static void sink(Comparable[] arr, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            exch(arr, k, j);
            k = j;
        }
    }



    public static boolean less(Comparable[] arr, int i, int j) {
        return arr[i-1].compareTo(arr[j-1]) < 0;
    }

    public static void exch(Comparable[] arr, int i, int j) {
        Comparable comparable = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = comparable;
    }
}
