import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Demo {
//    @Test
//    public void test1(){
//        StdRandom.setSeed(100);
//        for (int i = 0; i < 100; i++) {
//            int uniform = uniform(100);
//            System.out.println(uniform);
//        }
//    }
    public static void main(String[] args){

        int i = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int j = 0; j < i; j++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }

    }
}
