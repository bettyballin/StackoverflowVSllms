/*
 * Decompiled with CFR 0.152.
 */
public class HttpServletResponseSetter {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        if (var1_1 != null) {
            var1_1.setHeader("Content-Type", "text/plain");
            var1_1.setCharacterEncoding(null);
        } else {
            System.out.println("No HttpServletResponse instance available.");
        }
    }
}
