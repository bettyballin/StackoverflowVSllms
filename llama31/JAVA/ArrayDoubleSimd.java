import java.util.ArrayList;
import java.util.List;

public class ArrayDoubleSimd {
    private List<Double> list;

    public ArrayDoubleSimd() {
        list = new ArrayList<>();
    }

    public void add(double element) {
        list.add(element);
    }

    public double get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        // Example usage:
        ArrayDoubleSimd array = new ArrayDoubleSimd();
        array.add(1.0);
        array.add(2.0);
        array.add(3.0);
        System.out.println("Size: " + array.size());
        System.out.println("Element at index 1: " + array.get(1));
    }
}