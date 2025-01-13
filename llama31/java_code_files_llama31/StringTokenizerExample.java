/*
 * Decompiled with CFR 0.152.
 */
public class StringTokenizerExample {
    public static void main(String[] stringArray) {
        StringTokenizerExample stringTokenizerExample = new StringTokenizerExample();
        stringTokenizerExample.tokenize();
    }

    public void tokenize() {
        String[] stringArray;
        String string = "abc,bcc,";
        for (String string2 : stringArray = string.split(",", -1)) {
            System.out.println(string2);
        }
    }
}
