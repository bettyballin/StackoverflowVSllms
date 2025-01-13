/*
 * Decompiled with CFR 0.152.
 */
import java.lang.invoke.CallSite;
import java.util.HashSet;

public class KolmogorovComplexityCalculator {
    public double kComplexity(String string) {
        HashSet<CallSite> hashSet = new HashSet<CallSite>();
        StringBuilder stringBuilder = new StringBuilder();
        double d = 0.0;
        for (char c : string.toCharArray()) {
            if (!hashSet.add((CallSite)((Object)(stringBuilder.toString() + c)))) {
                stringBuilder.append(c);
                continue;
            }
            d += 1.0;
            stringBuilder = new StringBuilder();
        }
        if (stringBuilder.length() != 0) {
            d += 1.0;
        }
        return d;
    }

    public static void main(String[] stringArray) {
        KolmogorovComplexityCalculator kolmogorovComplexityCalculator = new KolmogorovComplexityCalculator();
    }
}
