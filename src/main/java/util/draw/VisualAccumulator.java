package util.draw;

import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double value) {
        N++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total/N);
    }

    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean (" + N + " value): "
                + String.format("%7.5f", mean());
    }
}
