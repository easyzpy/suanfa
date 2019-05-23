package util;

public class Utils {
    /**
     * 求1 到 10 的中间的数字
     * 1,2,3,4  ,5,6, 7,8,9,10  5,6
     * 11/2 = 5
     * 3 -- 10中间的数字
     * 3,4,5  ,6,7 ,8,9,10  6,7
     * (3+10)/2 = 6
     * 3 + (10 - 3)/2 = 6
     * 4-10
     * 4,5,6  ,7  ,8,9,10
     * 14/2 = 7
     * 4 + (10 - 4)/2 = 7
     *
     */
    public static int binarySearch(int key, int[] a){
        if (a == null || a.length == 0){
            return -1;
        }
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]){
                hi = mid - 1;
            }else if (key > a[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    //(hi + lo )/2 = lo + (hi-lo)/2
    //hi + lo = 2lo + hi - lo
    //上面证明了 int mid = lo + (hi - lo) / 2; 和 int mid = (lo + hi)/2;是完全相同的
    public static int commonSearch(int key, int[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key){
                return i;
            }
        }
        return -1;
    }
}
