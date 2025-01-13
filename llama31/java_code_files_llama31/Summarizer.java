/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Summarizer {
    public static double msum(double ... dArray) {
        LinkedList<Double> linkedList = new LinkedList<Double>();
        for (double d : dArray) {
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new ArithmeticException("Input contains NaN or infinite values");
            }
            int n = 0;
            Iterator iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                double d2;
                double d3;
                double d4 = (Double)iterator.next();
                if (Math.abs(d) < Math.abs(d4)) {
                    d3 = d;
                    d = d4;
                    d4 = d3;
                }
                if ((d2 = d4 - ((d3 = d + d4) - d)) != 0.0) {
                    linkedList.set(n, d2);
                    ++n;
                }
                d = d3;
            }
            if (n < linkedList.size()) {
                linkedList.set(n, d);
                linkedList.subList(n + 1, linkedList.size()).clear();
                continue;
            }
            linkedList.add(d);
        }
        return Summarizer.sum(linkedList);
    }

    public static double sum(Collection<Double> collection) {
        double d = 0.0;
        for (Double d2 : collection) {
            d += d2.doubleValue();
        }
        return d;
    }

    public static void main(String[] stringArray) {
    }
}
