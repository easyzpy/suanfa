package sort;

import util.Utils;

import java.util.Arrays;

public class SelectSort {
    /**
     * 选择排序， index 0 - n 找出当前最小的元素放在最前面
     * 个人的理解， 非官方解释
     * @param arr
     */
    public static void selectSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (Utils.less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Utils.exch(arr, i, minIndex);
            }
        }

    }

    public static void main(String[] args) {
        char[] chars = "SELECTSORT".toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }
        selectSort(characters);
        System.out.println(Arrays.toString(characters));

    }

//    public static void selectSort2(Comparable[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (Utils.less(arr[j], arr[minIndex])) {
//                    Utils
//                }
//
//            }
//
//        }
//    }

}
