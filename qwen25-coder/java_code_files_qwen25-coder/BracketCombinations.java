import java.util.ArrayList;
import java.util.List;

public class BracketCombinations {

    public static void main(String[] args) {
        Brackets(3);
    }

    public static void Brackets(int n) {
        List<String> result = new ArrayList<>();
        generateBrackets(result, "", 0, 0, n);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void generateBrackets(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generateBrackets(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            generateBrackets(result, current + ")", open, close + 1, n);
        }
    }
}