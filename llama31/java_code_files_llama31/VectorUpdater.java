/*
 * Decompiled with CFR 0.152.
 */
public class VectorUpdater {
    public static void main(String[] stringArray) {
        int n = 10;
        int n2 = 5;
        Object object = new Object();
        Object object2 = new Object();
        for (int i = 0; i < n; ++i) {
            if (VectorUpdater.conditionAtVectorPosition(object, i)) continue;
            boolean bl = false;
            for (int j = 0; j < n2 && !VectorUpdater.anotherConditionAtVector(object, j); ++j) {
                if (!VectorUpdater.conditionAtMatrixRowCol(object2, j, i)) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            VectorUpdater.setValueInVector(object, i);
        }
    }

    public static boolean conditionAtVectorPosition(Object object, int n) {
        return false;
    }

    public static boolean anotherConditionAtVector(Object object, int n) {
        return false;
    }

    public static boolean conditionAtMatrixRowCol(Object object, int n, int n2) {
        return false;
    }

    public static void setValueInVector(Object object, int n) {
    }
}
