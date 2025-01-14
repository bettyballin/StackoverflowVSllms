import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

public class CuttingStockProblem {
    public static void main(String[] args) {
        // Define required cuts {quantity, length}
        List<int[]> requiredCuts = new ArrayList<>();
        requiredCuts.add(new int[]{5, 2});
        requiredCuts.add(new int[]{5, 3});
        requiredCuts.add(new int[]{5, 4});

        // Define stock lengths
        int[] stockLengths = {10};

        // Step 1: Generate all possible cut combinations
        List<Combination> combinationList = generateCutCombinations(requiredCuts);

        // Step 2: Map cut combinations to stock lengths
        List<Nest> nestList = mapCombinationsToStock(combinationList, stockLengths);

        // Sort nests by waste
        Collections.sort(nestList, Comparator.comparingInt(n -> n.waste));

        // Step 3: Select valid nests with minimal waste
        List<Nest> finalNestList = selectValidNests(requiredCuts, nestList);

        // Output the result
        for (Nest nest : finalNestList) {
            System.out.println("Using stock of length " + nest.stock + ": Cuts = " + nest.cuts + ", Waste = " + nest.waste);
        }
    }

    private static List<Combination> generateCutCombinations(List<int[]> requiredCuts) {
        // Implement combination generation logic here
        // Simplified for demonstration; actual implementation should handle all combinations
        // including the optimization you mentioned in step 1.
        List<Combination> results = new ArrayList<>();
        for (int[] cut : requiredCuts) {
            List<int[]> cuts = new ArrayList<>();
            cuts.add(cut);
            results.add(new Combination(cuts));
        }
        return results;
    }

    private static List<Nest> mapCombinationsToStock(List<Combination> combinationList, int[] stockLengths) {
        List<Nest> nests = new ArrayList<>();
        for (Combination combination : combinationList) {
            for (int stockLength : stockLengths) {
                if (combination.totalLength <= stockLength) {
                    Nest nest = new Nest(stockLength, combination.cuts, stockLength - combination.totalLength);
                    nests.add(nest);
                }
            }
        }
        return nests;
    }

    private static List<Nest> selectValidNests(List<int[]> requiredCuts, List<Nest> nestList) {
        Map<Integer, Integer> cutMap = new HashMap<>();
        for (int[] cut : requiredCuts) {
            int key = cut[0] * 100 + cut[1]; // Simple key encoding
            cutMap.put(key, cut[0]);
        }
        List<Nest> finalNests = new ArrayList<>();

        while (!cutMap.isEmpty()) {
            boolean foundNest = false;
            for (Nest nest : nestList) {
                boolean isValid = true;
                Map<Integer, Integer> tempCutMap = new HashMap<>(cutMap);
                for (int[] cut : nest.cuts) {
                    int key = cut[0] * 100 + cut[1];
                    if (!tempCutMap.containsKey(key) || tempCutMap.get(key) == 0) {
                        isValid = false;
                        break;
                    } else {
                        tempCutMap.put(key, tempCutMap.get(key) - 1);
                    }
                }
                if (isValid) {
                    finalNests.add(nest);
                    foundNest = true;
                    for (int[] cut : nest.cuts) {
                        int key = cut[0] * 100 + cut[1];
                        cutMap.put(key, cutMap.get(key) - 1);
                        if (cutMap.get(key) <= 0) {
                            cutMap.remove(key);
                        }
                    }
                    break;
                }
            }
            if (!foundNest) {
                break;
            }
        }
        return finalNests;
    }

    static class Combination {
        List<int[]> cuts;
        int totalLength;

        Combination(List<int[]> cuts) {
            this.cuts = cuts;
            this.totalLength = cuts.stream().mapToInt(c -> c[1]).sum();
        }
    }

    static class Nest {
        int stock;
        List<int[]> cuts;
        int waste;

        Nest(int stock, List<int[]> cuts, int waste) {
            this.stock = stock;
            this.cuts = cuts;
            this.waste = waste;
        }
    }
}