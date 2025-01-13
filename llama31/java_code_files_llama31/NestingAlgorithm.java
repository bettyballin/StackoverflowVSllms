/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NestingAlgorithm {
    public static void main(String[] stringArray) {
        List<Cut> list = Arrays.asList(new Cut(2, 5), new Cut(3, 5), new Cut(4, 5));
        List<Stock> list2 = Arrays.asList(new Stock(10));
        List<Nest> list3 = NestingAlgorithm.generateNests(list, list2);
        list3.sort(Comparator.comparingInt(nest -> nest.waste));
        List<Nest> list4 = NestingAlgorithm.findOptimalNests(list3, list);
        System.out.println("Optimal nests:");
        for (Nest nest2 : list4) {
            System.out.println("Stock: " + nest2.stock.length);
            System.out.println("Cuts: " + String.valueOf(nest2.cuts));
            System.out.println("Waste: " + nest2.waste);
            System.out.println();
        }
    }

    private static List<Nest> generateNests(List<Cut> list, List<Stock> list2) {
        ArrayList<Nest> arrayList = new ArrayList<Nest>();
        for (Stock stock : list2) {
            for (int i = 0; i < 1 << list.size(); ++i) {
                ArrayList<Cut> arrayList2 = new ArrayList<Cut>();
                for (int j = 0; j < list.size(); ++j) {
                    if ((i & 1 << j) == 0) continue;
                    arrayList2.add(list.get(j));
                }
                if (arrayList2.isEmpty()) continue;
                arrayList.add(new Nest(stock, arrayList2));
            }
        }
        return arrayList;
    }

    private static List<Nest> findOptimalNests(List<Nest> list, List<Cut> list2) {
        ArrayList<Nest> arrayList = new ArrayList<Nest>();
        ArrayList<Cut> arrayList2 = new ArrayList<Cut>(list2);
        while (!arrayList2.isEmpty()) {
            Nest nest = null;
            for (Nest nest2 : list) {
                if (!NestingAlgorithm.isNestValid(nest2, arrayList2) || nest != null && nest2.waste >= nest.waste) continue;
                nest = nest2;
            }
            if (nest == null) break;
            arrayList.add(nest);
            NestingAlgorithm.removeCutsFromList(arrayList2, nest.cuts);
        }
        return arrayList;
    }

    private static boolean isNestValid(Nest nest, List<Cut> list) {
        for (Cut cut : nest.cuts) {
            if (list.contains(cut)) continue;
            return false;
        }
        return true;
    }

    private static void removeCutsFromList(List<Cut> list, List<Cut> list2) {
        block0: for (Cut cut : list2) {
            for (Cut cut2 : list) {
                if (!cut2.equals(cut)) continue;
                cut2.quantity -= cut.quantity;
                if (cut2.quantity != 0) continue block0;
                list.remove(cut2);
                continue block0;
            }
        }
    }

    static class Cut {
        int length;
        int quantity;

        public Cut(int n, int n2) {
            this.length = n;
            this.quantity = n2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            Cut cut = (Cut)object;
            return this.length == cut.length && this.quantity == cut.quantity;
        }
    }

    static class Stock {
        int length;

        public Stock(int n) {
            this.length = n;
        }
    }

    static class Nest {
        Stock stock;
        List<Cut> cuts;
        int waste;

        public Nest(Stock stock, List<Cut> list) {
            this.stock = stock;
            this.cuts = list;
            this.waste = this.calculateWaste(stock, list);
        }

        private int calculateWaste(Stock stock, List<Cut> list) {
            int n = 0;
            for (Cut cut : list) {
                n += cut.length * cut.quantity;
            }
            return stock.length - n;
        }
    }
}
