/*
 * Decompiled with CFR 0.152.
 */
public class CsvPreprocessor {
    public static void main(String[] stringArray) {
        String string = "foo,bar,n\n,a,bc,d\none,two,three\n,a,bc,d";
        String string2 = string.replaceAll("\n,", ",");
        System.out.println(string2);
    }
}
