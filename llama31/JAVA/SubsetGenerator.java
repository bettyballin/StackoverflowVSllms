import java.lang.String;

public class SubsetGenerator {
    public static void generateSubsets(String input) {
        int n = input.length();
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder subset = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.append(input.charAt(i));
                }
            }
            System.out.println(subset.toString());
        }
    }

    public static void main(String[] args) {
        generateSubsets("abc");
    }
}