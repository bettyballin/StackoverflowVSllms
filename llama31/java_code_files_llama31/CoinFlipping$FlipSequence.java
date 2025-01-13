/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

static class CoinFlipping.FlipSequence {
    List<CoinFlipping.Flip> flips = new ArrayList<CoinFlipping.Flip>();

    CoinFlipping.FlipSequence() {
    }

    public CoinFlipping.FlipSequence append(CoinFlipping.Flip flip) {
        CoinFlipping.FlipSequence flipSequence = new CoinFlipping.FlipSequence();
        flipSequence.flips.addAll(this.flips);
        flipSequence.flips.add(flip);
        return flipSequence;
    }

    public int length() {
        return this.flips.size();
    }
}
