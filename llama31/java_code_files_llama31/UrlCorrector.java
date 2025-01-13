/*
 * Decompiled with CFR 0.152.
 */
public class UrlCorrector {
    public static void main(String[] stringArray) {
        String string = "ihttp://www.ourdomain.com/images/f2f3f4.gif";
        String string2 = string.replace("ihttp://", "http://");
        System.out.println(string2);
    }
}
