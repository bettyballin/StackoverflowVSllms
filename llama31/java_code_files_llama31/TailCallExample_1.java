/*
 * Decompiled with CFR 0.152.
 */
public class TailCallExample_1 {
    public static void main(String[] stringArray) {
        TailCallExample_1.recursiveMethod(10);
    }

    public static void recursiveMethod(int n) {
        if (n == 0) {
            return;
        }
        TailCallExample_1.recursiveMethod(n - 1);
    }
}
