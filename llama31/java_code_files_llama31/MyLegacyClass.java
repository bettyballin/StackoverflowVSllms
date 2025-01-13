/*
 * Decompiled with CFR 0.152.
 */
public class MyLegacyClass {
    private final String jndiName;

    public MyLegacyClass(String string) {
        this.jndiName = string;
    }

    public Object doSomeLegacyStuff(Object object) {
        return null;
    }

    public static void main(String[] stringArray) {
        MyLegacyClass myLegacyClass = new MyLegacyClass("someJndiName");
        myLegacyClass.doSomeLegacyStuff(null);
    }
}
