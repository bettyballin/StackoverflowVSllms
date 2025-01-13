import java.util.HashSet;
import java.util.Set;

public class KolmogorovComplexityCalculator {
    public double kComplexity(String s) {
        Set<String> dictionary = new HashSet<>();
        StringBuilder w = new StringBuilder();
        double comp = 0;
        for (char c : s.toCharArray()) {
            if (!dictionary.add(w.toString() + c)) {
                w.append(c);
            } else {
                comp++;
                w = new StringBuilder();
            }
        }
        if (w.length() != 0) {
            comp++;
        }
        return comp;
    }
    public static void main(String[] args) {
        KolmogorovComplexityCalculator calculator = new KolmogorovComplexityCalculator();
        // You can add test cases here, for example:
        // System.out.println(calculator.kComplexity("example"));
    }
}