import java.util.List;
import java.util.ArrayList;

class Item {
    int A, B, C;

    Item(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
}

public class OptimalItemSelector {

    private static void backtrack(List<List<Item>> lists, int index, int currentSumA, int currentSumB, int currentSumC,
                                  int minB, int eqC, List<Item> currentSelection, List<Item> bestSelection) {
        if (index == lists.size()) {
            if (currentSumB >= minB && currentSumC == eqC) {
                if (bestSelection.isEmpty() || currentSumA > evaluateSumA(bestSelection)) {
                    bestSelection.clear();
                    bestSelection.addAll(currentSelection);
                }
            }
            return;
        }

        List<Item> currentList = lists.get(index);
        for (Item item : currentList) {
            currentSelection.add(item);
            backtrack(lists, index + 1, currentSumA + item.A, currentSumB + item.B, currentSumC + item.C,
                      minB, eqC, currentSelection, bestSelection);
            currentSelection.remove(currentSelection.size() - 1);
        }
    }

    private static int evaluateSumA(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += item.A;
        }
        return sum;
    }

    public static List<Item> findOptimalCombination(List<List<Item>> lists, int minB, int eqC) {
        List<Item> bestSelection = new ArrayList<>();
        backtrack(lists, 0, 0, 0, 0, minB, eqC, new ArrayList<>(), bestSelection);
        return bestSelection;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Item>> lists = new ArrayList<>();
        // Fill lists with items...
        int minBConstraint = 10; // Minimum B constraint
        int eqCConstraint = 5;   // C must equal this value

        List<Item> optimalItems = findOptimalCombination(lists, minBConstraint, eqCConstraint);
        System.out.println("Optimal selection:");
        for (Item item : optimalItems) {
            System.out.println("A: " + item.A + ", B: " + item.B + ", C: " + item.C);
        }
    }
}