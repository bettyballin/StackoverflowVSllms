import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Interpolator {
    public static void main(String[] args) {
        double[] a1 = {1, 4, 9, 16, 25, 36};
        double[] a2 = {6, 9, 14, 30};
        int newSize = a1.length + a2.length;

        List<Double> list1 = new ArrayList<>();
        for (double d : a1) {
            list1.add(d);
        }
        List<Double> list2 = new ArrayList<>();
        for (double d : a2) {
            list2.add(d);
        }

        int i = 0, j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (j == list2.size() || (i != list1.size() && list1.get(i) <= list2.get(j))) {
                double x = getInsertionPoint(); // calculate insertion point
                list1.add(i, Double.valueOf(estimateUsingLinearInterp(list1, x)));
                list2.add(j, Double.valueOf(estimateUsingLinearInterp(list2, x)));
            } else {
                i++;
            }
            if (j < list2.size() && (i == list1.size() || list2.get(j) <= list1.get(i))) {
                j = insertPointBetweenTwoKnownPoints(a2, j); // find where to insert next item from second array
            } else if (i < list1.size()) {
                i++;
            }
        }
        // ... // copy remaining elements
    }

    public static double getInsertionPoint() {
        // TODO: implement method to calculate insertion point
        return 0.0; // placeholder
    }

    public static double estimateUsingLinearInterp(List<Double> list, double x) {
        // TODO: implement estimation using linear interpolation
        return 0.0; // placeholder
    }

    public static int insertPointBetweenTwoKnownPoints(double[] array, int index) {
        // TODO: implement method to find where to insert next item from second array
        return index; // placeholder
    }
}