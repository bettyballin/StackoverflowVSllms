/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ArrayDoubleSimd {
    private List<Double> list = new ArrayList<Double>();

    public void add(double d) {
        this.list.add(d);
    }

    public double get(int n) {
        return this.list.get(n);
    }

    public int size() {
        return this.list.size();
    }

    public static void main(String[] stringArray) {
        ArrayDoubleSimd arrayDoubleSimd = new ArrayDoubleSimd();
        arrayDoubleSimd.add(1.0);
        arrayDoubleSimd.add(2.0);
        arrayDoubleSimd.add(3.0);
        System.out.println("Size: " + arrayDoubleSimd.size());
        System.out.println("Element at index 1: " + arrayDoubleSimd.get(1));
    }
}
