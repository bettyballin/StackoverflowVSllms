/*
 * Decompiled with CFR 0.152.
 */
public class ValueSetter {
    private int value;

    public void setValue() {
        this.value = 0;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public static void main(String[] stringArray) {
        ValueSetter valueSetter = new ValueSetter();
        valueSetter.setValue(10);
        System.out.println("Value is set");
    }
}
