package sort;


import java.util.Arrays;

import static util.Utils.exch;
import static util.Utils.less;

public class ShellSort {

    public static void shellSort(Comparable[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(arr[j], arr[j - h])) {
                        exch(arr, j, j - h);
                    }
                }
            }
            h = h / 3;
//            System.out.println(h);
        }
    }



    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3};
        exch(a, 1, 2);
        exch(a, 0, 2);
        System.out.println(Arrays.toString(a));
        char[] chars = "SHEELSORTEXAMPLE".toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }
        shellSort(characters);
        System.out.println(Arrays.toString(characters));
    }
}
