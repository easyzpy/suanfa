package sort;

import com.sun.corba.se.spi.legacy.connection.LegacyServerSocketEndPointInfo;
import util.Utils;

import javax.swing.*;
import java.util.Arrays;

public class InsertSort {
    /**
     * 这种排序类似抓扑克牌， 抓到一张和前面已有的比较， 如果更小则更换位置
     * @param arr
     */
    public static void insertSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (Utils.less(arr[j], arr[j - 1])) {
                    Utils.exch(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = "INSERTSOTR".toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }
        insertSort(characters);
        System.out.println(Arrays.toString(characters));
    }

//    public static void insertSort2(Comparable[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0 && Utils.less(); j--) {
//
//            }
//
//        }
//    }
}
