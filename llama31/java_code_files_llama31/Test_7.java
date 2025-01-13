/*
 * Decompiled with CFR 0.152.
 */
public class Test_7 {
    public static void modifyPrimitive(int n) {
        n = 10;
    }

    public static void modifyObject(StringBuilder stringBuilder) {
        stringBuilder.append(" modified");
    }

    public static void main(String[] stringArray) {
        int n = 5;
        Test_7.modifyPrimitive(n);
        System.out.println(n);
        StringBuilder stringBuilder = new StringBuilder("Hello");
        Test_7.modifyObject(stringBuilder);
        System.out.println(stringBuilder.toString());
    }
}
