import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    public static List<String> generateSubsets(String str) {
        List<String> subsets = new ArrayList<>();
        int n = str.length();
        
        // There are 2^n possible subsets for a set of size n
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder subset = new StringBuilder();
            
            // Check each bit of i to determine if the corresponding character is in this subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.append(str.charAt(j));
                }
            }
            
            subsets.add(subset.toString());
        }
        
        return subsets;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> subsets = generateSubsets(input);
        System.out.println(subsets);
    }
}