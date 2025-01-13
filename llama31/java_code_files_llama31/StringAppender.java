/*
 * Decompiled with CFR 0.152.
 */
public class StringAppender {
    public static void main(String[] stringArray) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 1;
        stringBuffer.append("a").append(n);
        String string = stringBuffer.toString();
        System.out.println(string);
    }
}
