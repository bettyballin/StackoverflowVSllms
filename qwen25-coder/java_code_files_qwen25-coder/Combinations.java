import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Character>> generateCombinations(char[] letters, int k) {
        List<List<Character>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), letters, 0, k);
        return combinations;
    }

    private static void backtrack(List<List<Character>> combinations, List<Character> tempList, char[] letters, int start, int k) {
        if (tempList.size() == k) {
            combinations.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= letters.length - k + tempList.size(); i++) {
            tempList.add(letters[i]);
            backtrack(combinations, tempList, letters, i + 1, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int k = 3;
        List<List<Character>> result = generateCombinations(letters, k);
        for (List<Character> combination : result) {
            System.out.println(combination);
        }
    }
}