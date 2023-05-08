import org.junit.Test;

import java.util.Arrays;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import vo.Drawing;

public class Demo02 {

    @Test
    public void test7() {
        countTest(5);
    }
    @Test
    public void test6() {
        int[] ints = In.readInts("16Kints.txt");
//        Stopwatch timer = new Stopwatch();
        long start = System.currentTimeMillis();
        StdOut.println(count(ints));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    private int count(int[] a) {
        int N = a.length;
        System.out.println(a.length);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private void countTest(int length) {
        for (int i = 0; i < length; i++) {
            System.out.println("   ");
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    System.out.println(i + "+" + j + "+" + k);

                }

            }

        }
    }
    @Test
    public void test5() {
        In in = new In("ints.txt");
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = q.dequeue();
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 背包 求标准差
     */
    @Test
    public void test4() {
        Bag<Double> numbers = new Bag<>();
        numbers.add(100D);
        numbers.add(99D);
        numbers.add(101D);
        numbers.add(120D);
        numbers.add(98D);
        numbers.add(107D);
        numbers.add(109D);
        numbers.add(81D);
        numbers.add(101D);
        numbers.add(90D);
        int N = numbers.size();
        System.out.println(N);
        double sum = 0D;
        for (Double number : numbers) {
            sum += number;
        }
        double mean = sum/N;

        sum = 0D;
        int count = 0;
        for (Double number : numbers) {
            sum += (number - mean) * (number - mean);
            count ++;
        }
        System.out.println(count);
        double std = Math.sqrt(sum / (N - 1));
        System.out.println("-----");
        System.out.println(mean);
        System.out.println(std);
    }

    /**
     * 可视化累加数据的抽象数据类型使用样例
     */
    @Test
    public void test3() {
        final int a = 3;
        final String s = "asdf";
        String b = "safdf";
        final Drawing drawing = new Drawing();
        drawing.setInquiryOrderItemId("asfd");

    }
    /**
     * 一个能够累加数据的抽象数据类型使用样例
     */
    @Test
    public void test2() {
        int T = 100;
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < T; i++) {
            double random = StdRandom.random();
            System.out.println(random);
            accumulator.addDataValue(random);
        }
        StdOut.println(accumulator);
    }
    @Test
    public void test1() {
        inOut(new String[]{"in1.txt","in2.txt", "out.txt"});
    }

    /**
     * In Out 用例
     * 将所有文件输出输出流（最后一个参数）中
     */
    private void inOut(String[] strArr) {
        Out out = new Out(strArr[strArr.length - 1]);
        for (int i = 0; i < strArr.length - 1; i++) {
            In in = new In(strArr[i]);
            String s = in.readAll();
            out.println(s);
            in.close();

        }
        out.close();
    }

}
