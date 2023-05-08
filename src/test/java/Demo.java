import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import util.Utils;
import vo.CloneBean;
import vo.Drawing;
import vo.InquiryOrderItem;

public class Demo {
    @Test
    public void test12() {
        System.out.println(this.getClass().getResource(""));
    }

    /**
     * Interval2D测试用例
     */
    @Test
    public void test11() {
        double xlo = 0.2D;
        double xhi = .5D;
        double ylo = .5D;
        double yhi = .6D;
        int T = 10000000;
        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
        Counter c = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                c.increment();
            } else {
                p.draw();
            }
            StdOut.print(c);
            StdOut.println(box.area());
            if (i == T - 1) {
                System.out.println();
            }
        }
    }

    /**
     * 模拟T次掷骰子 uniform 返回 a - b 的一个随机数 左闭右开区间
     */
    @Test
    public void test10() {
        int T = 600000;//times
        int SIDES = 6;//dice sides
        //设置一个色子
        Counter[] rolls = new Counter[SIDES + 1];
        //初始化一个一个6面的色子 从1开始
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "side");
        }
        //掷色子
        for (int i = 0; i < T; i++) {
            int result = StdRandom.uniform(1, SIDES + 1);
//            System.out.println(result);
            rolls[result].increment();
        }
        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);

        }
    }

    @Test
    public void test9() {
//        System.out.println(null instanceof BigDecimal);
        Counter c1 = new Counter("ones");
        c1.increment();
        Counter c2 = c1;
        c2.increment();
        System.out.println(c1);

    }

    /**
     * 模拟T次掷硬币 StdRandom.bernoulli 从伯努利分布中以成功概率返回随机布尔值
     */
    @Test
    public void test8() {
        int T = 10000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));

    }

    @Test
    public void test1() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = Utils.binarySearch(3, a);
        System.out.println(i);
    }

    @Test
    public void test2() {
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
    public void test3() {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        heads.increment();
        int i = heads.tally() - tails.tally();
        System.out.println(i);
    }

    @Test
    public void test4() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException {
        ArrayList<InquiryOrderItem> list = new ArrayList<>();
        list.add(new InquiryOrderItem("1", "a"));
        list.add(new InquiryOrderItem("2", "b"));
        list.add(new InquiryOrderItem("3", "c"));
        list.add(new InquiryOrderItem("4", "d"));
        list.add(new InquiryOrderItem("5", "e"));
        list.add(new InquiryOrderItem("6", "f"));
        list.add(new InquiryOrderItem("7", "g"));
        list.add(new InquiryOrderItem("8", "h"));
        list.add(new InquiryOrderItem("9", "i"));
        list.add(new InquiryOrderItem("10", "i"));
        list.add(new InquiryOrderItem("11", "i"));
        list.add(new InquiryOrderItem("12", "i"));
        list.add(new InquiryOrderItem("14", "i"));
        list.add(new InquiryOrderItem("15", "i"));

        ArrayList<Drawing> drawList = new ArrayList<>();

        drawList.add(new Drawing("a"));
        drawList.add(new Drawing("b"));
        drawList.add(new Drawing("c"));
        drawList.add(new Drawing("d"));
        drawList.add(new Drawing("e"));
        drawList.add(new Drawing("f"));
        drawList.add(new Drawing("g"));
        drawList.add(new Drawing("h"));
        drawList.add(new Drawing("i"));

        ArrayList<Drawing> fillList = new ArrayList<>();
        for (InquiryOrderItem inquiryOrderItem : list) {
            for (Drawing drawing : drawList) {
                if (drawing.getVersionId().equals(inquiryOrderItem.getVersionId())) {
                    if (drawing.getInquiryOrderItemId() != null) {
//                        Drawing d = new Drawing();
//                        PropertyUtils.copyProperties(d, drawing);
//                        drawing.setInquiryOrderItemId(inquiryOrderItem.getInquiryOrderItemId());
//                        fillList.add(drawing);
//                        Drawing clone = ObjectUtils.clone(drawing);
                        Drawing clone = drawing.clone();
                        clone.setInquiryOrderItemId(inquiryOrderItem.getInquiryOrderItemId());
                        fillList.add(clone);
                        break;
                    }
                    drawing.setInquiryOrderItemId(inquiryOrderItem.getInquiryOrderItemId());
                    break;
                }
            }
        }
        drawList.addAll(fillList);
        System.out.println(drawList);
    }

    @Test
    public void test5() {
        String shortClassName = ClassUtils.getShortClassName(new Drawing(), null);
        System.out.println(shortClassName);
    }

    @Test
    public void test6() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CloneBean cloneBean = new CloneBean();
        cloneBean.setArr(new String[]{"1", "2"});
        cloneBean.setBirthday(new java.util.Date());
        cloneBean.setId("123");

        InquiryOrderItem inquiryOrderItem = new InquiryOrderItem();
        inquiryOrderItem.setInquiryOrderItemId("asdfafs");
        inquiryOrderItem.setVersionId(":afsdafasd");

        cloneBean.setInquiryOrderItem(inquiryOrderItem);

        CloneBean dest = new CloneBean();
        PropertyUtils.copyProperties(dest, cloneBean);
        System.out.println();
    }

    @Test
    public void test7() {
//        BeanUtils.copyProperties();
//        BeanUtils.copyProperties();
    }
    /*2023 */
    @Test
    public void test202301() {
        double v = 2.0e-6 * 100000000.1;
        System.out.println(v);
        double v1 = (1 + 2.236) / 2;
        System.out.println(v1);
        if (4.1 >= 4) {

        }
    }

    /**
     * 第一张里纳西1.15
     */
    public static void main(String[] args) {
        if (Double.parseDouble(args[0]) == Double.parseDouble(args[1]) && Double.parseDouble(args[1]) == Double.parseDouble(args[2])) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    @Test
    public void test116() {
        int f = 0, g = 1;
        for (int i = 0; i < 16; i++) {
            System.out.println(f + " " + g);
            f = f + g;
            g = f - g;
        }
        //      f=0 g=1
        //i==0  f=1 g=0
        //i==1  f=1 g=1
        //i==2  f=2 g=1
        //i==3  f=3 g=2
        //i==4  f=5 g=3
        //i==5  f=8 g=5
        //i==6  f=13 g=8
    }

    @Test
    public void Test117a() {
        double t = 9.0D;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            t = (9.0 / t + t) / 2.0;
            System.out.println(t);
        }
        System.out.println("---------");
        System.out.printf("%.5f", t);
    }

    @Test
    public void test117b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {//执行999次  1-999
            for (int j = 0; j < i; j++) {
                //第一次 i = 1 执行1次
                //第二次 i = 2 执行2次
                //第三次 i = 3 执行3次
                //第N次 i = N 执行 N次
                /*内循环次数为 1 + 2 + 3 + ... + N
                N = 999
                等差数列求解
                N * a1 + N(N-1)d/2
                999 * 1 + 999(998)*1/2 = 499500
                */

                sum++;
            }

        }
        System.out.println(sum);
    }

    @Test
    public void test117c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {//1 2 4 8 16 32 64 128 256 512
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);//10000
        //上面的姐
        int count = 0;
        int i = 0b1;
        while (i < 1000) {
            i = i << 1;
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void test118() {
        System.out.println('b');//b
        System.out.println('b' + 'c');//197
        System.out.println(((char)('a' + 4)));//a b c d e 所以结果是e
    }
    @Test
    public void test119(){
        int a = 118;
        System.out.println(toBinaryString(a));
        System.out.println(toCustomBinarySearch(a, 2));
        System.out.println(toCustomBinarySearch(a, 8));
        System.out.println(toCustomBinarySearch(a, 16));

    }

    public String toBinaryString(int n) {
        //写一段代码 将正整数（十进制）用二进制表示
        String s = "";
        for (int i = n; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        return s;
    }

    public String toCustomBinarySearch(int n, int jinzhi) {
        String s = "";

        do {
            int result = n % jinzhi;
            s = result + s;
            n = n / jinzhi;
        } while (n != 0);
        return s;
    }

    @Test
    public void test1112() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test1113() {
        //打编写一段代码， 打印出一个M行N列的二维数组转换装置(交换行和列）
        //1 2 3 4 5 6 7
        //1 2 3 4 5 6 7
        //转换为
        //1 1
        //2 2
        //3 3
        //4 4
        int[][] ints = new int[][]{{1, 2, 3}, {1, 2, 3}};
        System.out.println(Arrays.toString(ints));
        int[][] ints1 = swap2DArr(ints);
        System.out.println(Arrays.toString(ints1));

    }

    public int[][] swap2DArr(int[][] arr) {
        int[][] reArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                //i = 0, j = 0，1，2，3 遍历原数组
                reArr[j][i] = arr[i][j];
            }
        }
        return reArr;
    }
    @Test
    public void test1114(){
        //编写一个静态方法lg() 参数为int 返回不大于 log2N 的最大整数
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " " + lg(i));
        }
    }

    public static int lg(int N) {
        //log2N = 2 * 2 * 2... N
        //表示 2 的多少次方等于N     参数    返回值
        //log 2 0 不存在            0       Na
        //log 2 1 = 0              1       0
        //log 2 2 = 1              2       1
        //log 2 3 = 1 < x < 2      3       1
        //log 2 4 = 2              4       2
        //log 2 5 = 2 < x < 3      5       2
        //log 2 6 = 2 < x < 3      6       2
        //log 2 7 = 2 < x < 3      7       2
        //log 2 8 = 3              8       3
        int logInt = 0;
        while (N > 0) {
            logInt++;
            N /= 2;
        }
        return --logInt;
    }


    @Test
    public void test1115() {
        //编写一个静态方法histogram() 接收一个a[]参数 和一个int M 返回一个大小为M的数组
        //其中第i个元素的值为整数i在数组中出现的次数，如果a[] 中的值均为0到M-1之间， 返回数组中所有元之和应该和a.length相等。
        int[] arr = {1, 1, 1, 3, 3, 3, 3, 2, 5, 5, 5, 5};
        int[] histogram = histogram(arr, arr.length);
        int[] histogram1 = histogram1(arr, arr.length);
        System.out.println(Arrays.toString(histogram));
        System.out.println(Arrays.toString(histogram1));
    }
    public static int[] histogram(int[] a, int M) {
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <a.length; j++) {
                if (i == a[j]) {
                    arr[i] += 1;
                }
            }
        }
        return arr;

    }
    private static int[] histogram1(int[] a, int m) {
        int[] newArr = new int[m];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) {
                newArr[a[i]]++;
            }
        }
        return newArr;
    }

    @Test
    public void test1116() {
        String str = exR1(6);
        System.out.println(str);
        System.out.println(count);
        //1 exR1(6 - 3)                                                                                          + 6 + exR1(6 - 2) + n;
        //2 exR1(3 - 3)                             + 3 + exR1(3 - 2) + 3;
        //2 exR1(0 - 3) + 0 + exR1(0 - 2) + 0 结果为""+0+""+0

    }

    private static int count = 0;
    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        count++;
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    @Test
    public void test1118() {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
        System.out.println(mystery1(2, 25));
        System.out.println(mystery1(3, 11));
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }
    public static long mystery1(long a, long b) {
        if (b == 0) {
            return 1L;
        }
        if (b % 2 == 0) {
            return mystery1(a * a, b / 2L);
        }
        return mystery1(a * a, b / 2L) * a;
    }

    @Test
    public void test1119() {
//        for (int i = 0; i < 100; i++) {
//            StdOut.println(i + " "+F(i));
//        }
            int N=20;
            long [] a=new long[N];
            a[0]=0;
            a[1]=1;
            for (int i = 2; i <N ; i++)
            {
                a[i]=a[i-1]+a[i-2];
            }
            for (int i = 0; i <N ; i++)
            {
                System.out.println(i+" "+a[i]);
            }
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long F_fast(int N) {
        /*
            0 0
            1 1
            2 1
            3 2
            4 3
            5 5
            6 8
            7 13
            8 21
            9 34
        * */
        return N - 2;
    }

    @Test
    public void test1120() {
        System.out.println(factorial(101111));
    }
    @Test
    public void test1120A() {
        BigInteger num = BigInteger.ONE;

        for (int i = 1; i <= 101111; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }

        System.out.println(num);
        System.out.println("===================================================================");
        System.out.println("===================================================================");
        System.out.println("===================================================================");
        System.out.println("===================================================================");
        System.out.println("===================================================================");
        System.out.println(num.toString().length());
    }

    public long factorial(long N) {

        if (N == 1 || N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}
