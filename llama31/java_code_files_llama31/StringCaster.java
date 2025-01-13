/*
 * Decompiled with CFR 0.152.
 */
public class StringCaster {
    Object obj = "Hello";
    String str = (String)this.obj;

    public static void main(String[] stringArray) {
        StringCaster stringCaster = new StringCaster();
        System.out.println(stringCaster.str);
    }
}
