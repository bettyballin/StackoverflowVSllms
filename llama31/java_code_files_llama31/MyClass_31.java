/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_31 {
    private int instanceVar = 0;

    public synchronized void incrementInstanceVar() {
        ++this.instanceVar;
    }

    public synchronized void decrementInstanceVar() {
        --this.instanceVar;
    }

    public static void main(String[] stringArray) {
    }
}
