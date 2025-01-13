/*
 * Decompiled with CFR 0.152.
 */
static class RecalculationVisitor.1 {
    static final /* synthetic */ int[] $SwitchMap$NodeType;

    static {
        $SwitchMap$NodeType = new int[NodeType.values().length];
        try {
            RecalculationVisitor.1.$SwitchMap$NodeType[NodeType.OPERAND.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            RecalculationVisitor.1.$SwitchMap$NodeType[NodeType.BINARY_OPERATOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            RecalculationVisitor.1.$SwitchMap$NodeType[NodeType.UNARY_OPERATOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            RecalculationVisitor.1.$SwitchMap$NodeType[NodeType.FUNCTION.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
