/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_30 {
    private int instanceVar = 0;

    public synchronized void setInstanceVar() {
        ++this.instanceVar;
    }

    public synchronized int getInstanceVar() {
        return this.instanceVar;
    }

    public static void main(String[] stringArray) {
    }
}
