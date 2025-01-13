/*
 * Decompiled with CFR 0.152.
 */
import java.math.RoundingMode;

public class RoundingCalculator {
    public int round(RoundingMode roundingMode) {
        if (roundingMode == RoundingMode.HALF_UP || roundingMode == RoundingMode.HALF_EVEN) {
            // empty if block
        }
        return 0;
    }

    public static void main(String[] stringArray) {
        RoundingCalculator roundingCalculator = new RoundingCalculator();
        roundingCalculator.round(RoundingMode.HALF_UP);
    }
}
