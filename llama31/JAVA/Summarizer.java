import java.lang.String;
import java.util.LinkedList;
import java.util.Collection;

public class Summarizer {
    public static double msum(double... values) {
        LinkedList<Double> partials = new LinkedList<>();

        for (double x : values) {
            if (Double.isNaN(x) || Double.isInfinite(x)) {
                throw new ArithmeticException("Input contains NaN or infinite values");
            }

            int i = 0;
            for (double y : partials) {
                if (Math.abs(x) < Math.abs(y)) {
                    double tmp = x;
                    x = y;
                    y = tmp;
                }
                double hi = x + y;
                double lo = y - (hi - x);
                if (lo != 0.0) {
                    partials.set(i, lo);
                    ++i;
                }
                x = hi;
            }
            if (i < partials.size()) {
                partials.set(i, x);
                partials.subList(i + 1, partials.size()).clear();
            } else {
                partials.add(x);
            }
        }
        return sum(partials);
    }

    public static double sum(Collection<Double> values) {
        double s = 0.0;
        for (Double d : values) {
            s += d;
        }
        return s;
    }

	public static void main(String[] args) {
	}
}