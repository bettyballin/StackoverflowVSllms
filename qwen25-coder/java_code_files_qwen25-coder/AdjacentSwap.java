import java.util.List;
import java.util.ArrayList;

public class AdjacentSwap {
    public static List<String> swapAdjacent(String input) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < input.length() - 1; i++) {
            char[] chars = input.toCharArray();
            // Swap adjacent characters
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
            
            result.add(new String(chars));
        }
        
        return result;
    }

    public static void main(String[] args) {
        String baseString = "abcd";
        List<String> combinations = swapAdjacent(baseString);
        
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}