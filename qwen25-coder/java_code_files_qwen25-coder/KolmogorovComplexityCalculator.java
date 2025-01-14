import java.util.Set;
import java.util.HashSet;

public class KolmogorovComplexityCalculator {
    public double kComplexity(String s) {
        Set<String> dictionary = new HashSet<String>();
        StringBuilder w = new StringBuilder();
        double comp = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String wc = w.toString() + c;

            if (dictionary.contains(wc)) {
                w.append(c);
            } else {
                comp++;
                dictionary.add(wc);
                w.setLength(0); // Clear the StringBuilder
                w.append(c);
            }
        }

        if (w.length() != 0) {
            comp++;
        }

        return comp;
    }

    public static void main(String[] args) {
    }
}