import org.junit.Test;

import edu.princeton.cs.algs4.Counter;
import util.Utils;

public class Demo {
    @Test
    public void test1(){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = Utils.binarySearch(3, a);
        System.out.println(i);
    }
    @Test
    public void test2(){
        int size = 1 * 10000 * 10000;
        int[] a = new int[size];
        long beg, end;
        for (int i = 0; i < a.length; i++) {
             a[i] = i;
        }

        beg = System.currentTimeMillis();
        int i = Utils.binarySearch(1 * 10000 * 10000, a);
        end = System.currentTimeMillis();
        System.out.println(i + "  " + (end - beg));
        System.out.println("--------------");
        beg = System.currentTimeMillis();
        i = Utils.commonSearch(1 * 10000 * 10000, a);
        end = System.currentTimeMillis();
        System.out.println(i + "  " + (end - beg));
    }
    @Test
    public void test3(){
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        heads.increment();
        int i = heads.tally() - tails.tally();

        System.out.println(i);

    }
}
