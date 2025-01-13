/*
 * Decompiled with CFR 0.152.
 */
public class HttpRedirector {
    public static void main(String[] stringArray) throws Exception {
        String string = "URL";
        Object var2_2 = null;
        String string2 = var2_2.encodeURL(string);
        var2_2.sendRedirect(string2);
    }
}
