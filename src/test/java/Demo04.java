import org.junit.Test;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

public class Demo04 {
    @Test
    public void test2() {
        int[] arr = In.readInts("1Mints.txt");
        Arrays.sort(arr);

//        int ctn = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                int index = BinarySearch.indexOf(arr, -arr[i] - arr[j]);
//                if (index > j) {
//                    ctn++;
//                }
//            }
//        }
//        System.out.println(ctn);
    }
    @Test
    public void test1() {
        int[] arr = In.readInts("16Kints.txt");
        Arrays.sort(arr);
        int ctn = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = BinarySearch.indexOf(arr, -arr[i]);
            if (index > i) {
                System.out.println(index + " " + i);
                ctn++;
            }

        }
        System.out.println(ctn);

    }
}
