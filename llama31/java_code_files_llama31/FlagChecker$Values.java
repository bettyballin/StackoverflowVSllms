/*
 * Decompiled with CFR 0.152.
 */
public static enum FlagChecker.Values {
    ONE(1),
    TWO(2),
    THREE(4),
    FOUR(8),
    FIVE(16);

    private final int value;

    private FlagChecker.Values(int n2) {
        this.value = n2;
    }

    public int getValue() {
        return this.value;
    }
}
