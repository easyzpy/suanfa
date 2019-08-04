import com.sun.istack.internal.NotNull;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Date;
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
}
