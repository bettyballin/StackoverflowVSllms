import java.util.*;

public class NestingAlgorithm {

    // Define a class to represent a cut
    static class Cut {
        int length;
        int quantity;

        public Cut(int length, int quantity) {
            this.length = length;
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Cut cut = (Cut) obj;
            return length == cut.length && quantity == cut.quantity;
        }
    }

    // Define a class to represent a stock
    static class Stock {
        int length;

        public Stock(int length) {
            this.length = length;
        }
    }

    // Define a class to represent a nest
    static class Nest {
        Stock stock;
        List<Cut> cuts;
        int waste;

        public Nest(Stock stock, List<Cut> cuts) {
            this.stock = stock;
            this.cuts = cuts;
            this.waste = calculateWaste(stock, cuts);
        }

        private int calculateWaste(Stock stock, List<Cut> cuts) {
            int totalCutLength = 0;
            for (Cut cut : cuts) {
                totalCutLength += cut.length * cut.quantity;
            }
            return stock.length - totalCutLength;
        }
    }

    public static void main(String[] args) {
        // Define the cuts and stocks
        List<Cut> cuts = Arrays.asList(
            new Cut(2, 5),
            new Cut(3, 5),
            new Cut(4, 5)
        );
        List<Stock> stocks = Arrays.asList(
            new Stock(10)
        );

        // Generate all possible nests
        List<Nest> nests = generateNests(cuts, stocks);

        // Sort the nests by waste
        nests.sort(Comparator.comparingInt(nest -> nest.waste));

        // Find the optimal mix of nests
        List<Nest> optimalNests = findOptimalNests(nests, cuts);

        // Print the result
        System.out.println("Optimal nests:");
        for (Nest nest : optimalNests) {
            System.out.println("Stock: " + nest.stock.length);
            System.out.println("Cuts: " + nest.cuts);
            System.out.println("Waste: " + nest.waste);
            System.out.println();
        }
    }

    private static List<Nest> generateNests(List<Cut> cuts, List<Stock> stocks) {
        List<Nest> nests = new ArrayList<>();
        for (Stock stock : stocks) {
            for (int i = 0; i < (1 << cuts.size()); i++) {
                List<Cut> cutsInNest = new ArrayList<>();
                for (int j = 0; j < cuts.size(); j++) {
                    if ((i & (1 << j)) != 0) {
                        cutsInNest.add(cuts.get(j));
                    }
                }
                if (!cutsInNest.isEmpty()) {
                    nests.add(new Nest(stock, cutsInNest));
                }
            }
        }
        return nests;
    }

    private static List<Nest> findOptimalNests(List<Nest> nests, List<Cut> cuts) {
        List<Nest> optimalNests = new ArrayList<>();
        List<Cut> remainingCuts = new ArrayList<>(cuts);
        while (!remainingCuts.isEmpty()) {
            Nest bestNest = null;
            for (Nest nest : nests) {
                if (isNestValid(nest, remainingCuts)) {
                    if (bestNest == null || nest.waste < bestNest.waste) {
                        bestNest = nest;
                    }
                }
            }
            if (bestNest != null) {
                optimalNests.add(bestNest);
                removeCutsFromList(remainingCuts, bestNest.cuts);
            } else {
                break;
            }
        }
        return optimalNests;
    }

    private static boolean isNestValid(Nest nest, List<Cut> remainingCuts) {
        for (Cut cut : nest.cuts) {
            if (!remainingCuts.contains(cut)) {
                return false;
            }
        }
        return true;
    }

    private static void removeCutsFromList(List<Cut> cuts, List<Cut> cutsToRemove) {
        for (Cut cutToRemove : cutsToRemove) {
            for (Cut cut : cuts) {
                if (cut.equals(cutToRemove)) {
                    cut.quantity -= cutToRemove.quantity;
                    if (cut.quantity == 0) {
                        cuts.remove(cut);
                    }
                    break;
                }
            }
        }
    }
}