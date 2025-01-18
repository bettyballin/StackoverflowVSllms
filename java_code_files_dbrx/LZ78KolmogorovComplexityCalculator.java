import java.util.Set;
import java.util.HashSet;

public class LZ78KolmogorovComplexityCalculator {
    /**
     * Uses the LZ78 compression algorithm to approximate Kolmogorov complexity of a String.<br>
     * <ul><li>&nbsp;@param s</li><li>&nbsp;@return the approximate Kolmogorov complexity.</li></ul>
     */
    public long kComplexity(String s) {
        Set<String> dictionary = new HashSet<>();
        StringBuilder w = new StringBuilder();
        long comp = 0L;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!dictionary.add(w.toString() + c)) { // dictionary.add returns true only if this set did not already contain the specified element.
                w.append(c);
            } else {
                comp++;
                w.setLength(0); // clear the StringBuilder
                w.append(c); // continue with next pattern starts from here
            }
        }
        return dictionary.contains(w.toString()) ? comp : ++comp; // handle the tail end of string if it's not in the set then increment the count by one.
    }
    public static void main(String[] args) {
    }
}