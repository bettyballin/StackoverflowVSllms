/*
 * Decompiled with CFR 0.152.
 */
public class StringSplitter {
    public static void main(String[] stringArray) {
        String[] stringArray2;
        String string = "Hello,World\\,This,Is,A,Test";
        for (String string2 : stringArray2 = string.split("(?<!\\\\),")) {
            System.out.println(string2);
        }
    }
}
