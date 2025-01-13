/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

static class NestingAlgorithm.Nest {
    NestingAlgorithm.Stock stock;
    List<NestingAlgorithm.Cut> cuts;
    int waste;

    public NestingAlgorithm.Nest(NestingAlgorithm.Stock stock, List<NestingAlgorithm.Cut> list) {
        this.stock = stock;
        this.cuts = list;
        this.waste = this.calculateWaste(stock, list);
    }

    private int calculateWaste(NestingAlgorithm.Stock stock, List<NestingAlgorithm.Cut> list) {
        int n = 0;
        for (NestingAlgorithm.Cut cut : list) {
            n += cut.length * cut.quantity;
        }
        return stock.length - n;
    }
}
